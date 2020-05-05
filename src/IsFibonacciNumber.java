/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class IsFibonacciNumber {
    public static void main(String[] args) throws IOException {
        //code
//        Scanner sc = new Scanner(System.in);
//        int x = sc.nextInt();
//
//        for (int i = 0; i < x; i++) {
//            int y = sc.nextInt();
//            String[] spacedArray = sc.next().split("\\s");
//            int[] numArr = new int[y];
//            for (int j = 0; j < numArr.length; j++) {
//                numArr[j] = Integer.parseInt(spacedArray[j]);
//            }
//            returnValue(numArr);
//        }

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(bf.readLine());

        while(tc-- > 0){
            int size = Integer.parseInt(bf.readLine().replaceAll("\\s",""));
            String str1 [] = bf.readLine().split(" ");
            // Main Code
            for (int i = 0; i < size; i++){
                int no = Integer.parseInt(str1[i]);
                returnValue(no);
            }
        }
      //  bf.close();
    }

    static boolean isPerfectSquare(int x) {
        int s = (int) Math.sqrt(x);
        return (s * s == x);
    }

    // Returns true if n is a Fibonacci Number, else false
    static boolean isFibonacci(int n) {
        // n is Fibonacci if one of 5*n*n + 4 or 5*n*n - 4 or both
        // is a perfect square
        return isPerfectSquare(5 * n * n + 4) ||
                isPerfectSquare(5 * n * n - 4);
    }

    static void returnValue(int number) {
        boolean stat = isFibonacci(number);
        if (stat) {
            System.out.print(number+" ");
        }
    }
}