public class LinkedListDeque <T> {
    /*Define the inner class 'DNode'and the data structure of it.*/
    public static class DNode <T> {
        public T item;
        public DNode prev;
        public DNode next;
        public DNode (T x, DNode p, DNode n) {
            item = x;
            prev = p;
            next = n;
        }
    }
    /*Define the data structure of LinkedListDeque.*/
    private DNode sentinel;
    private int size;
    /*Create an empty linked list deque.*/
    public LinkedListDeque () {
        sentinel = new DNode (null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }
    /*Create an linked list deque with the first node.*/
    public LinkedListDeque (T x) {
        sentinel = new DNode (null, null, null);
        sentinel.next = new DNode (x, sentinel, sentinel);
        sentinel.prev = sentinel;
        size = 1;
    }
    /*Create a Deep copy of an deque.*/
    public LinkedListDeque (LinkedListDeque other) {
        sentinel = new DNode (null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = other.size;
        DNode p = sentinel;
        DNode q = other.sentinel;
        for (int i = 0; i < size; i += 1) {
            p.next = new DNode ((T) q.next.item, p, sentinel);
            p = p.next;
            q = q.next;
        }
        sentinel.prev = p;
    }
    /*Add an item of type T to the front of deque.*/
    public void addFirst (T item) {
        sentinel.next.prev = new DNode ((T) item, sentinel, sentinel.next);
        sentinel.next = sentinel.next.prev;
        size += 1;
    }
    /*Add an item of type T to the back of deque.*/
    public void addLast (T item) {
        sentinel.prev.next = new DNode ((T) item, sentinel.prev, sentinel);
        sentinel.prev = sentinel.prev.next;
        size += 1;
    }
    /*Return true if the deque is empty.*/
    public boolean isEmpty () {
        return (size == 0);
    }
    /*Return the number of items.*/
    public int size () {
        return size;
    }
    /*Print the items from first to last, seperate by a space.
    When all the items have been printed, print out a new line.*/
    public void printDeque () {
        DNode p = sentinel.next;
        for (int i = 0; i < size; i += 1) {
            System.out.println(p.item + " ");
            p = p.next;
        }
        System.out.println("\n");
    }
    /*Remove and return the first item of deque.
    * If the deque is empty, return null.*/
    public T removeFirst () {
        if (size == 0) {
            return null;
        }
        else {
            T firstItem = (T) sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            size -= 1;
            return firstItem;
        }
    }
    /*Remove and return the last item of deque.
     * If the deque is empty, return null.*/
    public T removeLast () {
        if (size == 0) {
            return null;
        }
        else {
            T lastItem = (T) sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            size -= 1;
            return lastItem;
        }
    }
    /*Gets the item at the given index, 0 is the first.
    If no such item exists, returns null.*/
    public T get (int index) {
        if (index > size - 1 || size == 0 || index < 0) {
            return null;
        }
        else {
            DNode p = sentinel.next;
            for (int i = 0; i < index; i += 1) {
                p = p.next;
            }
            return (T) p.item;
        }
    }
    /*Creat a helper to implement get method in a recursive way.*/
    private DNode getRecursiveHelper (DNode p, int x) {
        if (x == 0) {
            return p;
        }
        else {
            return getRecursiveHelper(p.next, x - 1);
        }
    }
    /*Has the same method as get(), but is implemented by recursion.*/
    public T getRecursive (int index) {
        if (index > size - 1 || size == 0 || index < 0) {
            return null;
        }
        else {
            return (T) getRecursiveHelper(sentinel.next, index).item;
        }
    }

    public static void main (String[] arg) {
        LinkedListDeque<Integer> testList = new LinkedListDeque<Integer>();
//        System.out.println(testList.isEmpty());
//        System.out.println(testList.size());
//        System.out.println(testList.get(-1));
//        System.out.println(testList.get(0));
        testList.addFirst(1);
        testList.addFirst(2);
        testList.addFirst(3);
        LinkedListDeque<Integer> testList2 = new LinkedListDeque<Integer>(testList);
        testList2.addLast(0);
        testList2.printDeque();
        testList.printDeque();
        System.out.println(testList2.getRecursive(-1));
        System.out.println(testList2.getRecursive(3));
//        System.out.println(testList.get(0));
//        System.out.println(testList.get(1));
//        System.out.println(testList.get(2));
//        System.out.println(testList.get(3));
//        System.out.println(testList.removeFirst());
//        System.out.println(testList.removeLast());
//        testList.printDeque();
//        System.out.println(testList.size());
    }
}

