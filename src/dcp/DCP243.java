package dcp;

/*
 * This problem was asked by Etsy.
 *
 * Given an array of numbers N and an integer k,
 *  your task is to split N into k partitions such that the maximum sum of any partition is minimized. Return this sum.
 *
 * For example, given N = [5, 1, 2, 7, 3, 4] and k = 3, you should return 8,
 * since the optimal partition is [5, 1, 2], [7], [3, 4]
 * */
public class DCP243 {
    public static void main(String args[]) {
        int[] N = {5, 1, 2, 7, 3, 4};
        int k = 3;
        int array[] = { 1, 2, 3, 4 };
        System.out.println(splitWithMinSum(N, k));
    }

    static int splitWithMinSum(int[] N, int k) {
        int val = 0;
        int init = 1;
        for (int i = 0; i < N.length; i++) {
            val = val + N[i];
        }

        int ans = 0;

        while (init <= val) {

            int mid = (init + val) / 2;

            if (isAvail(N, mid, N.length, k)) {
                ans = mid;
                val = mid - 1;
            } else {
                init = mid + 1;
            }
        }

        return ans;
    }

    static boolean isAvail(int arr[], int mid, int len, int k) {
        int count = 0;
        int sum = 0;

        for (int i = 0; i < len; i++) {
            if (arr[i] > mid) {
                return false;
            }

            sum = sum + arr[i];

            if (sum > mid) {
                count++;
                sum = arr[i];
            }
        }

        count++;

        if (count <= k) {
            return true;
        }
        return false;
    }
}
