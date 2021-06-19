public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int first;
    private int last;
    private static final int initialCapacity = 8;
    /*the helper that get the position in front of the index's.*/
    private int minusOne(int index) {
        index = index - 1;
        if (index < 0) {
            index = index + items.length;
        }
        return index;
    }
    /*the helper that get the next position of index's*/
    private int plusOne(int index) {
        index = (index + 1) % items.length;
        return index;
    }
    /*the helper that get the ith position next to the index.*/
    private int plusI(int index, int i) {
        index = (index + i) % items.length;
        return index;
    }
    /*resize the deque with new capacity.*/
    private void resize(int capacity) {
        /*create new array.*/
        T[] newItems = (T[]) new Object[capacity];
        /*get the position of first item.*/
        int startPos = plusOne(first);
        /*copy every item to the new array*/
        for (int i = 0; i < size; i ++) {
            newItems[i] = items[startPos];
            startPos = plusOne(startPos);
        }
        /*replace old array with new array.*/
        items = newItems;
        /*reset the first and last.*/
        first = items.length - 1;
        last = size;
    }
    /*Creat an empty array deque.*/
    public ArrayDeque() {
        items = (T[]) new Object[initialCapacity];
        size = 0;
        /*according to the requirement of project 1A.
        * first located in the rear of array.
        * if their is not the requirement, first could be 0, and last could be 1.*/
        first = items.length - 1;
        last = 0;
    }
    /*add item to the front of deque*/
    public void addFirst(T item) {
        /*check if deque need to be resized.*/
        if (size == items.length - 1) {
            resize(items.length * 2);
        }
        items[first] = item;
        first = minusOne(first);
        size = size + 1;
    }
    /*add item to the back of deque*/
    public void addLast(T item) {
        /*check if deque need to be resized.*/
        if (size == items.length - 1) {
            resize(items.length * 2);
        }
        items[last] = item;
        last = plusOne(last);
        size = size + 1;
    }
    /*remove the first item of deque, and return the item.*/
    public T removeFirst() {
        /*check if the deque is empty*/
        if (size == 0) {
            return null;
        }
        /*get the position of first item.*/
        int firstPos = plusOne(first);
        T returnItem = items[firstPos];
        items[firstPos] = null;
        first = firstPos;
        size = size - 1;
        /*check if it need to be resized.*/
        if (items.length >= 16 && size <= items.length / 4) {
            resize(items.length / 2);
        }
        return returnItem;
    }
    /*remove the last item of deque, and return it.*/
    public T removeLast() {
        /*check if the deque is empty*/
        if (size == 0) {
            return null;
        }
        /*get the position of first item.*/
        int lastPos = minusOne(last);
        T returnItem = items[lastPos];
        items[lastPos] = null;
        last = lastPos;
        size = size - 1;
        /*check if it need to be resized.*/
        if (items.length >= 16 && size <= items.length / 4) {
            resize(items.length / 2);
        }
        return returnItem;
    }
    /*print hold deque.*/
    public void printDeque() {
        /*get the first position of items.*/
        int startPos = plusOne(first);
        for (int i = 0; i < size; i ++) {
            System.out.println(items[startPos] + " ");
            startPos = plusOne(startPos);
        }
        System.out.println("\n");
    }
    /*get the item at the given index, where 0 is the front.*/
    public T get(int index) {
        if (index >= size || index < 0){
            return null;
        }
        return items[plusI(first, index + 1)];
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

//    public static void main (String[] arg) {
//        ArrayDeque<Integer> testDeque = new ArrayDeque<Integer>();
//        testDeque.addFirst(1);
//        testDeque.addFirst(1);
//        testDeque.addFirst(1);
//        testDeque.addFirst(1);
//        testDeque.addFirst(1);
//        testDeque.addFirst(1);
//        testDeque.addFirst(1);
//        testDeque.addFirst(1);
//        testDeque.addFirst(1);
//        testDeque.addFirst(1);
//        testDeque.addFirst(1);
//        testDeque.addFirst(1);
//        testDeque.addFirst(1);
//        testDeque.addFirst(1);
//        testDeque.addFirst(1);
//        testDeque.addFirst(1);
//    }
}
