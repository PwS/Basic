package HackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Growth2Dimensions {


    public static long maxCount(List<String> value) {
        long result = 0;

        List<Integer> listXValue = new ArrayList<>();
        List<Integer> listYValue = new ArrayList<>();

        for (int i = 0; i < value.size(); i++) {
            listXValue.add(Integer.parseInt(value.get(i).split(" ")[0]));
            listYValue.add(Integer.parseInt(value.get(i).split(" ")[1]));
        }

        int lengthXValue = getMaxLength(listXValue);
        int lengthYValue = getMaxLength(listYValue);


        for (int i = 0; i < value.size(); i++) {
            if (Integer.parseInt(value.get(i).split(" ")[0]) >= lengthXValue) {
                result++;
            } else if (Integer.parseInt(value.get(i).split(" ")[1]) < lengthYValue) {
                result++;
            }
        }


        return result;
    }

    private static Integer getMaxLength(List<Integer> value) {
        Integer result = 0;
        for (int i = 0; i < value.size(); i++) {
            if (result < value.get(i)) {
                result = value.get(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> test1 = Arrays.asList("1 4", "2 3", "4 1");
        List<String> test2 = Arrays.asList("2 3", "3 7", "4 1");
        System.out.println(maxCount(test1));
        System.out.println(maxCount(test2));
    }
}
