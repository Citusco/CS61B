public class EX_1B_Triangle{
	public static void DrawTriangle(int x){
		int line = 1;
		while (line <= x){
			int origin = 1;
			while(origin <= line){
				System.out.print("*");
				origin = origin + 1;
			}
			System.out.println();
			line = line + 1;
		}
	}
	public static void main (String[] args){
		DrawTriangle(10);
	}
}