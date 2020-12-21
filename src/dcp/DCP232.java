package dcp;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * Good morning! Here's your coding interview problem for today.
 *
 * This problem was asked by Google.
 *
 * Implement a PrefixMapSum class with the following methods:
 *
 * insert(key: str, value: int): Set a given key's value in the map.
 * If the key already exists, overwrite the value
 * sum(prefix: str): Return the sum of all values of keys that begin with a given prefix.
 * */
public class DCP232 {
    public static void main(String args[]) {
        insert("columnar", 3);
        assert sum("col") == 3;

        insert("column", 2);
        assert sum("col") == 5;
    }

    //******** Solution 1 ***************
    static HashMap<String, Integer> hashMap = new HashMap<>();

    private static void insert(String key, int value) {
        hashMap.put(key, value);
    }

    private static int sum(String k) {
        Set<Map.Entry<String, Integer>> set = hashMap.entrySet();
        AtomicInteger sum = new AtomicInteger();
        set.forEach(val -> {
                    String key = val.getKey();
                    if (key.startsWith(k)) {
                        sum.set(sum.get() + val.getValue());
                    }
                }
        );

        return sum.get();
    }

    //************ XXXXXX **************

    // *************** Solution 2 *****************
    static HashMap<String, Integer> map = new HashMap();
    static TrieNode root = new TrieNode();
    public static void insertSol2(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        TrieNode cur = root;
        cur.score += delta;
        for (char c : key.toCharArray()) {
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
            cur.score += delta;
        }
    }

    public int sumSol2(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            cur = cur.children.get(c);
            if (cur == null) return 0;
        }
        return cur.score;
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap();
        int score;
    }
}
