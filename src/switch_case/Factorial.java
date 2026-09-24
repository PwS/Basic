package switch_case;

class Factorial {
    /**
     * n! for n >= 0. Uses long, so results are exact up to 20!
     */
    public static long getResultFactorial(int valInput) {
        long result = 1;
        for (int i = 2; i <= valInput; i++) {
            result *= i;
        }
        return result;
    }
}