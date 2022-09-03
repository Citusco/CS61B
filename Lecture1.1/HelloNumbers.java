public class HelloNumbers{
	public static void main (String[] args) {
		int i = 0;
		while (i < 10) {
			int n = 10;
			int sum = 0;
			for (n = 0; n <= i; n ++) {
				sum += n;
			}
			System.out.println(sum);
			i += 1;
		}
	}
}