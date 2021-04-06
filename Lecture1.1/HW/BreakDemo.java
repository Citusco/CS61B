public class BreakDemo {
    public static void main(String[] args) {
        String[] a = {"cat", "dog", "laser horse", "ketchup", "horse", "horbse"};

        for (int i = 0; i < a.length; i += 1) {
            for (int j = 0; j < 3; j += 1) {
                System.out.println(a[i]);
                //the break keyword completely terminates the innermost loop when it is called
                if (a[i].contains("horse")) {
                    break;
                }                
            }
        }
    }
}