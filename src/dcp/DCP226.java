package dcp;

import java.util.*;

/*
 * This problem was asked by Airbnb.
 *
 * You come across a dictionary of sorted words in a language you've never seen before.
 * Write a program that returns the correct order of letters in this language.
 *
 * For example, given ['xww', 'wxyz', 'wxyw', 'ywx', 'ywz'], you should return ['x', 'z', 'w', 'y'].
 * */
public class DCP226 {
    public static void main(String args[]) {
        int[] inDegree = new int[26];
        Map<Character, Set<Character>> graph = new HashMap<>();
        String[] arr = {"xww", "wxyz", "wxyw", "ywx", "ywz"};
        String[] arr1 = {"baa", "abcd", "abca", "cab", "cad"};
        String[] arr2 = {"caa", "aaa", "aab"};
        for (String s : arr) {
            for (char c : s.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
            }
        }
        findtheAlienMessage(arr, graph, inDegree);
        System.out.println(bfs(graph, inDegree));
    }

    private static void findtheAlienMessage(String[] arr, Map<Character, Set<Character>> graph, int[] inDegree) {
        for (int i = 1; i < arr.length; i++) {
            String data = arr[i - 1];
            String data1 = arr[i];

            int len = Math.min(data.length(), data1.length());
            for (int j = 0; j <= len; j++) {
                char out = data.charAt(j);
                char in = data1.charAt(j);
                if (out != in) {
                    // message = message + "," + data.charAt(j);
                    if (!graph.get(out).contains(in)) {
                        graph.get(out).add(in);
                        inDegree[in - 'a']++;
                    }
                    break;
                }

                if (j + 1 == len && data.length() > data1.length()) {
                    graph.clear();
                    return;
                }
            }
        }
    }

    private static String bfs(Map<Character, Set<Character>> graph, int[] inDegree) {
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        for (char keys : graph.keySet()) {
            if (inDegree[keys - 'a'] == 0) {
                q.offer(keys);
            }
        }
        while (!q.isEmpty()) {
            char ch = q.poll();
            sb.append(ch);
            for (char c : graph.get(ch)) {
                inDegree[c - 'a']--;
                if (inDegree[c - 'a'] == 0) {
                    q.offer(c);
                }
            }
        }

        return sb.length() == graph.size() ? sb.toString() : "";
    }
}
