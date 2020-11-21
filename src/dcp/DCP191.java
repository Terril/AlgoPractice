package dcp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class DCP191 {
    public static void main(String args[]) {
       // int arr[][] = {{7, 9}, {2, 4}, {5, 8}};
       // int arr[][] = {{1, 2}, {2, 3}};
        int arr[][] = {{1, 2}, {1, 2}, {1, 2}};
        int ar[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                ar[i] = arr[i][j];
            }
        }
        int removeCount = eraseOverlapIntervals(arr);

        System.out.println(removeCount);
    }

//    static class myComparator implements Comparator<int> {
//        public int compare(int a, int b) {
//            return a - b;
//        }
//    }


    // Only 66% correct solution

    public static int eraseOverlapIntervals(int[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
//        Arrays.sort(intervals, new myComparator());
        int end = intervals[0], prev = 0, count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[prev] > intervals[i]) {
                prev = i;
            }
            else {
                //compare ends to detemine to consider or drop interval[i]
                if (intervals[i] <= prev) {
                    prev = intervals[i];
                }
                count++;
            }
//            else {
//                prev = i;
//            }
        }
        return count;
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length < 2) {
            return 0;
        }
        Collections.sort(Arrays.asList(intervals), (a, b) -> Integer.compare(a[0], b[0]));
        int min = 0;
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= prev[1]) {
                prev = intervals[i];
            } else {
                //compare ends to detemine to consider or drop interval[i]
                if (intervals[i][1] <= prev[1]) {
                    prev = intervals[i];
                }
                min++;
            }

        }
        return min;
    }

}

