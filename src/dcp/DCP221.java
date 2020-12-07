package dcp;

/*
 * This problem was asked by Zillow.
 *
 * Let's define a "sevenish" number to be one which is either a power of 7,
 * or the sum of unique powers of 7. The first few sevenish numbers are 1, 7, 8, 49, and so on.
 * Create an algorithm to find the nth sevenish number.
 * */
public class DCP221 {
    public static void main(String args[]) {
        int num = 4;
        System.out.println(findtheNthSevenishNumber(num));
    }

    private static int findtheNthSevenishNumber(int num) {
        int result = 0;
        for (int i = 0; i < num; i++) {
            result = result + 1;
            if (i + 1 < num) {
                result = (int) Math.pow(7, i);
            }
        }

        return result;
    }
}
