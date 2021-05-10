package dcp;

/*
 * This problem was asked by Atlassian.

 *
 * MegaCorp wants to give bonuses to its employees based on how many lines of codes they have written.
 * They would like to give the smallest positive amount to each worker consistent with the constraint that
 * if a developer has written more lines of code than their neighbor, they should receive more money.
 *
 * Given an array representing a line of seats of employees at MegaCorp,
 * determine how much each one should get paid.
 *
 * For example, given [10, 40, 200, 1000, 60, 30], you should return [1, 2, 3, 4, 2, 1].
 *
 * */
public class DCP265 {
    public static void main(String args[]) {

        int[] arr = {10, 40, 200, 1000, 60, 30};
        int[] res = getBonus(arr);

        for (int a : res) {
            System.out.println(a);
        }
    }

    private static int[] getBonus(int[] linesOfSeat) {
        int[] amt = new int[linesOfSeat.length];

        int count = 0;
        int value = 1;
        if (linesOfSeat.length == 1) {
            amt[count] = value;
            return amt;
        }
        while (count < linesOfSeat.length - 1) {
            amt[count] = value;
            value = getBonusUtil(linesOfSeat[count], linesOfSeat[count + 1], value);
            count++;
        }

        return amt;
    }

    private static int getBonusUtil(int current, int next, int value) {

        if (current < next) {
            value += 1;
        } else {
            value = value / 2;
        }
        return value;
    }
}
