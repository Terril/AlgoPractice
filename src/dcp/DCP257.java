package dcp;

/*
 * This problem was asked by WhatsApp.
 *
 * Given an array of integers out of order,
 * determine the bounds of the smallest window that must be sorted in order for the entire array to be sorted.
 * For example, given [3, 7, 5, 6, 9], you should return (1, 3)*/
public class DCP257 {
    public static void main(String args[]) {
        int arr[] = {3, 7, 5, 6, 9};

        findTheBoundsforSorting(arr);
        findTheBoundsUsing2Way(arr);
    }

    private static void findTheBoundsforSorting(int[] arr) {
        String readout = "";
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            for (int j = i; j < arr.length; j++) {
                if (x > arr[j]) {
                    readout += j;
                }
            }
        }

        System.out.println(readout);
    }

    private static void findTheBoundsUsing2Way(int arr[]) {

        int min = Integer.MIN_VALUE;
        int rightPos = -1;
        int leftPos = -1;
        for (int i = 0; i < arr.length; i++) {
            if (min < arr[i]) {
                min = arr[i];
            }

            if (arr[i] < min) {
                rightPos = i;
            }
        }

        int max = Integer.MAX_VALUE;
        for (int j = arr.length - 1; j > 0; j--) {
            if (max > arr[j]) {
                max = arr[j];
            }

            if (arr[j] > max) {
                leftPos = j;
            }
        }

        System.out.println("{" + leftPos + "," + rightPos + "}");
    }
}
