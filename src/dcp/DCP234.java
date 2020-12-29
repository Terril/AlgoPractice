package dcp;

import java.util.Arrays;

/*
 * This problem was asked by Microsoft.
 *
 * Recall that the minimum spanning tree is the subset of edges of a tree that connect
 * all its vertices with the smallest possible total edge weight.
 * Given an undirected graph with weighted edges, compute the maximum weight spanning tree.
 * */
public class DCP234 {
    public static void main(String args[]) {
        int V = 4; // Number of vertices in graph
        int E = 5; // Number of edges in graph
        Graph graph = new Graph(V, E);

// add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;

// add edge 0-2
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;

// add edge 0-3
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;

// add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;

// add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;

 graph.mst();
   //     graph.mst2();
    }


    private static class Graph {
        // A class to represent a graph edge
        class Edge implements Comparable<Edge> {
            int src, dest, weight;

            // Comparator function used for sorting edges
// based on their weight
            @Override
            public int compareTo(Edge compareEdge) {
                return this.weight - compareEdge.weight;
            }
        }

        ;

        int V, E; // V-> no. of vertices & E->no.of edges
        Edge edge[]; // collection of all edges

        // Creates a graph with V vertices and E edges
        Graph(int v, int e) {
            V = v;
            E = e;
            edge = new Edge[E];
            for (int i = 0; i < e; ++i)
                edge[i] = new Edge();
        }

        public void mst() {
            Arrays.sort(edge);
            boolean[] visited = new boolean[V];
            for (Edge e : edge) {
                if (visited[e.src] && visited[e.dest]) continue;
                System.out.println(e.src + " -> " + e.dest + " : " + e.weight);
                visited[e.src] = true;
                visited[e.dest] = true;
            }
        }

        public void mst2() {
            int[] vert = new int[V];
            for (int i = 0; i < V; i++) vert[i] = i;
            Arrays.sort(edge);
            for (Edge e : edge) {
                if (union(e.src, e.dest, vert)) {
                    System.out.println(e.src + " -> " + e.dest + " : " + e.weight);
                }
            }
        }

        private int find(int pos, int[] p) {
            while (p[pos] != pos) {
                p[pos] = p[p[pos]];
                pos = p[pos];
            }
            return pos;
        }

        private boolean union(int src, int dest, int[] vert) {
            int i = find(src, vert);
            int j = find(dest, vert);
            if (i != j) {
                vert[i] = j;
                return true;
            } else return false;
        }
    }
}
