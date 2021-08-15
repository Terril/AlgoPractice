package leetcode;

public class Problem5832 {
    public static void main(String args[]) {
        int[] in = new int[]{29,27,46,37,17,20,15,5,28,48,36,39,42,24,21,1,31};
        int[] in1 = new int[] {2,1,0,3};
        rearrangeArray(in1);
    }

    public static int[] rearrangeArray(int[] nums) {

        if (nums.length == 0 || nums.length < 3) {
            return nums;
        }

        for (int i = 1; i < nums.length - 1; i++) {
            float sum = (float) (nums[i - 1] + nums[i + 1]) / 2;
            if (sum == nums[i]) {
                int j = Math.min(nums[i -1], Math.min(nums[i], nums[i + 1]));
                if(j == nums[i]) {
                    j = i;
                } else if(j == nums[i - 1]) {
                    j = i -1;
                } else {
                    j = i + 1;
                }
                swap(i, j, nums);
            }
        }

        return nums;

    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
