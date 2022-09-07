package switch_case;

class Factorial {
    public static int getResultFactorial(int valInput) {
        int result = 1;
        for (int i = 1; i < valInput; i++) {
            result *= i;
        }
        return result;
    }
}