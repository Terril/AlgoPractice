package algoexpert;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RiverSizes {
    public static void main(String args[]) {
        int[][] arr = {
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0}};
        riverSizes(arr);
    }

    public static List<Integer> riverSizes(int[][] matrix) {
        // Write your code here.
        int row = matrix.length;
        int col = matrix[0].length;

        List<Integer> riverList = new ArrayList<Integer>();
        int i = 1;
        while (i < col) {
            int j = 0;
            while (j < row) {
                int item = matrix[i][j];
                if (item == 1) {
                    if (matrix[i - 1][j] >= 1) {
                        matrix[i][j] += matrix[i - 1][j];
                    }
                    if (j - 1 >= 0 &&  matrix[i][j - 1] >= 1) {
                        matrix[i][j] += matrix[i][j - 1] ;
                    }
                }
                j++;
            }
            i++;
        }
        
        return riverList;
    }
}
