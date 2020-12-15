package dcp;

/*
 * This problem was asked by Facebook.
 *
 * Boggle is a game played on a 4 x 4 grid of letters.
 * The goal is to find as many words as possible that can be formed by a sequence of adjacent letters in the grid,
 * using each cell at most once. Given a game board and a dictionary of valid words,
 * implement a Boggle solver.
 * */
public class DCP227 {
    static int M = 3, N = 3;

    public static void main(String args[]) {
        String dictionary[] = {"GEEKS", "FOR", "QUIZ", "GO"};
        char boggle[][] = {{'G', 'I', 'Z'},
                {'U', 'E', 'K'},
                {'Q', 'S', 'E'}};

        String input = "";
        findTheBoggler(boggle, dictionary, M, N, input);
    }

    private static void findTheBoggler(char[][] bog, String[] dict, int m, int n, String in) {
        boolean visited[][] = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                findTheBogglerUtil(bog, visited, row, col, in, dict);
            }
        }
    }

    private static void findTheBogglerUtil(char[][] bog, boolean[][] visited, int m, int n, String in, String[] dict) {
        visited[m][n] = true;
        in = in + bog[m][n];
        if (isAWord(in, dict)) {
            System.out.println(in);
        }
        for (int row = m - 1; row <= m + 1 && row < M; row++)
            for (int col = n - 1; col <= n + 1 && col < N; col++)
                if (row >= 0 && col >= 0 && !visited[row][col])
                    findTheBogglerUtil(bog, visited, row, col, in, dict);

        in = "" + in.charAt(in.length() - 1);
        visited[m][n] = false;
    }

    private static boolean isAWord(String input, String[] dict) {
        for (int i = 0; i < dict.length; i++) {
            if (input.equals(dict[i])) {
                return true;
            }
        }
        return false;
    }
}
