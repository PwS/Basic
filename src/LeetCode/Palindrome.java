package LeetCode;

public class Palindrome {
    public static boolean isThatPalindrome(int num) {
        // Compare as text: parsing the reversed digits back to int crashed on
        // negative numbers ("121-") and on reversals larger than Integer.MAX_VALUE
        String value = String.valueOf(num);
        return new StringBuilder(value).reverse().toString().equals(value);
    }

    public static void main(String[] args) {
        System.out.println(isThatPalindrome(456));
    }

}
