package HackerRank;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringTokens {

    private static void printEachTokenWithRegex(String input) {

        String regex = "[!,?._'@ ]+";

        // Remove leading/trailing delimiters, otherwise split() returns an empty first token
        input = input.replaceAll("^" + regex + "|" + regex + "$", "");

        if (input.isEmpty()) {
            System.out.print("0");
            return;
        }


        List<String> listValue = Arrays.asList(input.split(regex));

        ///Print Length
        System.out.println(listValue.size());

        for (String value : listValue) {
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        // Write your code here.
        printEachTokenWithRegex(s);

        scan.close();
    }
}
