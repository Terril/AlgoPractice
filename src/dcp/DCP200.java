package dcp;


//This problem was asked by Microsoft.
//        Let X be a set of n intervals on the real line.
//        We say that a set of points P "stabs" X if every interval in X contains at least one point in P.
//        Compute the smallest set of points that stabs X.
//        For example, given the intervals [(1, 4), (4, 5), (7, 9), (9, 12)], you should return [4, 9]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DCP200 {
    public static void main(String args[]) {
        Interval a = new Interval(1, 4);
        Interval b = new Interval(4, 5);
        Interval c = new Interval(7, 9);
        Interval d = new Interval(9, 12);
        Interval e = new Interval(13, 15);
        Interval arr[] = {a, b, c, d, e};


        Interval in = computeSmallestSetOfSTabs(arr);
        System.out.println(in.start + "," + in.end);

    }

    static class Interval {
        int start, end;

        public Interval(int i, int i1) {
            start = i;
            end = i1;
        }

    }

    private static Interval computeSmallestSetOfSTabs(Interval arr[]) {
        int len = arr.length;
        Interval be = arr[0];
        //  int sepVal = 0;
        Interval res = new Interval(0, 0);
        List<Integer> intervals = new ArrayList<>();
        intervals.add(0, 1);
        for (int i = 1; i < len; i++) {
            Interval nw = arr[i];
            if (be.end != nw.start) {
                int sepVal = nw.start - be.end;
                if (sepVal > 0 && sepVal >= intervals.get(0)) {
                    res = new Interval(be.start, nw.end);
                    intervals.add(0, sepVal);
                }
            }

            be = nw;
        }

        return res;
    }
}
