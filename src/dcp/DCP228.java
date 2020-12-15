package dcp;

import java.util.Arrays;
import java.util.Comparator;

/*
 * This problem was asked by Twitter.
 *
 * Given a list of numbers, create an algorithm that arranges them in order to form the largest possible integer.
 * For example, given [10, 7, 76, 415], you should return 77641510
 * */
public class DCP228 {
    public static void main(String args[]) {
        int[] arr = {10, 7, 76, 415};
        int[] arr1 = {10, 2};
        int[] arr2 = {3, 30, 34, 5, 9};

        System.out.println(findLargestInteger(arr2));
    }

    private static String findLargestInteger(int arr[]) {
        String in[] = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            in[i] = String.valueOf(arr[i]);
        }

        Arrays.sort(in, new Comparator<String>() {

            public int compare(String a, String b) {
                String s1 = a + b;
                String s2 = b + a;
                return s2.compareTo(s1);
            }
        });


        if (in[0].equals("0"))
            return "0";

        StringBuilder sb = new StringBuilder();
        for (String s : in)
            sb.append(s);

        return sb.toString();
    }
}
