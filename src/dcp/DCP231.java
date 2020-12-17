package dcp;

import java.util.PriorityQueue;

/*
 * This problem was asked by IBM.
 *
 * Given a string with repeated characters,
 * rearrange the string so that no two adjacent characters are the same.
 * If this is not possible, return None.
 *
 * For example, given "aaabbc", you could return "ababac". Given "aaab", return None.
 * */
public class DCP231 {

    static int MAX_CHAR = 26;

    public static void main(String args[]) {
        String in = "aaabbc";
        String in1 = "aaab";
        String  in2 = "bbbaa";
        System.out.println(findOptimalString(in2));
    }

    private static String findOptimalString(String imn) {
        int[] count = new int[MAX_CHAR];
        for (int i = 0; i < imn.length(); i++) {
            count[imn.charAt(i) - 'a']++;
        }

        PriorityQueue queue = new PriorityQueue(new Comparator());

        for (char c = 'a'; c <= 'z'; c++) {
            int value = c - 'a';
            if (count[value] > 0) {
                queue.add(new Key(count[value], c));
            }
        }

        String str = "";
        Key prev = new Key(-1, '#');
        while (!queue.isEmpty()) {
            Key k = (Key) queue.poll();
            str = str + k.ch;

            if (prev.freq > 0) {
                queue.add(prev);
            }

            (k.freq)--;
            prev = k;
        }

        if (imn.length() != str.length())
            return " None ";
        else
            return str;
    }

    static class Key {
        int freq;
        char ch;

        Key(int freq, char ch) {
            this.ch = ch;
            this.freq = freq;
        }
    }

    static class Comparator implements java.util.Comparator<Key> {

        @Override
        public int compare(Key key, Key key2) {
            if (key.freq < key2.freq)
                return 1;
            else if (key.freq > key2.freq)
                return -1;
            return 0;
        }
    }
}
