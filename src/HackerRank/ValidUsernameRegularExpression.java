package HackerRank;

import java.util.Scanner;

public class ValidUsernameRegularExpression {

    public static final String regularExpression = "^[a-zA-Z]([_]|[a-zA-Z0-9]){7,29}$";

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine());
        while (n-- != 0) {
            String userName = scan.nextLine();

            if (userName.matches(regularExpression)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        }
    }
}
