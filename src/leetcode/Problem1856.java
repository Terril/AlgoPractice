package leetcode;

import java.util.Stack;

/*
*
* The min-product of an array is equal to the minimum value in the array multiplied by the array's sum.

For example, the array [3,2,5] (minimum value is 2) has a min-product of 2 * (3+2+5) = 2 * 10 = 20.
Given an array of integers nums, return the maximum min-product of any non-empty subarray of nums.
* Since the answer may be large, return it modulo 109 + 7.

Note that the min-product should be maximized before performing the modulo operation.
* Testcases are generated such that the maximum min-product without modulo will fit in a 64-bit signed integer.

A subarray is a contiguous part of an array.
*
* */

public class Problem1856 {
    public static void main(String args[]) {
        int[] a = {2, 3, 3, 1, 2};
        maxSumMinProduct(a);
    }

    public static int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 1; i <= n; i++) { // prefix Sum
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        Stack<Integer> stk1 = new Stack<>();
        Stack<Integer> stk2 = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) { // find the first element' value < nums[i] in the left
            while (!stk1.isEmpty() && nums[i] <= nums[stk1.peek()]) {
                stk1.pop();
            }
            if (stk1.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stk1.peek();
            }
            stk1.push(i);
        }
        for (int i = n - 1; i >= 0; i--) { //  find the first element' value < nums[i] in the right
            while (!stk2.isEmpty() && nums[i] <= nums[stk2.peek()]) {
                stk2.pop();
            }
            if (stk2.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = stk2.peek();
            }
            stk2.push(i);
        }
        long max = 0;
        for (int i = 0; i < n; i++) { // make current element as Min value
            int l = left[i];
            int r = right[i];
            long sum = prefixSum[r] - prefixSum[l + 1];
            long prod = sum * nums[i];
            max = Math.max(prod, max);
        }
        return (int) (max % 1_000_000_007);
    }
}
