package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/*
*
* You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.

You should rearrange the elements of nums such that the modified array follows the given conditions:

Every consecutive pair of integers have opposite signs.
For all integers with the same sign, the order in which they were present in nums is preserved.
The rearranged array begins with a positive integer.
Return the modified array after rearranging the elements to satisfy the aforementioned conditions.


*
* */

public class Problem2149 {
    public static void main(String args[]) {
        int[] in1 = {3,1,-2,-5,2,-4};
        int[] in = {-1,1};
        System.out.println( rearrangeArray(in1));
    }

    public static int[] rearrangeArray(int[] nums) {
        int len = nums.length;
        if(len <= 0) {
            return new int[]{};
        }

        TreeMap<Integer, Integer> set = new TreeMap<Integer, Integer>();
        List<Integer> hasSet = new ArrayList<Integer>();
        int[] res = new int[len];

        int c = 0;
        for(int i = 0 ; i < len ; i++) {
            int a = nums[i];
            if(a > 0) {
                set.put(c++,a);
            } else {
                hasSet.add(a);
            }
        }

        int setLen = set.size() - 1;

        boolean track = true;
        int b = 0;
        int a = 0;
        for(int j = 0 ; j < len ; j++) {
            if(track && setLen >= 0) {
                res[j] = set.get(a);
                a = a + 1;
            } else {
                res[j] = hasSet.get(b);
                b = b + 1;
            }

            track = !track;

        }

        return res;

    }
}
