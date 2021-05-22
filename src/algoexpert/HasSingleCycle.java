package algoexpert;

import java.util.Arrays;

public class HasSingleCycle {
    public static void main(String args[]) {

        int[] a = {2, 3, 1, -4, -4, 2};
        int[] a1 = {1, -1, 1, -1};
        int[] a2 = {1, 1, 1, 1, 2};
        int[] a3 = {10, 11, -6, -23, -2, 3, 88, 908, -26};
        System.out.println(hasSingleCycle(a3));
    }

    public static boolean hasSingleCycle(int[] array) {
        // Write your code here.
        int len = array.length;
        if (len <= 0) {
            return false;
        }
        int[] visited = new int[len];

        Arrays.fill(visited, 0);
        int i = array[0];
        visited[0] = 1;
        int j = 0;
        while (i < len) {
            if (visited[i] == 1) {
                break;
            }
            j = array[i];
            visited[i] = 1;
            i = (i + j) % len;
            if (i < 0) {
                i = i + len;
            }
        }

        for (int k : visited) {
            if (k == 0) {
                return false;
            }
        }

        return true;
    }
}
