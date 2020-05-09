public class AmazonStepsProblem {

    public static void main(String args[]) {
        int numberofSteps = 5;

        int sum = findNumberofWays(numberofSteps);
        System.out.println(sum);
    }

    static  int count = 0;

    private static int findNumberofWays(int numberofSteps) {
        if (numberofSteps == 0 || numberofSteps == 1) {
            return 1;
        }
        count = findNumberofWays(numberofSteps - 1) + findNumberofWays(numberofSteps - 2);

        return count;
    }


}
