package dcp;

import java.util.Arrays;

/*
* This problem was asked by PayPal.
*
* Given a string and a number of lines k,
* print the string in zigzag form.
* In zigzag, characters are printed out diagonally from top left to bottom right until reaching the kth line,
* then back up to top right, and so on.
*
* For example, given the sentence "thisisazigzag" and k = 4, you should print:

        t     a     g
         h   s z   a
          i i   i z
           s     g
*
* */
public class DCP253 {
    public static void main(String args[]) {
        String input = "thisisazigzag";
        int k = 4;

        boolean down = true;
        //  printCharInZigZag(input, k, 0, down);
          printZigZagConcat(input, k);

        // printW(input); This is experimental and not a the correct or actual solution
    }

    static String space = "";

    static void printCharInZigZag(String in, int k, int s, boolean down) {
        int col = in.length();
        int row = k - 1;

        for (int i = 0; i < col; i++) {
            if (i <= row) {
                char ch = in.charAt(i);
                System.out.println(ch);
                space += " ";
                System.out.print(space);
            } else {
                char ch = in.charAt(i);
                System.out.print(ch);
                space += " ";
                System.out.print(space);
            }
        }
//        if (down) {
//            row = k - 1;
//            while (row > 0 && s < col) {
//                char ch = in.charAt(s);
//                System.out.println(ch);
//                space += " ";
//                System.out.print(space);
//                row--;
//                s++;
//            }
//        } else {
//            row = 0;
//            while (row < k && s < col) {
//                char ch = in.charAt(s);
//                System.out.println(ch);
//                space += " ";
//                System.out.print(space);
//                row++;
//                s++;
//            }
//        }
        if (col == s) {
            return;
        }

        // printCharInZigZag(in, k, s, !down);
    }

    static void printW(String data) {
        int height = data.length();
        int i, j, counter = height / 2;
        for (i = 0; i < height; i++) {
            char ch = data.charAt(i);
            System.out.printf(ch + "");
            for (j = 0; j <= height; j++) {
                if (j == height)
                    System.out.printf(ch + "");
                else if ((i >= height / 2)
                        && (j == counter
                        || j == height - counter - 1))
                    System.out.printf(ch +"");
                else
                    System.out.printf(" ");
            }
            if (i >= height / 2) {
                counter++;
            }
            System.out.printf("\n");
        }
    }

    static void printZigZagConcat(String str,
                                  int n) {

        // Corner Case (Only one row)
        if (n == 1) {
            System.out.print(str);
            return;
        }
        char[] str1 = str.toCharArray();

        // Find length of string
        int len = str.length();

        // Create an array of
        // strings for all n rows
        String[] arr = new String[n];
        Arrays.fill(arr, "");

        // Initialize index for
        // array of strings arr[]
        int row = 0;
        boolean down = true; // True if we are moving
        // down in rows, else false

        // Travers through
        // given string
        for (int i = 0; i < len; ++i) {
            // append current character
            // to current row
            arr[row] += (str1[i]);

            // If last row is reached,
            // change direction to 'up'
            if (row == n - 1) {
                down = false;
            }

            // If 1st row is reached,
            // change direction to 'down'
            else if (row == 0) {
                down = true;
            }

            // If direction is down,
            // increment, else decrement
            if (down) {
                row++;
            } else {
                row--;
            }
        }

        // Print concatenation
        // of all rows
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i]);
        }
    }
}
