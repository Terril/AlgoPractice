/*
 * Given a string str consisting of letters only and an integer n,
 * the task is to replace every character of the given string by a character which is n times more than it.
 * If the letter exceeds ‘z’, then start checking from ‘a’ in a cyclic manner.
 *
 * Examples:
 * Input: str = “abc”, n = 2
 * Output: cde
 * */
public class DinDinnAssignment {
    public static void main(String args[]) {
        String data = "abc";
        int n = 30;
        System.out.println(shiftOutput(data, n));
    }

    private static String shiftOutput(String input, int n) {
        String out = "";
        int i = 0;
        while (i < input.length()) {
            int x = (int) (input.charAt(i));
            if (n > 26) {
                n = n % 26;
            }
            x = x + n;
            char c = (char) (x);
            out = out + c;
            i++;
        }

        return out;
    }
}
