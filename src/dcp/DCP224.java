package dcp;

/*
 *
 * This problem was asked by Amazon.
 *
 * Given a sorted array, find the smallest positive integer that is not the sum of a subset of the array.
 *
 * For example, for the input [1, 2, 3, 10], you should return 7.
 *
 * Do this in O(N) time.
 * */
public class DCP224 {
    public static void main(String args[]) {

        int ar[] = {1, 2, 3, 10};
        int arr[] = {1, 3, 6, 10, 11, 15};
        System.out.println(findSmallestInteger(ar));
    }

    private static int findSmallestInteger(int arr[]) {
        int res = 1; // Initialize result

        for (int i = 0; i < arr.length && arr[i] <= res; i++)
            res = res + arr[i];

        return res;
    }
}
