package HackerRank;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Anagram {

    static boolean isAnagram(String a, String b) {
        boolean result = false;
        ///Remove the WhiteSpace
        String s1 = a.replace(" ", "");
        String s2 = b.replace(" ", "");

        if (s1.length() != s2.length()) {
            return false;
        }

        char[] valS1 = s1.toLowerCase().toCharArray();
        char[] valS2 = s2.toLowerCase().toCharArray();
        sortingArrayChar(valS1);
        sortingArrayChar(valS2);

        for (int i = 0; i < valS1.length; i++) {
            if (valS1[i] != valS2[i]) {
                return false;
            }
            result = true;
        }

        return result;
    }

    private static char[] sortingArrayChar(char[] val) {
        char arr[] = val;
        int i = 0;

        char temp;

        while (i < arr.length) {
            int j = i + 1;
            while (j < arr.length) {
                if (arr[j] < arr[i]) {

                    // Comparing the characters one by one
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j += 1;
            }
            i += 1;
        }

        return arr;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println((ret) ? "Anagrams" : "Not Anagrams");
    }

}
