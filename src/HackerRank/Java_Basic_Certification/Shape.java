package HackerRank.Java_Basic_Certification;

import java.util.*;

public class Shape {
    private static Integer multiplyValue(String val) {
        Integer result = 0;

        String[] separated = val.split(" ");

        List<Integer> valueInteger = convertListStringToListInteger(Arrays.asList(separated));

        result = valueInteger.get(0) * valueInteger.get(1);

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

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String stringValue = input.nextLine();

        System.out.println(stringValue);
        System.out.println(multiplyValue(stringValue));


    }
}
