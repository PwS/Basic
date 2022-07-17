import java.util.ArrayList;
import java.util.List;

public class Palindrome {
    public static boolean isThatPalindrome(int num) {

        String[] splitChar = String.valueOf(num).split("");
        List<String> reservedSplitChar = new ArrayList<>();

        for (int i = splitChar.length - 1; i >= 0; i--) {
            reservedSplitChar.add(splitChar[i]);
        }

        return Integer.parseInt(String.join("", reservedSplitChar)) == num;
    }

    public static void main(String[] args) {
        System.out.println(isThatPalindrome(456));
    }

}
