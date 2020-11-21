package dcp;

public class DCP184 {
    public static void main(String args[]) {
        int arr[] = {42, 56, 14};
        System.out.println(findGCD(arr)); //Greatest common denominator
    }

    private static int findGCD(int arr[]) {
        int result = 0;
        for (int j : arr) {
            result = gcd(j, result);
            if (result == 1) {
                return 1;
            }
        }

        return result;
    }

    private static int gcd(int value, int result) {
        if (value == 0)
            return result;
        return gcd(result % value, value);
    }
}
