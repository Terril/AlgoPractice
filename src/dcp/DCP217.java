package dcp;
/*
* This problem was asked by Oracle.
*
* We say a number is sparse if there are no adjacent ones in its binary representation.
* For example, 21 (10101) is sparse, but 22 (10110) is not.
* For a given input N, find the smallest sparse number greater than or equal to N.
* Do this in faster than O(N log N) time.
* */
public class DCP217 {
    public static void main(String args[]) {
        int input = 21;
        System.out.println(findSmallestSparseNumber(input));
    }

    private static int findSmallestSparseNumber(int input) {
        input = input + 1;
        while (isSparse(input)) {
            input++;
        }
        return input;
    }

    private static boolean isSparse(int input) {
//        int q;
//        int temp = 0;
//        while (input != 0) {
//            q = input % 2;
//            input = input / 2;
//
//            if (q == 1 && temp == 1) {
//                return false;
//            }
//
//            temp = q;
//        }
//        return true;

        int parse = input & input << 1;

        return parse != 0;
    }
}
