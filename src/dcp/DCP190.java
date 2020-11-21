package dcp;

import java.util.Arrays;

public class DCP190 {
    public static void main(String args[]) {
        // int arr[] = {8, -1, 3, 4};
        int arr[] = {-4, 5, 1, 0};
        int sum = maxSubarraySumCircular(arr);
         System.out.println(sum);
    }

    private static int computeSumFromTheSubArray(int arr[]) {
        if (arr.length <= 0) {
            return 0;
        }

        int sum = 0;
        for (int count : arr) {

        }
        return sum;
    }

    private static int maxSubarraySumCircular(int[] arr) {
        if (arr.length == 0) return 0;
        int non_wrap = kaden(arr);
        int simple = Arrays.stream(arr).sum();
        for (int i = 0; i < arr.length; i++)
            arr[i] = -arr[i];
        int wrapped = kaden(arr);
        return wrapped + simple == 0 ? non_wrap : Math.max(non_wrap, wrapped + simple);

    }

    private static int kaden(int arr[]) {
        int gSum = arr[0], curr_sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            curr_sum = Math.max(arr[i], arr[i] + curr_sum);

            if (curr_sum > gSum)
                gSum = curr_sum;
        }
        return gSum;
    }
}

