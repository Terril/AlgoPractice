package dcp;

import java.util.HashMap;

/*
 * This problem was asked by Apple.
 * A Collatz sequence in mathematics can be defined as follows. Starting with any positive integer:
 * if n is even, the next number in the sequence is n / 2
 * if n is odd, the next number in the sequence is 3n + 1
 * It is conjectured that every such sequence eventually reaches the number 1. Test this conjecture.

 * Bonus: What input n <= 1000000 gives the longest sequence?
 * */
public class DCP210 {
    static HashMap<Long, Long> store = new HashMap<Long, Long>();
    static long maxCount = 0;
    static long result;

    public static void main(String args[]) {
        findtheLongestSequence();
    }

    private static void findtheLongestSequence() {
        for (long i = 0; i < 1000000; i++) {
            long count = 1;
            long num = i;

            while (num != 1) {
                if (num < i && store.containsKey(num)) {
                    count = count + (store.get(num) - 1);
                    break;
                }
                if (num % 2 == 0) {
                    num = num / 2;
                    count++;
                } else {
                    num = (3 * num) + 1;
                    count++;
                }
            }
            store.put(i, count);
            if (count > maxCount) {
                maxCount = count;
                result = i;
            }
        }
        System.out.println("Maximum count for digit : - " + result + " maxcount " + maxCount);
    }

}
