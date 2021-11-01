package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* You are given a 0-indexed integer array nums containing distinct numbers, an integer start, and an integer goal. There is an integer x that is initially set to start, and you want to perform operations on x such that it is converted to goal. You can perform the following operation repeatedly on the number x:

If 0 <= x <= 1000, then for any index i in the array (0 <= i < nums.length), you can set x to any of the following:

x + nums[i]
x - nums[i]
x ^ nums[i] (bitwise-XOR)
Note that you can use each nums[i] any number of times in any order. Operations that set x to be out of the range 0 <= x <= 1000 are valid, but no more operations can be done afterward.

Return the minimum number of operations needed to convert x = start into goal, and -1 if it is not possible.
* */
public class Problem2059 {
    public static void main(String args[]) {
        int[] nums = {1, 3};
        int start = 6;
        int goal = 4;

        int[] nums1 = {3,5,7};
        int start1 = 0;
        int goal1 = -4;
        System.out.println(minimumOperations(nums1, start1, goal1));
    }

    public static int minimumOperations(int[] nums, int start, int goal) {
        int ops[] = new int[1001], cnt = 0;
        List<Integer> q = Arrays.asList(goal);
        while (!q.isEmpty()) {
            ++cnt;
            List<Integer> q1 = new ArrayList<>();
            for (int x : q)
                for (int n : nums) {
                    for (int xn : new int[]{x + n, x - n, x ^ n})
                        if (xn >= 0 && xn <= 1000 && ops[xn] == 0) {
                            ops[xn] = cnt;
                            q1.add(xn);
                        }
                }
            q = q1;
        }
        return ops[start] == 0 ? -1 : ops[start];
    }
}
