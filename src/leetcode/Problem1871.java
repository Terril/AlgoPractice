package leetcode;

public class Problem1871 {
    public static void main(String args[]) {
        System.out.println(canReach1("01", 1, 1));
    }

    public static boolean canReach(String s, int minJump, int maxJump) {

        int len = s.length();

        if (len < minJump || maxJump > len - 1) {
            return false;
        }

        int currentJump = maxJump;

        char x = s.charAt(currentJump);
        if (x == '0') {
            if (currentJump == len - 1) {
                return true;
            } else {
                currentJump += minJump;
            }
        } else {
            canReach(s, maxJump, minJump);
        }
        if (currentJump <= len - 1) {
            char y = s.charAt(currentJump);
            if (y == '0' && currentJump == len - 1) {
                return true;
            } else {
                canReach(s, minJump, currentJump + maxJump);
            }
        }

        return false;
    }

    public static boolean canReach1(String s, int minJump, int maxJump) {
        int n = s.length(), pre = 0;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 1; i < n; ++i) {
            if (i >= minJump && dp[i - minJump])
                pre++;
            if (i > maxJump && dp[i - maxJump - 1])
                pre--;
            dp[i] = pre > 0 && s.charAt(i) == '0';
        }
        return dp[n - 1];
    }
}
