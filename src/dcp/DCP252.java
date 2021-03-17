package dcp;


/*
 * This problem was asked by Palantir.
 *
 * The ancient Egyptians used to express fractions as a sum of several terms where each numerator is one.
 * For example, 4 / 13 can be represented as 1 / 4 + 1 / 18 + 1 / 468.
 *
 * Create an algorithm to turn an ordinary fraction a / b,
 * where a < b, into an Egyptian fraction.
 * */

public class DCP252 {
    public static void main(String args[]) {
        convertToEgyptianFractian(4, 13);
    }

    static void convertToEgyptianFractian(int nr, int dr) {

        if (nr == 0 || dr == 0) {
            return;
        }

        if (dr % nr == 0) {
            System.out.println("1/" + dr / nr);
            return;
        }

        if (nr % dr == 0) {
            System.out.print(nr / dr);
            return;
        }

        int n = dr / nr + 1;
        System.out.print("1/" + n + " + ");

        convertToEgyptianFractian(nr * n - dr, dr * n);
    }
}
