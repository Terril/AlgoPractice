package dcp;

import java.util.*;

/*
 * This problem was asked by Mozilla.
 *
 * A bridge in a connected (undirected) graph is an edge that,
 * if removed, causes the graph to become disconnected. Find all the bridges in a graph.
 *
 * */
public class DCP262 {
    public static void main(String args[]) {
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        g1.findBridge();
        System.out.println();
    }

    static class Graph {
        int V;
        private LinkedList<Integer> adj[];
        final int NIL = -1;
        int time = 0;

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        // Function to add an edge into the graph
        void addEdge(int v, int w) {
            adj[v].add(w);  // Add w to v's list.
            adj[w].add(v);    //Add v to w's list//Add v to w's list
        }

        void findBridge() {

            int[] low = new int[V];
            int[] parent = new int[V];
            int[] disc = new int[V];
            boolean[] visited = new boolean[V];

            for (int i = 0; i < V; i++) {
                visited[i] = false;
                parent[i] = NIL;
            }

            for (int i = 0; i < V; i++)
                if (!visited[i])
                    bridgeUtil(i, visited, low, parent, disc);
        }

        void bridgeUtil(int i, boolean[] visited, int[] low, int[] parent, int[] discovered) {

            visited[i] = true;
            discovered[i] = low[i] = ++time;
            Iterator<Integer> j = adj[i].iterator();
            while (j.hasNext()) {

                int k = j.next();
                if (!visited[k]) {
                    parent[k] = i;
                    bridgeUtil(k, visited, low, parent, discovered);

                    low[i] = Math.min(low[i], low[k]);

                    if (low[k] > discovered[i]) {
                        System.out.println(i + " " + k);
                    }
                } else if (k != parent[i])
                    low[i] = Math.min(low[i], discovered[k]);
            }
        }
    }


}
