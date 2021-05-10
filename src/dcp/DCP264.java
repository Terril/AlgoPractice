package dcp;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

/*
* This problem was asked by LinkedIn.

Given a set of characters C and an integer k,
* a De Bruijn sequence is a cyclic sequence in which every possible k-length string of characters in C occurs exactly once.

For example, suppose C = {0, 1} and k = 3.
* Then our sequence should contain the substrings {'000', '001', '010', '011', '100', '101', '110', '111'},
* and one possible solution would be 00010111.

Create an algorithm that finds a De Bruijn sequence.
* */
public class DCP264 {
    static Set<String> seen = new HashSet<String>();
    static Vector<Integer> edges = new Vector<Integer>();

    public static void main(String args[]) {
        int n = 3, k = 2;
        String A = "01";
        System.out.print(deBruijn(n, k, A));
    }


    // Modified DFS in which no edge
    // is traversed twice
    static void dfs(String node, int k, String A) {
        for (int i = 0; i < k; ++i) {
            String str = node + A.charAt(i);
            if (!seen.contains(str)) {
                seen.add(str);
                dfs(str.substring(1), k, A);
                edges.add(i);
            }
        }
    }

    // Function to find a de Bruijn sequence
    // of order n on k characters
    static String deBruijn(int n, int k, String A) {

        // Clearing global variables
        seen.clear();
        edges.clear();

        String startingNode = string(n - 1, A.charAt(0));
        dfs(startingNode, k, A);

        String S = "";

        // Number of edges
        int l = (int) Math.pow(k, n);
        for (int i = 0; i < l; i++)
            S += A.charAt(edges.get(i));
        //S += startingNode;

        return S;
    }

    private static String string(int n, char charAt) {
        String str = "";
        for (int i = 0; i < n; i++)
            str += charAt;
        return str;
    }
}
