package algoexpert;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LevenshteinDistance {
    public static void main(String args[]) {
        String str1 = "algoexpert";
        String str2 = "algozexpert";
        System.out.println(levenshteinDistance(str1, str2));
    }

    public static int levenshteinDistance(String str1, String str2) {
        // Write your code here.
        Stack<Character> st = new Stack<Character>();
        List<Character> lst = new ArrayList<Character>();
        for (char c : str2.toCharArray()) {
            st.push(c);
        }

        int i = 0;

        while (i < st.size()) {
            char c = st.peek();
            boolean isPop = false;
            for (int j = 0; j < str1.length(); j++) {
                char ch = str1.charAt(j);

                if (ch == c) {
                    isPop = true;
                    str1 = str1.replaceFirst(ch + "", "");
                    break;
                }
            }

            if (!isPop) {
                lst.add(c);
            }
            st.pop();
        }
        return lst.size();
    }
}

