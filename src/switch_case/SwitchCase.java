package switch_case;

import java.util.*;

public class SwitchCase {
    /**
     * Uses the caller's Scanner: two Scanners on System.in would each buffer part of the input
     */
    public static void switchCase(int pil, Scanner input) {
        switch (pil) {
            case 1:
                System.out.print("Input Variable : ");
                int valInput = input.nextInt();
                EvenOdd.EvenOdd(valInput);
                break;
            case 2:
                System.out.println("Nothing To Do");
                break;
            case 3:
                System.out.println("Nothing To Do");
                break;
            case 4:
                System.out.println("Nothing To Do");
                break;
            case 5:
                System.out.print("Input Variable : ");
                int value = input.nextInt();
                System.out.println("Factorial of " + value + " is " + Factorial.getResultFactorial(value));
                break;
            case 6:
                System.out.println("Nothing To Do");
                break;
            default:
                System.out.println("switch_case.Menu Not Found");
                break;
        }
    }
}
