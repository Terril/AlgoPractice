package dcp;

import java.util.Arrays;

public class DCP205 {
    public static void main(String args[]) {
        String input = "536976";
        findNextPerm(input.toCharArray(), input.length());
    }

    private static void findNextPerm(char[] arr, int n) {

        int i;

        for (i = n - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1]) {
                break;
            }
        }
        if (i == 0) {
            System.out.println("Cannot do the Permutation");
        } else {
            int x = arr[i - 1], min = i;
            for (int j = i; j < n; j++) {
                if (arr[j] > x && arr[j] < min) {
                    min = j;
                }
            }
            swap(arr, i - 1, min);
            Arrays.sort(arr, i, n);
            System.out.print("Next number with same" +
                    " set of digits is ");
            for (i = 0; i < n; i++)
                System.out.print(arr[i]);
        }
    }

    private static void swap(char[] arr, int start, int end) {
        char temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

}
