package leetcode;

public class Problem5851 {
    static String upString = "";
    public static void main(String args[]) {
        System.out.println(findDifferentBinaryString(new String[]{"110","111","010"}));
    }
    public static String findDifferentBinaryString(String[] nums) {
        if(nums.length <= 0 ) {
            return "";
        }

        String first = nums[0];
        findResult(nums, first, 0);
        return upString;

    }

    private static void findResult(String[] nums, String first, int inc) {

        upString = changeString(first, inc);
        for(int i = 1; i < nums.length; i++) {
            if(upString.equals(nums[i])) {
                inc = inc+1;
                findResult(nums, first, inc);
            }
        }
    }

    private static String changeString(String first, int inc) {
        if(inc > first.length()) {
            return "";
        }
        char ch = first.charAt(inc);
        String updated = "";
        for(int i = 0 ; i < first.length(); i++) {
            if(inc == i) {
                if(ch == '0') {
                    updated += '1';
                } else {
                    updated += '0';
                }
            } else {
                updated += first.charAt(i);
            }

        }

        return updated;

    }
}
