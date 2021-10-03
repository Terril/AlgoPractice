package leetcode;

/*

Stone Game IX


* Alice and Bob continue their games with stones. There is a row of n stones, and each stone has an associated value.
* You are given an integer array stones, where stones[i] is the value of the ith stone.
* Alice and Bob take turns, with Alice starting first.
* On each turn, the player may remove any stone from stones.
* The player who removes a stone loses if the sum of the values of all removed stones is divisible by 3.
* Bob will win automatically if there are no remaining stones (even if it is Alice's turn).
*
* Assuming both players play optimally, return true if Alice wins and false if Bob wins.
* */
public class Problem2029 {
    public static void main(String args[]) {
       int[] stones = {5,1,2,4,3};
        System.out.println(stoneGameIX(stones));
    }

    public static boolean stoneGameIX(int[] stones) {

        int[] s = new int[3];
        for(int stone : stones) {
            s[stone % 3]++;
        }
        if (s[1] == 0 || s[2] == 0 || (s[0] % 2 == 1 && Math.abs(s[1] - s[2]) < 3)) return false;

        return true;
    }
}
