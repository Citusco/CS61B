public class EX_2_Array {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
        int i = 0; //initialization
        int cache = 0;
        while(i < m.length){
        	if (m[i] > cache){
        		cache = m[i];
        	}
        	i = i + 1;
        }
        return cache;
    }
    public static void main(String[] args) {
       int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};      
    	System.out.println(max(numbers));
    }
}