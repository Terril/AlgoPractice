package dcp;

import java.util.Iterator;
import java.util.Stack;

/*
 * This problem was asked by Quora.
 * Given an absolute pathname that may have . or .. as part of it,
 * return the shortest standardized path.
 *
 * For example, given "/usr/bin/../bin/./scripts/../", return "/usr/bin/".
 * */
public class DCP222 {
    public static void main(String args[]) {
        String in = "/usr/bin/../bin/./scripts/../";
        String in1 = "/a/./b/../../c/";
        String in2 = "/a//b//c//////d";
        String in3 = "/a/..";
        System.out.println(findTheShortestStandardizedPath(in3));
    }

    private static String findTheShortestStandardizedPath(String input) {

        Stack st = new Stack();
        String[] arr = input.split("/");

        for (String i : arr) {
            if (i.equals(".") || i.equals("") || i.equals(" ")) {
                continue;
            } else if (i.equals("..")) {
                if (!st.empty()) {
                    st.pop();
                }
            } else {
                st.push(i);
            }
        }

        String ans = "";
        Iterator value = st.iterator();
        while (value.hasNext()) {
            ans += "/" + value.next();
        }

        return (ans.length() > 0) ? ans : "/";
    }
}
