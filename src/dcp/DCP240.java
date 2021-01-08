package dcp;

/*
 * This problem was asked by Spotify.
 *
 * There are N couples sitting in a row of length 2 * N.
 * They are currently ordered randomly,
 * but would like to rearrange themselves so that each couple's partners can sit side by side.
 *
 * What is the minimum number of swaps necessary for this to happen?
 * */
public class DCP240 {
    public static void main(String args[]) {
        int n = 3;
        Pair pairs[] = {new Pair(1, 3), new Pair(2, 6), new Pair(4, 5)}; // 1 is partner of 3 and so on
        int arr[] = {3, 5, 6, 4, 1, 2};

        int arr1[] = {0, 3, 5, 6, 4, 1};
        Pair pairs1[] = {new Pair(0, 3), new Pair(6, 1), new Pair(5, 4)}; // 1 is partner of 3 and so on  int pairs[] = {0, 3, 6, 1, 5, 4, 2};
        int cou = rearrarngeTOFormPair(n, arr1, pairs1, 0);

        System.out.println(cou);
    }

    static class Pair {
        int aa;
        int bb;

        Pair(int a, int b) {
            aa = a;
            bb = b;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    aa +
                    "-> " + bb +
                    '}';
        }
    }

    static int count = 0;

    static int rearrarngeTOFormPair(int n, int[] arr, Pair[] pairs, int f) {
        if (f == pairs.length) {
            return count;
        }
        //  Pair[] newPaired = new Pair[2 * n];
        for (int i = f; i < arr.length; i++) {
            if (i + 1 < arr.length) {
                int a = arr[i];
                int b = arr[i + 1];

                Pair ab = pairs[i / 2];
                if ((ab.aa == a && ab.bb == b) || (ab.aa == b && ab.bb == a)) {
                    //newPaired[i / n] = ab;
                    count++;
                } else {
                    arr[i] = b;
                    arr[i + 1] = a;
                    rearrarngeTOFormPair(n, arr, pairs, f + 1);
                }
            }

        }

        return count / 2;
    }
}
