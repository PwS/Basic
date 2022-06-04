import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class TwoNumbers {


    private static int[] reversedArrayConventional(int[] input) {
        List<Integer> output = new ArrayList<Integer>();
        for (int i = input.length - 1; i >= 0; i--) {
            output.add(input[i]);
        }
        return output.stream().filter(Objects::nonNull).mapToInt(x -> x).toArray();
    }

    public static void main(String[] args) {
        int[] array1 = {2, 4, 3};
        int[] array2 = {5, 6, 4};


        int[] reversedArray1 = reversedArrayConventional(array1);
        int[] reversedArray2 = reversedArrayConventional(array2);

        ///Reversed Array For Java 8+
        /*      int[] reverseArray1 = IntStream.range(0, array1.length).map(i -> array1[array2.length - i - 1]).toArray();*/

        int value1 = 0;
        int value2 = 0;
        for (Integer item : reversedArray1) {
            value1 = 10 * value1 + item;
        }
        for (Integer item : reversedArray2) {
            value2 = 10 * value2 + item;
        }

        System.out.println(value1 + value2);

    }
}
