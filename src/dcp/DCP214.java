package dcp;

/*
*
* This problem was asked by Stripe.
*
* Given an integer n,
* return the length of the longest consecutive run of 1s in its binary representation.
*
* For example, given 156, you should return 3.*/
public class DCP214 {
    public static void main(String args[]) {
        int n = 156;
        System.out.println(findLongestConsecitive1s(n));
    }

    private static int findLongestConsecitive1s(int num) {

        int count = 0;
        while (num != 0) {
            num = num & (num << 1);
            count++;
        }

        return count;
    }
}
