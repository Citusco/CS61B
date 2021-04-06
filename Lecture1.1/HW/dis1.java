public class dis1{
	public static int fib(int n){
		if (n == 1 || n == 2){
			return 1;
		}
		int a = 0;
		int b = 1;
		int temp = 0;
		for (int i = 3; i <= n; i += 1){
			temp = a + b;
			a = b;
			b = temp;
		}
		return temp;
	}
	public static void main (String[] args){
		System.out.println(fib(30));
	}
}