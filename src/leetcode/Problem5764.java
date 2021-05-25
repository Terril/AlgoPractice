package leetcode;

public class Problem5764 {
    public static void main(String args[]) {
        int[] d = {1, 1, 100000};
        double h = 2.01;

        System.out.println(minSpeedOnTime(d, h));
    }

    public static int minSpeedOnTime(int[] dist, double hour) {
        int min = Integer.MAX_VALUE;

        for (int d : dist) {
            double val = 0.0;
            int j = 0;
            while (j < dist.length - 1 ) {
                double sum = (double) dist[j] / d;
                val += Math.ceil(sum);
                j++;
            }
            double sum = (double) dist[j] / d;
            val += sum;
            if(val <= hour) {
                min = Math.min(min, d);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
