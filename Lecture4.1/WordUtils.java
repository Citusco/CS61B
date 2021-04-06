public class WordUtils{
    public static String longest(SLList<String> list){
        int maxDex = 0;
        for (int i = 0; i < list.length(); i ++) {
            String longestString = list.get(maxdex);
            String thisString = list.get(i);
            if (thisString.length() > longestString.length()) {
                maxdex = i;
            }
        }
        return list.get(maxdex);
    }
}