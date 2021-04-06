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

	public void SLList(int x){
		sentinel = new IntNode(63, null);
		sentinel.next = new IntNode(x, null);
		size = 1;
	}
	public SLList(){
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


    /** Returns the number of items in the list using recursion. */
    public int size(){
    	return size;
    }

}