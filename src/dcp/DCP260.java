package dcp;

/*
 * This problem was asked by Pinterest.
 *
 * The sequence [0, 1, ..., N] has been jumbled,
 * and the only clue you have for its order is an array representing whether each number is larger or smaller than the last.
 * Given this information, reconstruct an array that is consistent with it.
 *
 * For example, given [None, +, +, -, +], you could return [1, 2, 3, 0, 4].
 * */
public class DCP260 {
    public static void main(String args[]) {

        String[] message = {"None", "+", "+", "-", "-", "+"};
        int[] m = constructArrayBasedOnInformation(message);
        for (int x : m) {
            System.out.println(x);
        }
    }

    private static int[] constructArrayBasedOnInformation(String[] a) {
        int[] arr = new int[a.length];
        int pos = 0;
        int temp = 0;
        int negTemp = 0;

        for (int k = 0; k < a.length; k++) {
            String m = a[k];
            if (m.equals("None")) {
                pos = 1;
                temp = pos;
            } else if (m.equals("+")) {
                temp += 1;
                pos = temp;
            } else if (m.equals("-")) {
                pos = negTemp;
                negTemp -=1;
            }
            arr[k] = pos;
        }
        return arr;
    }
}
