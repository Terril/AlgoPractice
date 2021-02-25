package dcp;

import java.util.HashMap;

/*
 *
 * This problem was asked by Dropbox.
 *
 * Given a list of words, determine whether the words can be chained to form a circle.
 * A word X can be placed in front of another word Y in a circle if the last character of X is same as the first character of Y.
 *
 * For example, the words ['chair', 'height', 'racket', touch', 'tunic']
 * can form the following circle: chair --> racket --> touch --> height --> tunic --> chair.
 * */
public class DCP246 {
    public static void main(String args[]) {
        String[] arr = {"chair", "height", "racket", "touch", "tunic"};
        solution2(arr);
    }

    static void findChainForm(String[] arr) {

        HashMap<Character, String> item = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            String init = arr[i];
            char first = init.charAt(0);
            char last = init.charAt(init.length() - 1);

            System.out.println(init);
            //  item.put(first, init);
            for (int j = 0; j < arr.length; j++) {
                char ffzirst = arr[j].charAt(0);
                char llast = arr[j].charAt(arr[j].length() - 1);
                //item.put(ffzirst, arr[i]);
                if (last == llast) {
                    last = llast;
                    System.out.println(" ---> " + arr[j]);
//                    item.remove(ffzirst);
                    break;
                }
            }
        }
    }

    static void solution2(String[] arr) {
        int k = arr.length;
        char first = arr[0].charAt(0);
        char last = arr[0].charAt(arr[0].length() - 1);
        System.out.print(arr[0]);
        String [] arr1 = new String[k];
        while (k >= 0) {
            for (int i = 0; i < arr.length; i++) {
                char ffirst;
                char llast;
                ffirst = arr[i].charAt(0);
                llast = arr[i].charAt(arr[i].length() - 1);

                if (last == ffirst && !(arr[i].equals(arr1[i]))) {
                    System.out.print(" ---> " + arr[i]);
                    arr1[i] = arr[i];
                    last = llast;
                    break;
                }
            }
            k--;
        }
    }
}
