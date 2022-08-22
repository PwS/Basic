package switch_case;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingArray {


    private static List<Integer> sortingArrayResult(int[] value) {
        List<Integer> result = new ArrayList<>();


        if (value.length == 0) {
            return result;
        }

        for (int i = 0; i < value.length - 1; i++) {
            for (int j = 0; j < value.length - i - 1; ++j) {
                if (value[j + 1] < value[j]) {
                    int swap = value[j];
                    value[j] = value[j + 1];
                    value[j + 1] = swap;
                }
            }
        }

        result = Arrays.asList(Arrays.stream(value).boxed().toArray(Integer[]::new));
        return result;

    }

    public static void main(String[] args) {
        int[] test1 = {2, 1, 3, 4, 5};
        int[] test2 = {4, 2, 1, 3, 5};
        int[] test3 = {1, 5, 3, 2, 4};

        System.out.println(sortingArrayResult(test1));
        System.out.println(sortingArrayResult(test2));
        System.out.println(sortingArrayResult(test3));


    }
}
