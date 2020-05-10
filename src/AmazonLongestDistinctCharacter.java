import java.util.*;

public class AmazonLongestDistinctCharacter {

    private static final int CHAR_RANGE = 128;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String value = sc.next();
        int disChar = sc.nextInt();

        String msg = longestSubstring(value, disChar);
        System.out.println(msg);
    }

    private static String longestSubstring(String str, int disChar) {
        int end = 0, begin = 0;

        // set to store distinct characters in a window
        Set<Character> window = new HashSet<>();

        // count array to store frequency of characters present in
        // current window
        // we can also use a map instead of count array
        int[] freq = new int[CHAR_RANGE];

        // [low..high] maintain sliding window boundaries
        for (int low = 0, high = 0; high < str.length(); high++) {
            window.add(str.charAt(high));
            freq[str.charAt(high)]++;

            // if window size is more than k, remove characters from the left
            while (window.size() > disChar) {
                // if the frequency of leftmost character becomes 0 after
                // removing it in the window, remove it from set as well
                if (--freq[str.charAt(low)] == 0) {
                    window.remove(str.charAt(low));
                }

                low++;        // reduce window size
            }

            // update maximum window size if necessary
            if (end - begin < high - low) {
                end = high;
                begin = low;
            }
        }

        // return longest substring found at str[begin..end]
        return str.substring(begin, end + 1);
    }
}
