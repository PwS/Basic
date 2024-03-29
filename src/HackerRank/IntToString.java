package HackerRank;

import java.util.*;
import java.security.*;

public class IntToString {
    public static void main(String[] args) {

        DoNotTerminatee.forbidExit();

        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            in.close();
            //String s=???; Complete this line below

            String s = "Default Value";
            try {
                if (n >= -100 && n <= 100) {
                    s = String.valueOf(n);
                } else {
                    s = "Out Of Range";
                }
            } catch (Exception e) {
                System.out.println("Wrong answer.");
            }


            if (n == Integer.parseInt(s)) {
                System.out.println("Good job");
            } else {
                System.out.println("Wrong answer.");
            }
        } catch (DoNotTerminatee.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }
}

//The following class will prevent you from terminating the code using exit(0)!
class DoNotTerminatee {

    public static class ExitTrappedException extends SecurityException {

        private static final long serialVersionUID = 1;
    }

    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
}
