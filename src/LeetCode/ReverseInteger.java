package LeetCode;

import java.lang.reflect.Array;
import java.util.*;

public class ReverseInteger {

    private static int reverse(int x) {
        try {
            int result;

            if (x == 0) {
                return 0;
            }

            List<String> digits =
                    new LinkedList<>(Arrays.asList(String.valueOf(x).split("")));


            List<String> reversed = new ArrayList<>();


            if (digits.get(0).equals("0") || digits.get(0).equals("-")) {
                reversed.add(digits.get(0));
                digits.remove(0);
            }


            for (int i = digits.size() - 1; i >= 0; i--) {
                reversed.add(digits.get(i));
            }

            if (Objects.equals(reversed.get(0), "0")) {
                reversed.remove(0);
            }

            StringBuilder sb = new StringBuilder();
            for (String s : reversed) {
                sb.append(s);
            }

            result = Integer.parseInt(sb.toString());

            return result;
        } catch (Exception e) {
            return 0;
        }

    }

    public static void main(String[] args) {
        System.out.println(reverse(-321));
    }

}
