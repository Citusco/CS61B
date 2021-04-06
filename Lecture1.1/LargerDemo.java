public class LargerDemo {
	public static int Larger (int x, int y){// Defining function, public static is a very rough analog of Python's def keyword.
		if (x > y){
			return x;
		}
		return y;
	}
	public static void main (String[] args) {
		System.out.println(Larger(8, 10));
}
}