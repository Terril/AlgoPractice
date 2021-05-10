package dcp;

import java.util.HashSet;
import java.util.Set;

/*
* This problem was asked by Two Sigma.
*
* Ghost is a two-person word game where players alternate appending letters to a word.
* The first person who spells out a word, or creates a prefix for which there is no possible continuation, loses.
* Here is a sample game:

Player 1: g
Player 2: h
Player 1: o
Player 2: s
Player 1: t [loses]
*
*
* Given a dictionary of words, determine the letters the first player should start with,
* such that with optimal play they cannot lose.

* For example, if the dictionary is ["cat", "calf", "dog", "bear"],
* the only winning start letter would be b.
* */
public class DCP259 {
    public static void main(String args[]) {
        String[] words = {"cat", "calf", "dog", "bear"};
        String[] words1 = {"cat", "calf", "dog", "bear", "ao"};

        char[] m = chooseAlphabetToWinWordGame(words1);
        for (char l : m) {
            System.out.println(l);
        }

    }

    private static char[] chooseAlphabetToWinWordGame(String[] words) {
        char c = 0;
        Set<Character> arr = new HashSet<>();
        char[] carr = new char[words.length];

        int k = 0;
        for (String i : words) {
            int len = i.length();
            int m = len % 2;
            char temp = i.charAt(0);
            if (m == 0) {
                c = i.charAt(0);
                if (!arr.contains(temp)) {
                    carr[k++] = c;
                }
            }
            arr.add(temp);
        }
        return carr;
    }
}
