package HackerRank;

import java.io.*;
import java.util.*;

class Resultt {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {

        System.out.println(findPlusValue(arr));
        System.out.println(findMinusValue(arr));
        System.out.println(findZeroValue(arr));


    }

    private static double findZeroValue(List<Integer> arr) {
        int totalValue = 0;


        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == 0) {
                totalValue++;
            }
        }


        return (double) totalValue / (double) arr.size();
    }

    private static double findMinusValue(List<Integer> arr) {
        int totalValue = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) < 0) {
                totalValue++;
            }
        }

        return (double) totalValue / (double) arr.size();

    }

    private static double findPlusValue(List<Integer> arr) {
        int totalValue = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > 0) {
                totalValue++;
            }
        }

        return (double) totalValue / (double) arr.size();

    }

}

public class PlusMinus {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Resultt.plusMinus(arr);

        bufferedReader.close();
    }
}
