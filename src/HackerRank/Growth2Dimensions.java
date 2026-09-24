package HackerRank;

import java.util.Arrays;
import java.util.List;

public class Growth2Dimensions {

    /**
     * Each operation "r c" adds 1 to every cell in rows 1..r and columns 1..c.
     * The largest value is in the cells covered by every operation: the rectangle
     * of the smallest r by the smallest c.
     */
    public static long maxCount(List<String> value) {
        long minRows = Long.MAX_VALUE;
        long minColumns = Long.MAX_VALUE;

        for (String operation : value) {
            String[] rowsAndColumns = operation.trim().split("\\s+");
            minRows = Math.min(minRows, Long.parseLong(rowsAndColumns[0]));
            minColumns = Math.min(minColumns, Long.parseLong(rowsAndColumns[1]));
        }

        return minRows * minColumns;
    }

    public static void main(String[] args) {
        List<String> test1 = Arrays.asList("1 4", "2 3", "4 1");
        List<String> test2 = Arrays.asList("2 3", "3 7", "4 1");
        System.out.println(maxCount(test1));
        System.out.println(maxCount(test2));
    }
}
