package dcp;

import java.util.LinkedList;

/*
* This problem was asked by Yahoo.
*
* Write an algorithm that computes the reversal of a directed graph.
* For example, if a graph consists of A -> B -> C, it should become A <- B <- C.
* */
public class DCP218 {

    public static void main(String args[]) {
        Graph graph = new Graph(3);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
//        graph.addEdge(2, 3);
//        graph.addEdge(3, 4);
//        graph.addEdge(4, 0);
        System.out.println("Original Graph");
        graph.printGraph();

        Graph reverse = graph.reverseTheGraph();
        System.out.println("Reverse Graph");
        reverse.printGraph();
    }

    static class Graph {
        int vertex;
        LinkedList<Integer>[] adj;

        Graph(int vertext) {
            vertex = vertext;
            adj = new LinkedList[vertex];

            for (int i = 0; i < vertex; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        void addEdge(int startPos, int endPos) {
            adj[startPos].addFirst(endPos);
        }

        Graph reverseTheGraph() {
            Graph reverseGraph = new Graph(vertex);
            for (int i = 0; i < vertex; i++) {
                LinkedList<Integer> adjList = adj[i];
                int source = i;
                for (int j = 0; j < adjList.size(); j++) {
                    int dest = adjList.get(j);
                    reverseGraph.addEdge(dest, source);
                }
            }
            return reverseGraph;
        }

        void printGraph() {
            for (int i = 0; i < vertex; i++) {
                LinkedList<Integer> adjList = adj[i];
                System.out.println("Vertex connected " + i);
                for (int j = 0; j < adjList.size(); j++) {
                    System.out.print("--> " + adjList.get(j));
                }

                System.out.println();
            }
        }

    }
}
