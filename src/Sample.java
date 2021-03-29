import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'minMoves' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER startRow
     *  3. INTEGER startCol
     *  4. INTEGER endRow
     *  5. INTEGER endCol
     */

    static int[][] dp;

    public static int moves(int n, int startRow, int startCol, int endRow, int endCol, int[][] arr) {
        dp = arr;

        return minMoves(startRow, startCol, endRow, endCol);
    }

    public static int minMoves(int startRow, int startCol, int endRow, int endCol) {
        // Write your code here
        if (startRow == endRow && startCol == endCol) {
            return dp[0][0];
        } else if (dp[Math.abs(startRow - endRow)][Math.abs(startCol - endCol)] != 0) {
            return dp[Math.abs(startRow - endRow)][Math.abs(startCol - endCol)];
        } else {
            int x1, y1, x2, y2;

            if (startRow <= endRow) {
                if (startCol <= endCol) {
                    x1 = startRow + 2;
                    y1 = startCol + 1;
                    x2 = startRow + 1;
                    y2 = startCol + 2;
                } else {
                    x1 = startRow + 2;
                    y1 = startCol - 1;
                    x2 = startRow + 1;
                    y2 = startCol - 2;
                }
            } else if (startCol <= endCol) {
                x1 = startRow - 2;
                y1 = startCol + 1;
                x2 = startRow - 1;
                y2 = startCol + 2;
            } else {
                x1 = startRow - 2;
                y1 = startCol - 1;
                x2 = startRow - 1;
                y2 = startCol - 2;
            }

            dp[Math.abs(startRow - endRow)][Math.abs(startCol - endCol)] =
                    Math.min(minMoves(x1, y1, endRow, endCol), minMoves(x2, y2, endRow, endCol)) + 1;

            dp[Math.abs(startCol - endCol)][Math.abs(startRow - endRow)] = dp[Math.abs(startRow - endRow)][Math.abs(startCol - endCol)];

            return dp[Math.abs(startRow - endRow)][Math.abs(startCol - endCol)];
        }
    }

}


class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int startRow = Integer.parseInt(bufferedReader.readLine().trim());

        int startCol = Integer.parseInt(bufferedReader.readLine().trim());

        int endRow = Integer.parseInt(bufferedReader.readLine().trim());

        int endCol = Integer.parseInt(bufferedReader.readLine().trim());
        int[][] dp = new int[n][n];

        dp[1][0] = 3;
        dp[0][1] = 3;
        dp[1][1] = 2;
        dp[2][0] = 2;
        dp[0][2] = 2;
        dp[2][1] = 1;
        dp[1][2] = 1;

        int result = Result.moves(n, startRow, startCol, endRow, endCol, dp);

        System.out.print(result);
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

        bufferedReader.close();
//        bufferedWriter.close();
    }
}
