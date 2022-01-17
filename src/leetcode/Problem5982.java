package leetcode;

public class Problem5982 {
    public static void main(String args[]) {
        int[][] r = {{1,1},{2,2},{3,3},{4,4},{5,5}};
        System.out.println(mostPoints(r));
    }
    public static long mostPoints(int[][] questions) {

        int len = questions.length;
        if(len <= 0) {
            return 0;
        }

        double r = (len / 3.0);
        long r1 =  Math.round(r);
        int sum = 0;
        for(int i = 0 ; i < r1; i++) {
            int[] res1 = questions[i];
            int[] res2 = questions[i + 3];

            int val1 = res1[0];
            int val2 = res2[0];

            int sumV = val1 + val2;

            sum = Math.max(sumV, sum);
        }


        return sum;

    }
}
