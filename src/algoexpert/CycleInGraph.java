package algoexpert;

import java.util.Iterator;
import java.util.LinkedList;

public class CycleInGraph {
    public static void main(String args[]) {
        int[][] input = {{1, 3}, {2, 3, 4}, {0}, {}, {2, 5}, {}};
        System.out.println(cycleInGraph(input));
    }

    public static boolean cycleInGraph(int[][] edges) {
        // Write your code here.
        Edges edge = new Edges(edges.length);
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[i].length; j++) {
                edge.addEdge(i, edges[i][j]);
            }
        }

        return edge.dfs();
    }

    static class Edges {
        LinkedList<Integer> adj[];
        int V;

        Edges(int totalEdges) {
            V = totalEdges;
            adj = new LinkedList[totalEdges];
            for (int i = 0; i < totalEdges; ++i)
                adj[i] = new LinkedList();
        }

        public void addEdge(int v, int u) {
            adj[u].add(v);
        }

        boolean dfs() {
            boolean visited[] = new boolean[V];
            for (int j = 0; j < V; j++) {
                if (!visited[j]) {
                    dfsUtil(j, visited);
                } else {
                    return true;
                }
            }

            return false;
        }

        void dfsUtil(int u, boolean visited[]) {
            visited[u] = true;
            System.out.print(u + " ");

            // Recur for all the vertices adjacent to this
            // vertex
            Iterator<Integer> i = adj[u].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n])
                    dfsUtil(n, visited);
            }
        }
    }
}
