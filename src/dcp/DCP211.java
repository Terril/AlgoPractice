package dcp;
/*
* This problem was asked by Microsoft.

* Given a string and a pattern,
* find the starting indices of all occurrences of the pattern in the string.
* For example, given the string "abracadabra" and the pattern "abr", you should return [0, 7].
* */
public class DCP211 {
    public static void main(String args[]) {

        String text = "abracadabra";
        String pattern = "abr";
        findStartingIndicesOccurrencesOfString(text, pattern);
    }

    private static void findStartingIndicesOccurrencesOfString(String text, String pattern) {

        boolean flag = false;
        for (int i = 0; i < text.length() - pattern.length(); i++) {
            if (text.substring(i, i + pattern.length()).equals(pattern)) {
                System.out.print(i + " ");
                flag = true;
            }
            if (flag == false) {
                System.out.println("NONE");
            }
        }

    }
}
