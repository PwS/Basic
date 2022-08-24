package HackerRank;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringTokens {

    private static void printEachTokenWithRegex(String input) {

        input = input.trim();

        if (input == "" || input == null || input.isEmpty()) {
            System.out.print("0");
            return;
        }

        String regex = "[!,?._'@ ]+";


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
