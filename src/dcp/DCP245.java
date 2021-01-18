package dcp;

/*
 * This problem was asked by Yelp.
 *
 * You are given an array of integers,
 * where each element represents the maximum number of steps that can be jumped going forward from that element.
 * Write a function to return the minimum number of jumps you must take in order to get from the start to the end of the array.
 *
 * For example, given [6, 2, 4, 0, 5, 1, 1, 4, 2, 9],
 * you should return 2, as the optimal solution involves jumping from 6 to 5,
 * and then from 5 to 9.
 * */
public class DCP245 {
    public static void main(String args[]) {
        int arr[] = {6, 2, 2, 0, 2, 1, 1, 3, 2, 9};
        System.out.println(findMinJumpTillEnd(arr));
    }

    private static int findMinJumpTillEnd(int arr[]) {
        int jump = 0;
        int len = arr.length;

        int num = 1;
        int it = arr[0];
        while (num < len) {
            int it1 = arr[num];
            int sum = it + it1;

            if (sum >= len) {
                break;
            } else {
                if (it < it1) {
                    it = it1;
                } else {
                    it = arr[num];
                }
                num = it;
                jump++;
            }

        }
        return jump;
    }
}
