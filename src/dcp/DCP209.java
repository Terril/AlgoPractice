package dcp;
/*
* This problem was asked by YouTube.
* Write a program that computes the length of the longest common subsequence of three given strings.
* For example, given "epidemiologist", "refrigeration", and "supercalifragilisticexpialodocious",
* it should return 5, since the longest common subsequence is "eieio".
* */
public class DCP209 {
    public static void main(String args[]) {
        String A = "epidemiologist", B = "refrigeration", C = "supercalifragilisticexpialodocious";

        System.out.println(findLengthOfCommonSequence(A, B, C));
    }

    static int findLengthOfCommonSequence(String A, String B, String C) {
        int x = A.length();
        int y = B.length();
        int z = C.length();

        int[][][] res = new int[x + 1][y + 1][z + 1];

        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                for (int k = 0; k <= z; k++) {
                    if (i == 0 || j == 0 || k == 0) {
                        res[i][j][k] = 0;
                    } else if (A.charAt(i - 1) == B.charAt(j - 1)
                            && A.charAt(i - 1) == C.charAt(k - 1)) {
                        res[i][j][k] = res[i - 1][j - 1][k - 1] + 1;
                    } else {
                        res[i][j][k] = Math.max(Math.max(res[i - 1][j][k], res[i][j - 1][k]), res[i][j][k - 1]);
                    }
                }
            }
        }
        return res[x][y][z];
    }
}
