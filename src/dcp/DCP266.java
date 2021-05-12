package dcp;

import java.util.HashMap;

/*
* This problem was asked by Pivotal.
*
* A step word is formed by taking a given word, adding a letter,
* and anagramming the result. For example, starting with the word "APPLE",
* you can add an "A" and anagram to get "APPEAL".

Given a dictionary of words and an input word, create a function that returns all valid step words.
*
* */
public class DCP266 {
    public static void main(String args[]) {
        String[] word = {"APPEAL", "APPLICT"};
        String inWord = "APPLE";

        System.out.println(getStepWord(word, inWord));
    }

    private static String getStepWord(String[] w, String in) {

        char[] arr = in.toCharArray();
        int count = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (char ch : arr) {
            for (String word : w) {
                map.put(word, count);
                if (word.indexOf(ch) == -1) {
                    count = map.getOrDefault(word, 0);
                    count++;
                    map.put(word, count);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        String k = "";
        for (String key : map.keySet()) {
            int val = map.get(key);
            if (min > val) {
                min = val;
                k = key;
            }
        }

        return k;
    }
}
