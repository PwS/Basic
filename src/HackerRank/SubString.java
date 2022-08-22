package HackerRank;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SubString {

    private static String subStringValue(String val, int start, int end) {
        List<String> resultValue = Arrays.asList(val.split(""));


        StringBuffer sb = new StringBuffer();
        for (int i = start; i < resultValue.size(); i++) {
            if (i == end) {
                break;
            }
            sb.append(resultValue.get(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        int start = in.nextInt();
        int end = in.nextInt();

        System.out.println(subStringValue(S, start, end));

    }
}
