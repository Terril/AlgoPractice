package leetcode;

import java.util.HashMap;

public class Problem5823 {
    public static void main(String args[]) {
        System.out.println(getLucky("iiii", 1));
    }

    public static int getLucky(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 97 ; i <= 122; i++) {
            map.put((char)i, i - 96);
        }

        StringBuilder builder = new StringBuilder();
        for(char c : s.toCharArray()) {
            int charVal = map.get(c);
            builder.append(charVal);
        }

        String formedString = builder.toString();
        for (int j = 0 ; j < k; j++) {
            int add = 0;
            for(int l = 0 ; l < formedString.length(); l++) {
                int val = Integer.parseInt(String.valueOf(formedString.charAt(l)));
                add += val;
            }

            formedString = add + "";
        }


        return Integer.parseInt(formedString);
    }
}
