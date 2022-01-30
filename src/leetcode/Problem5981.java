package leetcode;

import java.util.*;

public class Problem5981 {
    public static void main(String args[]) {
        int n[] = {0, 0, 1, 0};
        List<Integer> r = maxScoreIndices(n);

        for (int i = 0; i < r.size(); i++) {
            System.out.println(r.get(i));
        }
    }

    public static List<Integer> maxScoreIndices(int[] nums) {

        List<Result> res = new ArrayList<Result>();
        List<Integer> output = new ArrayList<Integer>();

        for (int i = 0; i <= nums.length; i++) {
            int zeroResult = iteratorResult(0, i, nums, 0);
            int oneResult = iteratorResult(i, nums.length , nums, 1);

            int result = zeroResult + oneResult;
            Result r = new Result(result, i);
            res.add(r);
        }

        Collections.sort(res, new SortbyValue());
        for (int i = res.size() - 1; i >= 0; i--) {
            Result out = res.get(i);

            if (out.res == res.get(res.size() - 1).res) {
                output.add(out.p);
            }
        }

        return output;
    }

    private static int iteratorResult(int start, int end, int[] n, int checkValue) {
        int count = 0;
        for (int j = start; j < end; j++) {
            int val = n[j];
            if (val == checkValue) {
                count = count + 1;
            }
        }

        return count;
    }

    static class Result {
        int res, p;

        Result(int r, int pos) {
            res = r;
            p = pos;
        }
    }

    static class SortbyValue implements Comparator<Result> {

        @Override
        public int compare(Result o1, Result o2) {
            return o1.res - o2.res;
        }
    }
}
