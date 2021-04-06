public class EnhanceForBreakDemo{
	public static void main(String[] args){
        String[] a = {"cat", "dog", "laser horse", "ketchup", "horse", "horbse"};

        // the String s takes on the identity of each String in a exactly once, starting from a[0], all the way up to a[a.length - 1].
        for (String s : a){
        	for(int j = 0; j < 3; j += 1){
        		System.out.println(s);
        		if (s.contains("horse")){
        			break;
        		}
        	}
        }
	}
}