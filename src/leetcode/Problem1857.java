package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
*
* There is a directed graph of n colored nodes and m edges. The nodes are numbered from 0 to n - 1.

You are given a string colors where colors[i] is a lowercase English letter representing the color of the ith node in this graph (0-indexed). You are also given a 2D array edges where edges[j] = [aj, bj] indicates that there is a directed edge from node aj to node bj.

A valid path in the graph is a sequence of nodes x1 -> x2 -> x3 -> ... -> xk such that there is a directed edge from xi to xi+1 for every 1 <= i < k. The color value of the path is the number of nodes that are colored the most frequently occurring color along that path.

Return the largest color value of any valid path in the given graph, or -1 if the graph contains a cycle.



Example 1:



Input: colors = "abaca", edges = [[0,1],[0,2],[2,3],[3,4]]
Output: 3
Explanation: The path 0 -> 2 -> 3 -> 4 contains 3 nodes that are colored "a" (red in the above image).
Example 2:



Input: colors = "a", edges = [[0,0]]
Output: -1
Explanation: There is a cycle from 0 to 0.


Constraints:

n == colors.length
m == edges.length
1 <= n <= 105
0 <= m <= 105
colors consists of lowercase English letters.
0 <= aj, bj < n
*
* */
public class Problem1857 {
    public static void main(String args[]) {
    }

    enum State { WHITE, GRAY, BLACK }

    // Adjacent list
    List<List<Integer>> adjList;
    // Used in DFS to mark visited nodes as appropriate states
    State[] states;
    // Reverse topological sorted vertices
    List<Integer> sorted;

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        adjList = createAdjList(n, edges);
        states = new State[n];
        Arrays.fill(states, State.WHITE);
        sorted = new ArrayList<>();

        // Cycle detection && (reverse) topological sort
        for (int i = 0; i < n; ++i) {
            if (states[i] == State.WHITE && !detectCycle(i)) {
                return -1;
            }
        }

        // Bottom-up DP, count maximum nodes of each color respectively on path starting from some node
        int[][] count = new int[n][26];
        int maxNodes = 0;
        for (int node : sorted) {
            for (int next : adjList.get(node)) {
                for (int i = 0; i < 26; ++i) {
                    count[node][i] = Math.max(count[node][i], count[next][i]);
                }
            }
            maxNodes = Math.max(maxNodes, ++count[node][colors.charAt(node) - 'a']);
        }
        return maxNodes;
    }

    private List<List<Integer>> createAdjList(int n, int[][] edges) {
        var res = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; ++i) {
            res.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            res.get(edge[0]).add(edge[1]);
        }
        return res;
    }

    private boolean detectCycle(int node) {
        states[node] = State.GRAY;
        for (int neighbor : adjList.get(node)) {
            if (states[neighbor] == State.GRAY
                    || (states[neighbor] == State.WHITE && !detectCycle(neighbor))) {
                return false;
            }
        }
        states[node] = State.BLACK;
        sorted.add(node);
        return true;
    }
}
