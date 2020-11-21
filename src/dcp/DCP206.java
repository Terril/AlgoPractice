package dcp;

public class DCP206 {
    public static void main(String args[]) {
        String[] input = {"a", "b", "c"};
        int[] swapPosition = {2, 1, 0};

        // completeSwap(swapPosition, input);

        swapSample2(swapPosition, input);
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");

        }

    }

    private static void completeSwap(int[] s, String[] in) {

        if (in.length != s.length) {
            return;
        }

        String[] tempV = new String[in.length];

        for (int i = 0; i < in.length; i++) {
            tempV[i] = in[s[i]];
        }

        for (String item : tempV) {
            System.out.println(item);
        }

    }

    private static void swapSample2(int[] s, String[] in) {
        int n = in.length;
        for (int i = 0; i < n; i++) {
            int next = i;

            // Check if it is already
            // considered in cycle
            while (s[next] > 0) {

                // Swap the current element according
                // to the permutation in P
                swap(in, i, s[i]);
                int temp = s[next];

                // Subtract n from an entry in P
                // to make it negative which indicates
                // the corresponding move
                // has been performed
                s[next] -= n;
                next = temp;
            }

        }
    }

    private static String[] swap(String[] in, int curr, int swap) {
        String temp = in[curr];
        in[curr] = in[swap];
        in[swap] = temp;
        return in;
    }
}
