package leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaxPoints {
    public static void main(String args[]) {
        int[][] in1 = {{0, 3, 0, 4, 2}, {5, 4, 2, 4, 1}, {5, 0, 0, 5, 1}, {2, 0, 1, 0, 3}};
        int[][] in = {{1, 2, 3}, {1, 5, 1}, {3, 1, 1}};
        System.out.println(maxPointsAlternate(in1));
    }

    public static long maxPoints(int[][] points) {

        int row = points.length;
        int col = points[0].length;

        List<Pair> item = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            int maxValue = points[i][0];
            int jVal = 0;
            for (int j = 1; j < col; j++) {
                int value = points[i][j];
                if (maxValue < value) {
                    maxValue = value;
                    jVal = j;
                }
            }

            Pair pair = new Pair(jVal, maxValue);
            item.add(pair);
        }

        int subCol = 0;
        int total = 0;
        for (int k = 0; k < item.size() - 1; k++) {
            Pair pairCurr = item.get(k);
            Pair pairNext = item.get(k + 1);

            subCol += pairCurr.jVal - pairNext.jVal;
            total += pairCurr.maxVal;
        }

        return total + item.get(item.size() - 1).maxVal - subCol;
    }

    static class Pair {
        int jVal;
        int maxVal;

        Pair(int j, int val) {
            jVal = j;
            maxVal = val;
        }

    }

    /***Correct solution using Dynamic Programming***/
    public static long maxPointsAlternate(int[][] points) {
        long ans = 0;
        int m = points.length, n = points[0].length;
        long[] dp = new long[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[j] += points[i][j];
            }
            for (int j = 1; j < n; j++) {
                dp[j] = Math.max(dp[j], dp[j - 1] - 1);
            }
            for (int j = n - 2; j >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j + 1] - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
