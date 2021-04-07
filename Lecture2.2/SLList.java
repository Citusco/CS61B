public class SLList{
	public static class IntNode{
		public int item;
		public IntNode next;
		public IntNode(int i, IntNode n){
			item = i;
			next = n;
		}
	}
	private IntNode sentinel;
	private int size;

	public SLList(int x) {
		sentinel = new IntNode(63, null);
		sentinel.next = new IntNode(x, null);
		size = 1;
	}
	public SLList() {
		sentinel = new IntNode(63, null);
		size = 0;
	}

	public void addFirst(int x){
		sentinel.next = new IntNode(x, sentinel.next);
		size += 1;
	}

	public int getFirst(){
		return sentinel.next.item;
	}
	   /** Adds an item to the end of the list. */
    public void addLast(int x) {
        /* Your Code Here! */
        IntNode prt = sentinel;
        while(prt.next != null){
        	prt = prt.next;
        }
        prt.next = new IntNode(x, null);
        size += 1;
    }
    /** Because SLList doesn't have next, recursive addLast method must call getLast method.
    	To get the last IntNode and add node behind it.
    */
    private static IntNode getLastNode(IntNode p) {
    	if (p.next == null) {
    		return p;
    	}
    	return getLastNode(p.next);
    }

    public void addLastRec(int x) {
    	IntNode L = getLastNode(sentinel);
    	L.next = new IntNode(x, null);
    	size += 1;
    }

    public int getLast() {
    	IntNode L = getLastNode(sentinel);
    	return L.item;
    }

    /** Returns the number of items in the list using recursion. */
    /** Returns the size of the list that stars at IntNode p.*/
    private static int size (IntNode p) {
    	if (p.next == null) {
    		//Because of sentinel.
    		return 0;
    	}
    	return 1 + size(p.next);
    }

    public int size(){
    	return size(sentinel);
    }

    public static void main (String[] args) {
    	SLList testList = new SLList(15);
    	testList.addLastRec(2);
    	testList.addFirst(1);
    	testList.addLast(2);
    	testList.addLastRec(5);
    	System.out.println("the first item is " + testList.getFirst());
    	System.out.println("the size of testList is " + testList.size);
    	System.out.println("the sizeRec of testList is " + testList.size());
    	System.out.println("the last item is " + testList.getLast());
    }
}