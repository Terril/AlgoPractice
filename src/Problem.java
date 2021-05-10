public class Problem {
    public static void main(String args[]) {
        int[][] a = {
                {1, 0, 1}, {1, 0, 0}, {1, 0, 0}
        };
        int[][] b = {
                {1, 0, 0}, {1, 0, 1}, {1, 0, 0}
        };
        int[][] x = {
                {1}, {1}
        };
        int[][] y = {
                {1}, {0}
        };
        //  System.out.println(solve(x, y));

        String xy = "bca???de";
        String ab = "zxa";
        String cd = "zyx";
        String ef = "bc?????de";
        String jk = "bc?a?a?bde";
        System.out.println(solve(jk));
    }

    public static int solve(int[][] a, int[][] b) {
        int M = a.length;
        int N = b[0].length;
        int count = 0;
        for (int i = 0; i < M; i++) {
            int sum = 0;
            boolean isIsland = false;
            for (int j = 0; j < N; j++) {
                if (a[i][j] == b[i][j]) {
                    if (a[i][j] == 1) {
                        isIsland = true;
                    }
                    sum += 1;
                }

                if (sum == b[i].length && isIsland) {
                    count += 1;
                }
            }
        }

        return count;
    }

    public static int solve(String s) {
        int len = s.length();
        String sub = "";
        int count = 0;
        char a = 'a';
        for (int i = 0; i < len - 1; i++) {
            char c = s.charAt(i);
            char c1 = s.charAt(i + 1);
            if (c == '?' && c1 != a) {
                c = a;
            }
            if (c == a) {
                a += 1;
                sub += c;//s.substring(i, len);
            }

        }
        if (!sub.equals("")) {
            count = sub.length();
        }


        return count;
    }
}

