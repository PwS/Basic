package LeetCode;

class NumberOfSteps {
    public static int numberOfSteps(int num) {
        if (num == 0) {
            return 0;
        }
        return countingTheStep(num, 0);
    }

    private static int countingTheStep(int num, int currentSteps) {
        int currentVariable = 0;
        currentSteps += 1;
        if (checkOddsEven(num)) {
            currentVariable = num / 2;
        } else {
            currentVariable = num - 1;
        }
        if (isVariableWasZero(currentVariable)) {
            return currentSteps;
        }
        return countingTheStep(currentVariable, currentSteps);
    }

    private static boolean isVariableWasZero(int currentVariable) {
        return currentVariable == 0;
    }

    private static boolean checkOddsEven(int num) {
        return num % 2 == 0;
    }

    public static void main(String[] args) {
        System.out.println(NumberOfSteps.numberOfSteps(14));
    }
}
