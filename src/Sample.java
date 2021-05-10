
public class Sample {

    public static void main(String args[]) {
        int[][] mat = {{1, 10, 4}, {9, 3, 8}, {15, 16, 17}};
        int[][] mat1 = {{10, 41}, {3, 5}, {16, 2}};
        System.out.println(minMax(mat));
    }


    private static int minMax(int[][] m) {

        int len = m.length;
        int len1 = m[0].length;

        int min = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int v = m[i][0];
            for (int j = 0; j < m[i].length; j++) {
                int v1 = m[i][j];
                min = Math.min(v1, min);
            }

            min = Math.max(v, min);
        }


        return min;
    }
}
