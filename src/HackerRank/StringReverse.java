package HackerRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringReverse {
    public static boolean isThatPalindromeString(String val) {

        String[] splitChar = val.split("");
        List<String> reservedSplitChar = new ArrayList<>();

        for (int i = splitChar.length - 1; i >= 0; i--) {
            reservedSplitChar.add(splitChar[i]);
        }

        return String.join("", reservedSplitChar).equalsIgnoreCase(val);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        /* Enter your code here. Print output to STDOUT. */
        String result = isThatPalindromeString(A) ? "Yes" : "No";
        System.out.println(result);
    }
}
