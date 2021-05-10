package leetcode;

import java.util.HashSet;

public class Problem5751 {
    public static void main(String args[]) {
        int a[] = {55, 30, 5, 4, 2};
        int b[] = {100, 20, 10, 10, 5};
        System.out.println(maxDistance(a, b));
        ;
    }

    public static int maxDistance(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int len1 = nums2.length;

        HashSet<Pair> set = new HashSet();
        int sumMax = 0;
        for (int i = 0; i < len; i++) {
            int vali = nums1[i];
            for (int j = 0; j < len1; j++) {
                int valj = nums2[j];
                int sub = valj - vali;
                if (sub >= 0) {
                    Pair p = new Pair(i, j);
                    set.add(p);
                }
            }

        }

        for (Pair pair : set) {
            int max = pair.end - pair.start;
            sumMax = Math.max(max, sumMax);
        }


        return sumMax;

    }

    static class Pair {
        int start;
        int end;

        Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
