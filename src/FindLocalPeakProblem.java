
/*
* You are given a list of integers nums. Return the index of every peak in the list, sorted in ascending order. An index i is called a peak if all three conditions are true:

The next number on its right that's different than nums[i] doesn't exist or is smaller than nums[i]
The next number on its left that's different than nums[i] doesn't exist or is smaller than nums[i]
There is at least one number on its left or its right that's different than nums[i]
Constraints

0 ≤ n ≤ 100,000 where n is the length of nums
Example 1
Input
nums = [2, 5, 5, 5, 3, 8, 8]
Output
[1, 2, 3, 5, 6]
Explanation
The plateau of 5s are considered peaks. So are the 8s.

Example 2
Input
nums = [3]
Output
[]
Explanation
A list of length 1 is not considered a peak.

Example 3
Input
nums = [2, 2, 2]
Output
[]
* */
public class FindLocalPeakProblem {
    public static void main(String args[]) {

        int[] arr = {2, 5, 5, 5, 3, 8, 8};
        int[] arr1 = {2, 2, 2};
        int[] arr2 = {3};
        int[] arr3 = {3,0};
        int[] ar = solve(arr3);
        for (int i : ar) {
            System.out.println(i);
        }
    }

    public static int[] solve(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return new int[]{};
        }

        int[] peaks = new int[len - 2];
        if (nums[0] >= nums[1])
            return new int[]{};

        if (nums[len - 1] >= nums[len - 2]) {
            peaks[peaks.length - 1] = len - 1;
        }
        int c = 0;
        int skip = 1;
        while (c < len - 2) {
            int prev = nums[c];
            int cur = nums[c + 1];
            int nex = nums[c + 2];
            if (cur >= prev && cur >= nex) {
                peaks[c + 1 - skip] = c + 1;
            } else {
                skip += 1;
            }
            c++;
        }

        return peaks;
    }
}
