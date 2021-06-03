package algoexpert;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumPassesOfMatrix {
    public static void main(String args[]) {

        int[][] matrix = {{0, -1, -3, 2, 0},
                {1, -2, -5, -1, -3},
                {3, 0, 0, -4, -1}};
        System.out.println(minimumPassesOfMatrix(matrix));
    }

    public static int minimumPassesOfMatrix(int[][] matrix) {
        // Write your code here.
        Queue<MatrixParams> queue = new LinkedList<>();
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        int passValue = 0;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                int item = matrix[i][j];
                if (item > 0) {
                    MatrixParams param = new MatrixParams(i, j);
                    queue.add(param);
                }
            }
        }

        while (!queue.isEmpty()) {
            Queue<MatrixParams> currentPass = queue;
            queue = new LinkedList<MatrixParams>();
            while (!currentPass.isEmpty()) {
                MatrixParams val = currentPass.poll();

                Queue<MatrixParams> adjacent = getAdjacentPositions(val, matrix);

                while (!adjacent.isEmpty()) {
                    MatrixParams adjVal = adjacent.poll();

                    int value = matrix[adjVal.rowIndex][adjVal.colIndex];
                    if (value < 0) {
                        matrix[adjVal.rowIndex][adjVal.colIndex] *= -1;
                        MatrixParams p = new MatrixParams(adjVal.rowIndex, adjVal.colIndex);
                        queue.add(p);
                    }
                }
            }

            passValue += 1;
        }
        return (!containsNegative(matrix)) ? passValue - 1 : -1;
    }

    private static boolean containsNegative(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                if (val < 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private static Queue<MatrixParams> getAdjacentPositions(MatrixParams params, int[][] matrix) {
        Queue<MatrixParams> queue = new LinkedList<MatrixParams>();
        int row = params.rowIndex;
        int col = params.colIndex;

        if (row > 0) {
            MatrixParams para1 = new MatrixParams(row - 1, col);
            queue.add(para1);
        }
        if (row < matrix.length - 1) {
            MatrixParams para2 = new MatrixParams(row + 1, col);
            queue.add(para2);
        }
        if (col > 0) {
            MatrixParams para3 = new MatrixParams(row, col - 1);
            queue.add(para3);
        }
        if (col < matrix[0].length - 1) {
            MatrixParams para4 = new MatrixParams(row, col + 1);
            queue.add(para4);
        }

        return queue;
    }

}

class MatrixParams {

    int rowIndex;
    int colIndex;

    MatrixParams(int i, int j) {
        rowIndex = i;
        colIndex = j;
    }
}
