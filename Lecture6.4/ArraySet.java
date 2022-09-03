import java.util.Iterator;

public class ArraySet<T> implements Iterable<T> {
    private T[] items;
    private int size;

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    public boolean contains(T x) {
        for (int i = 0; i < size; i ++) {
            if (items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    public void add(T x) {
        if (x == null) {
            throw new IllegalArgumentException("can not add null");
        }
        if (contains(x)) {
            return;
        }
        items[size] = x;
        size += 1;
    }

    public int size() {
        return size;
    }

    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    private class ArraySetIterator implements Iterator<T> {
        private int wizPos;

        public ArraySetIterator() {
            wizPos = 0;
        }

        public boolean hasNext() {
            return wizPos < size;
        }

        public T next() {
            T returnItem = items[wizPos];
            wizPos += 1;
            return returnItem;
        }

    }

    @Override
    public String toString() {
        StringBuilder returnSB = new StringBuilder("{");
        for (int i = 0; i < (size -1); i ++) {
            returnSB.append(items[i].toString());
            returnSB.append(",");
        }
        returnSB.append(items[size - 1].toString());
        returnSB.append("}");
        return returnSB.toString();

    }

/*    @Override
    public String toString() {
        List<String> listOfItems = new ArraySet<>();
        for (T x : this) {
            listOfItems.add(x);
        }
        return "{" + String.join(",", listOfItems) + "}";
    }*/

    public static <Glerp> ArraySet<Glerp> of (Glerp... stuff) {
        ArraySet<Glerp> returnArraySet = new ArraySet<Glerp>();
        for (Glerp item : stuff) {
            returnArraySet.add(item);
        }
        return returnArraySet;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        ArraySet<T> o = (ArraySet<T>) other;
        if (this.size != o.size) {
            return false;
        }
        for (T item : this) {
            if (!o.contains(item)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArraySet<Integer> aset = new ArraySet<Integer>();
        aset.add(3);
        aset.add(5);
        aset.add(7);

        for (int i : aset) {
            System.out.println(i);
        }

        ArraySet<Integer> aset2 = new ArraySet<Integer>();
        aset2.add(3);
        aset2.add(5);
        aset2.add(7);

        System.out.println(aset);
        System.out.println(aset.equals(aset2));
        System.out.println(aset.equals(aset));
        System.out.println(aset.equals(null));

        ArraySet<String> setOfString = ArraySet.of("I", "am", "superman");
        System.out.println(setOfString);

    }
}
