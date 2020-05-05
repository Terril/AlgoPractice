/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class MorrisPattern {
    public static void main (String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        for (int i = 0; i < x ; i++) {
            int number = sc.nextInt();
            decodePattern(number);
        }
    }

    static void decodePattern(int n) {
        String a = "1", b = "1", z;
        int i, c;

        while (--n > 0) {
            for (c = 0, i = 0, b = "", z = a.substring(0, 1); i <a.length(); i++) {
                if (z.equals(a.substring(i, i + 1))) c++;
                else {
                    b += Integer.toString(c) + z;
                    z = a.substring(i, i + 1);
                    c = 1;
                }
            }

            b += Integer.toString(c) + z;
            a = b;
        }
        System.out.println(b);
    }
}