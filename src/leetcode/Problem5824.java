package leetcode;

public class Problem5824 {
    public static void main(String args[]) {
        System.out.println(maximumNumber("330", new int[]{9, 3, 6, 3, 7, 3, 1, 4, 5, 8}));
    }


    public static String maximumNumber(String num, int[] change) {
        if (num.length() == 0) {
            return num;
        }

        String result = "";
        boolean updated = false;
        for (int i = 0; i < num.length(); i++) {
            int val = Integer.parseInt(String.valueOf(num.charAt(i)));
            int changeVal = change[val];

            if (changeVal > val) {
                result += changeVal;
                updated = true;
            } else if (val == changeVal) {
                result += val;
            } else {
                if (updated) {
                    for (int j = i; j < num.length(); j++) {
                        result += num.charAt(j);
                    }
                    break;
                }
                result += val;
            }

        }

        return result;
    }
}
