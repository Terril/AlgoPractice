package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
 Minimum Operations to Make a Uni-Value Grid

 You are given a 2D integer grid of size m x n and an integer x.
 In one operation, you can add x to or subtract x from any element in the grid.

 A uni-value grid is a grid where all the elements of it are equal.

 Return the minimum number of operations to make the grid uni-value. If it is not possible, return -1.
* */
public class Problem2033 {
    public static void main(String args[]) {
        int[][] grid = {{1, 2}, {3, 4}};
        int[][] grid2 = {{1,5},{2,3}};
        System.out.println(minOperations2(grid2, 1));
    }

    public static int minOperations(int[][] grid, int x) {

        List<Integer> singleArray = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                singleArray.add(grid[i][j]);
            }
        }


        int a = singleArray.get(0);
        int b = singleArray.get(1);
        int c = singleArray.get(2);

        int median = Math.abs((a + b + c) / 3);
        int result = 0;
        for (int i = 0; i < singleArray.size(); i++) {
            int item = singleArray.get(i);
            if (item > median) {
                while (item > median) {
                    item = item - x;
                    result++;
                }
            } else if (item < median) {
                while (item < median) {
                    item = item + x;
                    result++;
                }
            }
        }

        return result;
    }

    private static int minOperations2(int[][] grid, int x) {
        ArrayList<Integer> al = new ArrayList<>();
        int rows = grid.length, cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                al.add(grid[i][j]);
            }
        }
        Collections.sort(al);
        int median = al.get((al.size() - 1) / 2);
        int count = 0;
        for (int i : al) {
            if (i != median) {
                int diff = Math.abs(i - median);
                if (diff % x != 0) return -1;
                count += diff / x;
            }
        }
        return count;
    }
}
