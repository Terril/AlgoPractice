package dcp;

/*
 *
 * This problem was asked by Square.
 *
 * In front of you is a row of N coins, with values v1, v1, ..., vn.
 *
 * You are asked to play the following game.
 * You and an opponent take turns choosing either the first or last coin from the row,
 * removing it from the row, and receiving the value of the coin.
 *
 * Write a program that returns the maximum amount of money you can win with certainty,
 * if you move first, assuming your opponent plays optimally.*/
public class DCP220 {
    public static void main(String args[]) {
        int arr[] = {8, 15, 3, 7};
        int arr3[] = { 20, 30, 2, 2, 2, 10 };
        System.out.println(maxAmount(arr3, arr3.length));
    }

    private static int maxAmount(int arr[], int arrLen) {

        int[][] table = new int[arrLen][arrLen];
        int gap, i, j;
        int x, y, z;
        for (gap = 0; gap < arrLen; ++gap) {
            for (i = 0, j = gap; j < arrLen; i++, j++) {
                x = (i + 2 <= j) ? table[i + 2][j] : 0;
                y = (i + 1 <= j - 1) ? table[i + 1][j - 1] : 0;
                z = (i <= j - 2) ? table[i][j - 2] : 0;

                table[i][j] = Math.max(arr[i] + Math.min(x, y), arr[j] + Math.min(y, z));
            }
        }

        return table[0][arrLen - 1];
    }
}
