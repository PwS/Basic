package HackerRank.Java_Basic_Certification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MultiSum {


    private static Integer sumValue(String val) {
        Integer result = 0;

        String[] separated = val.trim().split(" +");

        List<Integer> valueInteger = convertListStringToListInteger(Arrays.asList(separated));

        for (Integer count : valueInteger) {
            result = result + count;
        }

        return result;

    }

    private static List<Integer> convertListStringToListInteger(List<String> value) {
        List<Integer> result = new ArrayList<>();

        if (value.isEmpty()) {
            return result;
        }

        for (int i = 0; i < value.size(); i++) {
            result.add(Integer.parseInt(value.get(i)));
        }
        return result;
    }

    private static String concatStringRemoveWhiteSpace(String value) {
        return value.replace(" ", "");
    }

    private static boolean containNumbersOnly(String source) {
        // Every token must be a whole number; checking only the first one crashed on "1 a 2"
        return source.trim().matches("-?\\d+( +-?\\d+)*");
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String stringValue = input.nextLine();


        if (containNumbersOnly(stringValue)) {
            System.out.println(sumValue(stringValue));
        } else {
            System.out.println(concatStringRemoveWhiteSpace(stringValue));
        }

    }

}
