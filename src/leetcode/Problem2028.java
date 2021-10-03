package leetcode;


import java.util.Arrays;

/*
 * Find Missing Observations
 *
 *
 * You have observations of n + m 6-sided dice rolls with each face numbered from 1 to 6. n of the observations went missing,
 * and you only have the observations of m rolls. Fortunately, you have also calculated the average value of the n + m rolls.
 * You are given an integer array rolls of length m where rolls[i] is the value of the ith observation.
 * You are also given the two integers mean and n.
 * Return an array of length n containing the missing observations such that the average value of the n + m rolls is exactly mean.
 * If there are multiple valid answers, return any of them. If no such array exists, return an empty array.
 * The average value of a set of k numbers is the sum of the numbers divided by k.
 * Note that mean is an integer, so the sum of the n + m rolls should be divisible by n + m.
 *
 * */
public class Problem2028 {
    public static void main(String args[]) {
        int[] rolls = {1, 5, 6};
        int mean = 3;
        int n = 4;
        missingRolls(rolls, mean, n);
    }

    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int[] result = new int[n];
        if (rolls.length <= 0) {
            return result;
        }

        int sumArray = Arrays.stream(rolls).sum();
        int totalArrayLen = rolls.length + n;

        int maxVal = totalArrayLen * mean;

        int findVal = maxVal - sumArray;
        if (findVal <= 0 || findVal / n > 6 || (findVal / n == 6 && findVal % n != 0) || ((findVal / n) == 0))
            return new int[0];
        int arr[] = new int[n];

        //p having the same value across the array and q will add 1 for next q times because it may have remainder <n
        int p = findVal / n, q = findVal % n;
        for (int i = 0; i < n; i++) {
            arr[i] = p + (q > 0 ? 1 : 0);
            q--;
        }

        return arr;
    }
}
