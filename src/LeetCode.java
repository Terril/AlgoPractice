import java.util.Arrays;

/*
* The frequency of an element is the number of times it occurs in an array.

You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and increment the element at that index by 1.

Return the maximum possible frequency of an element after performing at most k operations.
*
*
*
* 
* Example 1:

Input: nums = [1,2,4], k = 5
Output: 3
Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
4 has a frequency of 3.
Example 2:

Input: nums = [1,4,8,13], k = 5
Output: 2
Explanation: There are multiple optimal solutions:
- Increment the first element three times to make nums = [4,4,8,13]. 4 has a frequency of 2.
- Increment the second element four times to make nums = [1,8,8,13]. 8 has a frequency of 2.
- Increment the third element five times to make nums = [1,4,13,13]. 13 has a frequency of 2.
Example 3:

Input: nums = [3,9,6], k = 2
Output: 1

* */

// TODO : Doesn't pass all the said cases

public class LeetCode {
    public static void main(String args[]) {
        int[] a = {1, 2, 4};
        int[] a1 = {1,4,8,13};
        int[] a2 = {3, 9, 6};
        int[] a3 ={9940,9995,9944,9937,9941,9952,9907,9952,9987,9964,9940,9914,9941,9933,9912,9934,9980,9907,9980,9944,9910,9997};

        System.out.println(maxFrequency(a1, 5));
        ;
    }

    public static int maxFrequency(int[] nums, int k) {
        int i = 0;
        Arrays.sort(nums);
        int count = 1;
        while (i <= k) {
            int temp = 1;
            for (int j = 0; j < nums.length - 1; j++) {
                int it = nums[j];
                nums[j] = it + 1;
                for (int p = nums.length - 1; p > 0 ; p--) {
                    if (nums[j] == nums[p]) {
                        temp += 1;
                        break;
                    }
                }
                if(count < temp) {
                    count = temp;
                }
            }

            i++;
        }

        return count;

    }
}
