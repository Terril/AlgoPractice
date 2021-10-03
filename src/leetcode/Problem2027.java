package leetcode;

/*

Minimum Moves to Convert String

*
* You are given a string s consisting of n characters which are either 'X' or 'O'.
*
* A move is defined as selecting three consecutive characters of s and converting them to 'O'.
*  Note that if a move is applied to the character 'O', it will stay the same.
*
* Return the minimum number of moves required so that all the characters of s are converted to 'O'.
* */
public class Problem2027 {
    public static void main(String args[]) {
        String s = "XXOX";
        System.out.println(minimumMoves(s));
    }

    public static int minimumMoves(String s) {
        int moves = 0;
        if(s.length() <= 0) {
            return moves;
        }
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == 'X') {
                moves++;
                i += 2;
            }
        return moves;
    }
}
