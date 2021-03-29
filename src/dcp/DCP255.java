package dcp;

/*
* This problem was asked by Microsoft.
*
* The transitive closure of a graph is a measure of which vertices are reachable from other vertices.
* It can be represented as a matrix M, where M[i][j] == 1 if there is a path between vertices i and j,
* and otherwise 0.
*
* For example, suppose we are given the following graph in adjacency list form:

graph = [
    [0, 1, 3],
    [1, 2],
    [2],
    [3]
]
The transitive closure of this graph would be:

[1, 1, 1, 1]
[0, 1, 1, 0]
[0, 0, 1, 0]
[0, 0, 0, 1]
Given a graph, find its transitive closure.
*
* */
public class DCP255 {
    public static void main(String args[]) {
        int[][] graph = {{0, 1, 3}, {1, 2}, {2}, {3}};
        int row = graph.length;
        //  int col = graph[0].length;
        for (int i = 0; i < 4; i++) {
//            int col = graph[i].length;
            for (int j = 0; j < 4; j++) {
//                int colVal = 0;
//                if (j < col) {
//                    if (j == graph[i][j]) {
//                        colVal = 1;
//                    } else {
//                        colVal = graph[i][j];
//                    }
//                }
//
//                if(j == colVal) {
//                    colVal = 1;
//                }

                transitiveGraph[i][j] = 0;
            }
        }
        findTransitiveClosure(graph);

        for (int[] g : transitiveGraph) {
            for (int k : g) {
                System.out.print(k);
            }
            System.out.println();
        }
    }

    static int[][] transitiveGraph = new int[4][4];

    private static void findTransitiveClosure(int[][] graph) {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int col = graph[i].length;
                if (j < col) {
                    if (graph[i][j] >= j) {
                        transitiveGraph[i][j] = 1;
                    } else {
                        transitiveGraph[i][j] = 0;
                    }
                } else {
                    transitiveGraph[i][j] = 0;
                }
            }
        }
    }
}
