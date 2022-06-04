import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        List<Integer> indexArrayCounting = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j >= i; j--) {
                if (i != j) {
                    int indexIJ = nums[i] + nums[j];
                    if (indexIJ == target) {
                        indexArrayCounting.add(i);
                        indexArrayCounting.add(j);
                        return indexArrayCounting.stream().filter(Objects::nonNull).mapToInt(x -> x).toArray();
                    }
                }
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] arrayInput1 = {2, 7, 11, 15};
        int target1 = 9;

        int arrayInput2[] = {3, 2, 4};
        int target2 = 6;

        int arrayInput3[] = {3, 3};
        int target3 = 6;

        int[] result1 = TwoSum.twoSum(arrayInput1, target1);
        for (int resultEachIndex : result1) {
            System.out.println(Integer.toString(resultEachIndex));
        }
    }
}
