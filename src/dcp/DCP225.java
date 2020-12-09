package dcp;

import static java.lang.Math.log;
import static java.lang.Math.pow;

/*
 * Good morning! Here's your coding interview problem for today.
 *
 * This problem was asked by Bloomberg.
 *
 * There are N prisoners standing in a circle, waiting to be executed.
 * The executions are carried out starting with the kth person,
 * and removing every successive kth person going clockwise until there is no one left.
 * Given N and k, write an algorithm to determine where a prisoner should stand in order to be the last survivor.
 *
 * For example, if N = 5 and k = 2, the order of executions would be [2, 4, 1, 5, 3], so you should return 3.
 *
 * Bonus: Find an O(log N) solution if k = 2.
 * */
public class DCP225 {
    public static void main(String args[]) {

        int numPrisoners = 7;
        int k = 3;

        // System.out.println(findLastSurvivingPrisoner(numPrisoners, k));
        System.out.println(LogNSol(numPrisoners, k));
    }

    private static int findLastSurvivingPrisoner(int n, int k) {
        if (n == 1)
            return 1;
        else
    /* The position returned by josephus(n - 1, k)
    is adjusted because the recursive call
    josephus(n - 1, k) considers the original
    position k%n + 1 as position 1 */
            return (findLastSurvivingPrisoner(n - 1, k) + k - 1) % n + 1;
    }

    private static double LogNSol(int n, int k) {
        return 2* (n - pow(2, (int) (log(n) / log(2)))) + 1;
    }
}
