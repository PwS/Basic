package HackerRank;

import java.util.ArrayList;
import java.util.List;

public class JavaSubstringComparisons {
    ///Lexicographical Order
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'


        java.util.ArrayList<String> list = new java.util.ArrayList<>();
        for (int i = 0; i <= s.length() - k; i++) {
            String sub = (s.substring(i, i + k));
            list.add(sub);
        }
        java.util.Collections.sort(list);
        return list.get(0) + "\n" + list.get(list.size() - 1);
    }


    private static String reversedWords(String s) {
        String result = "";
        StringBuffer sb = new StringBuffer();
        for (int i = s.length() - 1; i < s.length(); i--) {
            if (i >= 0) {
                sb.append(s.charAt(i));
            }
        }

        result = sb.toString();
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getSmallestAndLargest("welcometojava", 3));
    }

}
