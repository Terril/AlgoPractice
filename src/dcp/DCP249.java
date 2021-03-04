package dcp;

/*
 * This problem was asked by Salesforce.
 *
 * Given an array of integers,
 * find the maximum XOR of any two elements.
 *
 * */
public class DCP249 {
    public static void main(String args[]) {
        int[] arr = {12, 22, 34, 3};
       System.out.println(findMaxXOR(arr));
    }

    static int findMaxXOR(int arr[]) {
        int maxXOR = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                maxXOR = Math.max(maxXOR, arr[i] ^ arr[j]);
            }
        }

        return maxXOR;
    }
}
