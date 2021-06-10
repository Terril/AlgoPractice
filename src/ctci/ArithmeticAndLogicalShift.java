package ctci;

public class ArithmeticAndLogicalShift {
    public static void main(String args[]) {
        int n = -93242;
        int c = 40;
        System.out.println("Arithmetic : " + repeatArthemetic(n, c));
        System.out.println("Logical : " + repeatLogical(n, c));
    }

    static int repeatArthemetic(int n, int c) {
        for (int i = 0; i < c; i++) {
            n >>= 1;
        }

        return n;
    }

    static int repeatLogical(int n, int c) {
        for (int i = 0; i < c; i++) {
            n >>>= 1;
        }

        return n;
    }
}
