package dcp;

/*
 * This problem was asked by Apple.
 *
 * Implement the function fib(n), which returns the nth number in the Fibonacci sequence, using only O(1) space.
 * */
public class DCP233 {
    public static void main(String args[]) {
        int n = 9;
        System.out.println(fib(n));
    }

    private static int fib(int n) {
        if (n <= 1)
            return n;

        int sum = fib(n - 1) + fib(n - 2);
        return sum;
    }
}
