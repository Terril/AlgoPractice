package dcp;

/*
 * This problem was asked by Goldman Sachs.

 * You are given N identical eggs and access to a building with k floors.
 * Your task is to find the lowest floor that will cause an egg to break,
 * if dropped from that floor. Once an egg breaks, it cannot be dropped again.
 * If an egg breaks when dropped from the xth floor,
 * you can assume it will also break when dropped from any floor greater than x.
 *
 * Write an algorithm that finds the minimum number of trial drops it will take,
 * in the worst case, to identify this floor.
 *
 * For example, if N = 1 and k = 5,
 * we will need to try dropping the egg at every floor,
 * beginning with the first, until we reach the fifth floor,
 * so our solution will be 5.
 * */
public class DCP230 {

    public static void main(String args[]) {
        int N = 1, K = 5;
        int n = 2, k = 10;
        System.out.println(eggDrop(n, k));
    }

    private static int eggDrop(int n, int k) {
        if (k == 1 || k == 0) {
            return 0;
        }
        if (n == 1) {
            return k;
        }

        int min = Integer.MAX_VALUE;
        int x, res;

        for (x = 1; x < k; x++) {
            res = Math.max(eggDrop(n - 1, x - 1), eggDrop(n, k - x));

            if (res < min) {
                min = res;
            }
        }

        return min + 1;
    }
}
