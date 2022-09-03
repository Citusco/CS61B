public class HelloSum{
	public static void main(String[] args){
		int x = 0;
		int y = 0; // This is the variable that represents the sum.
		while (x < 10){
			y = y + x;
			System.out.print(y + " ");
			x = x + 1;
		}
	}
}