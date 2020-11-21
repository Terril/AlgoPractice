package dcp;

import java.util.LinkedList;

public class DCP207 {
    static int V = 4;

    public static void main(String args[]) {
        int G[][] = { { 0, 1, 0, 1 },
                { 1, 0, 1, 0 },
                { 0, 1, 0, 1 },
                { 1, 0, 1, 0 } };

        if (isBipartite(G))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private static boolean isBipartite(int G[][]) {

        int[] colorArr = new int[V];
        for (int v = 0; v < V; ++v)
            colorArr[v] = -1;


        for (int v = 0; v < V; v++) {
            if (colorArr[v] == -1) {
                if (!isBipartiteUtil(G, v, colorArr))
                    return false;
            }
        }

        return true;
    }

    private static boolean isBipartiteUtil(int G[][], int src, int colorArr[]) {

        colorArr[src] = 1;

        LinkedList<Integer> lst = new LinkedList<Integer>();
        lst.add(src);

        while (!lst.isEmpty()) {

            int u = lst.getFirst();
            lst.pop();

            if (G[u][u] == 1) {
                return false;
            }

            for (int i = 0; i < V; i++) {
                if (G[u][i] == 1 && colorArr[i] == -1) {
                    colorArr[i] = 1 - colorArr[u];
                    lst.push(i);
                } else if (G[u][i] == 1 && colorArr[i] == colorArr[u]) {
                    return false;
                }
            }
        }
        return true;
    }
}
