package algoexpert;

import java.util.ArrayList;
import java.util.List;

public class ZigZagATwoDimensionalArray {
    public static void main(String args[]) {
        int[][] in = {
                {1, 3, 4, 10},
                {2, 5, 9, 11},
                {6, 8, 12, 15},
                {7, 13, 14, 16}
        };

        List<List<Integer>> out = new ArrayList<>();
        for (int[] i : in) {
            ArrayList<Integer> arrIn = new ArrayList();
            for (int j : i) {
                arrIn.add(j);
            }
            out.add(arrIn);
        }

        List<Integer> res = zigzagTraverse(out);
        for (int i: res) {
            System.out.println(i);
        }
    }

    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        // Write your code here.
        int height = array.size() - 1 ;
        int width = array.get(0).size() - 1;
        List<Integer> res = new ArrayList<>();
        // for(int i = 0 ; i < row; i++) {
        // 	for(int j = 0 ; j < array.get(i).size();j ++) {
        // 		move(array, i, j, res);
        // 	}
        // }
        int row = 0;
        int col = 0;
        boolean isGoingDown = true;
        while (!isInBounds(row, col, height, width)) {
            res.add(array.get(row).get(col));
            if (isGoingDown) {
                if (col == 0 || row == height) {
                    isGoingDown = false;
                    if (row == height) {
                        col++;
                    } else {
                        row++;
                    }
                } else {
                    row++;
                    col--;
                }
            } else {
                if (row == 0 || col == width) {
                    isGoingDown = true;
                    if (col == width) {
                        row++;
                    } else {
                        col++;
                    }
                } else {
                    col++;
                    row--;
                }
            }
        }


        //  move(array, 0, 0, res, false, row, col);
        return res;
    }

    private static boolean isInBounds(int row, int col, int height, int width) {
        return row < 0 || row > height || col < 0 || col > width;
    }

    private static void move(List<List<Integer>> array, int i, int j, List<Integer> res,
                             boolean isDown, int row, int col) {
        if (i == array.size() && j == array.get(0).size()) {
            return;
        }

        if (i < row - 1 && j == 0) {
            res.add(array.get(i).get(j));
            if (!isDown) {
                move(array, i + 1, j, res, true, row, col);
            } else {
                move(array, i - 1, j + 1, res, true, row, col);
            }
        } else if (i == 0 && j < col - 1) {
            res.add(array.get(i).get(j));
            if (!isDown) {
                move(array, i + 1, j - 1, res, true, row, col);
            } else {
                move(array, i, j + 1, res, false, row, col);

            }
        } else {
            res.add(array.get(i).get(j));
            if (isDown) {
                move(array, i + 1, j - 1, res, true, row, col);
            } else {
                move(array, i - 1, j + 1, res, false, row, col);
            }
        }

        // res.add(array.get(i).get(j));
        // move(array, i + 1 , j, res);
        // move(array, i , j - 1, res);

    }
}
