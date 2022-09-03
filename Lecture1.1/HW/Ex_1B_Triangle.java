public class EX_1B_Triangle{
	public static void drawTriangle (int line) {
		int origin = 1;
		while (origin <= line) {
			for (int i = 1; i <= origin; i ++) {
				System.out.print("*");
			}
			System.out.print("\n");
			origin += 1;
		}

	}
	public static void main (String[] args) {
		drawTriangle(10);
	}
}