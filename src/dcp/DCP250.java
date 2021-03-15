package dcp;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
* This problem was asked by Google.
*
* A cryptarithmetic puzzle is a mathematical game where the digits of some numbers are represented by letters.
*  Each letter represents a unique digit.

For example, a puzzle of the form:

  SEND
+ MORE
--------
 MONEY
may have the solution:

{'S': 9, 'E': 5, 'N': 6, 'D': 7, 'M': 1, 'O', 0, 'R': 8, 'Y': 2}
* Given a three-word puzzle like the one above, create an algorithm that finds a solution.
* */
public class DCP250 {
    public static void main(String args[]) {

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('S', 9);
        map.put('E', 5);
        map.put('N', 6);
        map.put('D', 7);
        map.put('M', 1);
        map.put('O', 0);
        map.put('R', 8);
        map.put('Y', 2);

        String out = getAddOFValue("SEND", "MORE", map);

        System.out.println(out);
    }

    static String getAddOFValue(String input1, String input2, HashMap<Character, Integer> map) {
        char ch1;
        char ch2;

        int x = input1.length() - 1;
        int y = input2.length() - 1;

        char[] chh = new char[x + 2];
        int carry = 0;
        while (x >= 0 || y >= 0) {
            ch1 = input1.charAt(x);
            ch2 = input2.charAt(y);

            int a = map.get(ch1);
            int b = map.get(ch2);
            int sum = a + b + carry;

            char output, lastout = 0;
            if (sum >= 10) {
                String sub = String.valueOf(sum);
                String s = Character.toString(sub.charAt(sub.length() - 1));
                if (x > 0) {
                    carry = Integer.parseInt(Character.toString(sub.charAt(0)));
                    output = getKeyByValue(map, Integer.parseInt(s));
                } else {
                    String ca = Character.toString(sub.charAt(0));
                    output = getKeyByValue(map, Integer.parseInt(ca));
                    lastout = getKeyByValue(map, Integer.parseInt(s));
                }
            } else {
                carry = 0;
                output = getKeyByValue(map, sum);
            }

            if (x > 0)
                chh[x + 1] = output;
            else {
                chh[x + 1] = lastout;
                chh[x] = output;
            }
            x--;
            y--;
        }

        String result = "";

        for (char c : chh) {
            result = result + c;
        }

        return result;
    }

    private static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    static class Value {
        char ch;
        int v;

        Value(char c, int val) {
            ch = c;
            v = val;
        }
    }
}
