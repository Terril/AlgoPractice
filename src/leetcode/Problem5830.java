package leetcode;

public class Problem5830 {
    public static void main(String args[]) {
        System.out.println( isThree(4));
    }
    public static boolean isThree(int n) {

        return  findDivisor(n , n, 0);
    }

    private static boolean findDivisor(int n , int m, int count) {
        if(m == 0 && count == 3) {
            return true;
        }

        if(m == 0) {
            return false;
        }

        int div = n % m;
        if(div == 0) {
            count+=1;
        }
        return  findDivisor(n, m - 1, count);
    }
}
