public class temp{
	public static int mystery(int[] inputArray, int k) {
	int x = inputArray[k];
 	int answer = k;
	int index = k + 1;
 	while (index < inputArray.length) {
	if (inputArray[index] < x) {
	x = inputArray[index];
	answer = index;
 	}
 	index = index + 1;
 	}
 	return answer;
	}
	public static void mystery2(int[] inputArray) {
 int index = 0;
 while (index < inputArray.length) {
 int targetIndex = mystery(inputArray, index);
 int temp = inputArray[targetIndex];
 inputArray[targetIndex] = inputArray[index];
 inputArray[index] = temp;
 index = index + 1;
 }
 }
	public static void main(String[] args){
		int[] o = new int [] {3,0,4,6,3};
		mystery2(o);
		for (int i = 0 ; i < 5 ; i += 1){
			System.out.println(o[i]);
		}
		
	}
}