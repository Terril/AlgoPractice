package algoexpert;

public class RemoveIslands {
    public static void main(String args[]) {
        int[][] input = {{1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1},
                {0, 0, 1, 0, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 1}};

        int[][] out = removeIslands(input);

        for (int[] i : out) {
            for (int j : i) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    public static int[][] removeIslands(int[][] matrix) {
        // Write your code here.
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        int visited[][] = new int[rowLen][colLen];

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                visited[i][j] = -1;
            }
        }
        IslandData data = new IslandData(visited, matrix);
        int i = 0;
        while (i < rowLen) {
            int j = 0;
            if (visited[i][j] == -1) {
                while (j < colLen) {
                    if (visited[i][j] == -1) {
                        data = doDFS(matrix, visited, i, j, data);
                    }
                    j++;
                }
            }
            i++;
        }

        return data.inputData;
    }

    public static IslandData doDFS(int[][] inp, int[][] vis,
                                   int i, int j, IslandData data) {
        int currentValue = inp[i][j];

        if (currentValue == 1) {
            data = performSearch(i, j, inp, vis, data);
        } else {
            vis[i][j] = 1;
            data.visited = vis;
        }

        return new IslandData(data.visited, data.inputData);
    }

    public static IslandData performSearch(int i, int j,
                                           int[][] inp, int[][] vis,
                                           IslandData data) {

        if (i > 0 && i < inp.length - 1 && j > 0 && j < inp[0].length - 1 && vis[i][j] == -1) {
//
//            if (i - 1 == 0 && inp[i - 1][j] == 1) {
//                vis[i - 1][j] = 1;
//                doDFS(inp, vis, i, j - 1, data);
//            }
//
//            if (j - 1 == 0 && inp[i][j - 1] == 1) {
//                vis[i][j - 1] = 1;
//                doDFS(inp, vis, i - 1, j, data);
//            }
//
//            if (i + 1 != inp.length  && inp[i + 1][j] == 1) {
//                vis[i + 1][j] = 1;
//                doDFS(inp, vis, i + 1, j, data);
//            }
//
//            if (j + 1 != inp[0].length && inp[i][j + 1] == 1) {
//                vis[i][j + 1] = 1;
//                doDFS(inp, vis, i, j + 1, data);
//            }

            if (inp[i - 1][j] == 1) {
                vis[i - 1][j] = 1;
                performSearch(i, j - 1,inp, vis,  data);
            } else if (inp[i][j - 1] == 1) {
                vis[i][j - 1] = 1;
                performSearch(i - 1, j,inp, vis,  data);
            } else if (i + 1 < inp.length && inp[i + 1][j] == 1) {
                vis[i + 1][j] = 1;
                performSearch(i + 1, j, inp, vis, data);
            } else if (j + 1 < inp[0].length && inp[i][j + 1] == 1) {
                vis[i][j + 1] = 1;
                performSearch(i, j + 1, inp, vis,  data);
            } else {
                inp[i][j] = 0;
            }
        }

        vis[i][j] = 1;
        return new IslandData(vis, inp);
    }

    static class IslandData {

        int[][] visited;
        int[][] inputData;

        public IslandData(int[][] vis, int[][] input) {
            visited = vis;
            inputData = input;
        }
    }
}
