package leetcode;

public class Problem5763 {
    public static void main(String args[]) {
        System.out.println(checkZeroOnes("000100010111101110110000010110000100000111001011110100110110011111111000001000010111001000"));
    }

    public static boolean checkZeroOnes(String s) {
        int len = s.length();

        if (len < 1) {
            return false;
        } else if (len == 1 && s.charAt(0) == '1') {
            return true;
        }

        int oneLength = 0;
        int zeroLength = 0;
        int curOne = 0;
        int curZero = 0;
        for (int i = 1; i < len; i++) {
            char a = s.charAt(i);
            if (a == '1') {
                if (a == s.charAt(i - 1)) {
                    curOne += 1;
                    oneLength = Math.max(oneLength, curOne);
                }
                curZero = 0;

            } else if (a == '0') {
                if (a == s.charAt(i - 1)) {
                    curZero += 1;
                    zeroLength = Math.max(zeroLength, curZero);
                }
                curOne = 0;

            }
        }

        if (oneLength > zeroLength) {
            return true;
        }

        return false;
    }
}
