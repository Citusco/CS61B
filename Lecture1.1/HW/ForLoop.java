public class ForLoop{
	public static int sum(int[] a){
		int sum = 0;
		for(int i = 0; i < a.length; i = i + 1){
			sum = sum + a[i];
		}
		return sum;
	}
	public static void main(String[] args){
		int[] numbers = new int[3];
		numbers[0] = 4;
		numbers[1] = 7;
		numbers[2] = 10;
		System.out.println(sum(numbers));
	}
}