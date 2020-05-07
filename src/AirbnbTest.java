import java.util.Scanner;

public class AirbnbTest {

    public static void main(String args[]) {

        int[] arr = new int[]{5, 1, 1, 5};
        findSumLargestNonAdjacent(arr);
        int sume = FindMaxSum(arr, arr.length);
        System.out.println(sume);
    }

    private static void findSumLargestNonAdjacent(int[] arr) {

        int a = arr[0];
        int temp;
        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            temp = (a > sum) ? a : sum;
            a = sum + arr[i];
            sum = temp;
        }

        System.out.println(( a > sum) ? a : sum);
    }

    private static boolean adjacentNum(int b, int i) {
        int numPos = b - i;
        return numPos == 1 || numPos == -1;
    }

    static int FindMaxSum(int arr[], int n) {
        int incl = arr[0];
        int excl = 0;
        int excl_new;
        int i;

        for (i = 1; i < n; i++) {
            /* current max excluding i */
            excl_new = (incl > excl) ? incl : excl;

            /* current max including i */
            incl = excl + arr[i];
            excl = excl_new;
        }

        /* return max of incl and excl */
        return ((incl > excl) ? incl : excl);
    }

}
