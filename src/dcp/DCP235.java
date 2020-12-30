package dcp;

/*
 * This problem was asked by Facebook.
 *
 * Given an array of numbers of length N,
 * find both the minimum and maximum using less than 2 * (N - 2) comparisons.

 */
public class DCP235 {
    public static void main(String args[]) {
        int[] arr = {3, 5, 6, 8, 1};
        Pair minmax = findMinandMax(arr, arr.length);
        System.out.printf("\nMinimum element is %d", minmax.min);
        System.out.printf("\nMaximum element is %d", minmax.max);
    }

    static class Pair {
        int min;
        int max;
    }

    private static Pair findMinandMax(int[] arr, int length) {
        Pair minmax = new Pair();
        int i;
        if (length % 2 == 0) {
            if (arr[0] > arr[1]) {
                minmax.max = arr[0];
                minmax.min = arr[1];
            } else {
                minmax.min = arr[0];
                minmax.max = arr[1];
            }
            i = 2;
        } else {
            minmax.max = arr[0];
            minmax.min = arr[0];
            i = 1;
        }

        while (i < length - 1) {
            if (arr[i] > arr[i + 1]) {
                if (arr[i] > minmax.max) {
                    minmax.max = arr[i];
                }
                if (arr[i + 1] < minmax.min) {
                    minmax.min = arr[i + 1];
                }
            } else {
                if (arr[i + 1] > minmax.max) {
                    minmax.max = arr[i + 1];
                }
                if (arr[i] < minmax.min) {
                    minmax.min = arr[i];
                }
            }
            i += 2;
        }
        return minmax;
    }
}
