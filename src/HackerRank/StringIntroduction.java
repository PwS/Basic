package HackerRank;

import java.util.Locale;
import java.util.Scanner;

public class StringIntroduction {

    private static int countLetter(String a, String b) {
        return a.length() + b.length();
    }

    private static String compareLexicographically(String a, String b) {
        ///sorted alphabetically/lexicographically
        int result = a.compareTo(b);

        if (result > 0) {
            return "Yes";
        }
        return "No";

    }

    private static String concatLetter(String a, String b) {
        return a.substring(0, 1).toUpperCase(Locale.ROOT) + a.substring(1) + " " + b.substring(0, 1).toUpperCase(Locale.ROOT) + b.substring(1);
    }

    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        String A=sc.next();
//        String B=sc.next();

        String A = "java";
        String B = "java";

        System.out.println(countLetter(B, A));
        System.out.println(compareLexicographically(B, A));
        System.out.println(concatLetter(B, A));

    }
}
