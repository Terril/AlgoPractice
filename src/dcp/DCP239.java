package dcp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * This problem was asked by Uber.
 *
 * One way to unlock an Android phone is through a pattern of swipes across a 1-9 keypad.
 *
 * For a pattern to be valid, it must satisfy the following:
 *
 * All of its keys must be distinct.
 * It must not connect two keys by jumping over a third key, unless that key has already been used.
 * For example, 4 - 2 - 1 - 7 is a valid pattern, whereas 2 - 1 - 7 is not.
 *
 * Find the total number of valid unlock patterns of length N, where 1 <= N <= 9.

 */
public class DCP239 {
    public static void main(String args[]) {
        int[][] arr = {{1, 2, 5, 9}, {1, 2, 7}, {3, 2, 8}, {4, 8, 6, 3, 2, 1}};
        int length = 9;
        findValidPatterns(arr, length);
    }

    static int findValidPatterns(int[][] arr, int length) {

        HashMap set = new HashMap();
        for (int i = 0; i < length; i++) {
            set.put(i, i % 3);
        }

        return 0;
    }
}
