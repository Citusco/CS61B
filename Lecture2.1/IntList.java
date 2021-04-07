public class IntList{
	public int first;
	public IntList rest;

	public IntList(int f, IntList r){
		first = f;
		rest = r;
	}
	// recursion
	public int Size(){
		if(rest == null){
			return 1;
		}
		return 1 + this.rest.Size();
	}
	/** Why Size method below has nullpointer exception?
		Because when it get the last node of list, it will still call this.rest.
		However, this.rest is null! So the nullpointer exception is made.*/
		
	// public int Size() {
	// 	if (this == null) {
	// 		return 0;
	// 	}
	// 	return 1 + this.rest.Size();
	// }
	// no recursion
	public int iterativeSize(){
		IntList p = this;
		int totalSize = 0;
		while(p.rest != null){
			totalSize = totalSize + 1;
			p = p.rest;
		}
		return totalSize;
	}
	public int get(int i){
		int size = this.Size();
		if(i >= size){
			System.out.println("Error!");
			return 0;
		}
		IntList p = this;
		for(int j = 0; j < i ; j++){
			p = p.rest;
		}
		return p.first;

	}
	public static void main(String[] args){
		IntList L = new IntList(15, null);
		L = new IntList(10, L);
		L = new IntList(5, L);
		int temp = L.get(2);
		System.out.println(temp);
		System.out.println(L.Size());
	}
}