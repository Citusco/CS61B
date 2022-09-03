public class Excercise_Triangle{
	public static void main (String[] args){
		int line = 1;
		while (line <= 5){
			int origin = 1;
			// Every line will print "*" untill the number of "*" equals the number of the line.
			while (origin <= line){
				System.out.print("*");
				origin = origin	 + 1;
			}
			System.out.println();
			line = line + 1;
		}
	}
}