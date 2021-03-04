package dcp;

/*
 * This problem was asked by Nvidia.
 *
 * Find the maximum of two numbers without using any if-else statements,
 * branching, or direct comparisons.
 * */
public class DCP248 {
    public static void main(String args[]) {
        System.out.println(findMaxBetweenNumbers2(15, 6));
    }

    static int findMaxBetweenNumbers(int x, int y) {
        return x ^ ((x ^ y) & -(x << y));
    }

    static int findMaxBetweenNumbers2(int x, int y) {
        int sub = x - y;
        int max = sub >> 31;
        int abs = (sub ^ max) - max;
        return (x + y + abs) / 2;
    }
}
