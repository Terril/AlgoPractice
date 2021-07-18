package leetcode;

public class AddMinimumRungs {
    public static void main(String args[]) {
        int[] in = {3, 4, 6, 7};
        int[] in1 = {3};
        System.out.println(addRungs1(in, 2));
    }

    public int addRungs(int[] rungs, int dist) {
        if(rungs.length == 0) {
            return 0;
        }


        int count = 0;
        if(rungs[0] > dist) {
            count = rungCount(rungs[0], dist, count);
        }
        for (int i = 1; i < rungs.length; i++) {
            int prev = rungs[i - 1];
            int curr = rungs[i];

            int value = curr - prev;
            if( value <= dist) continue;
            else {
                count = rungCount(value, dist, count);
            }
        }

        return count;
    }

    private int rungCount(int value, int dist, int count) {
        if(value <= dist) {
            return count;
        }
        value = value - dist;
        count+=1;
        int outcount = rungCount(value, dist, count);
        return outcount;
    }


    /*** Correct and effective solution ***/
    private static int addRungs1(int[] rungs, int dist) {
        int count = 0;
        int prev = 0;
        for(int r : rungs) {
            count += (r - prev - 1) / dist;
            prev = r;
        }

        return count;
    }
}
