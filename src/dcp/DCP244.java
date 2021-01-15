package dcp;

/*
* This problem was asked by Square.
*
* The Sieve of Eratosthenes is an algorithm used to generate all prime numbers smaller than N.
* The method is to take increasingly larger prime numbers, and mark their multiples as composite.
*
* For example, to find all primes less than 100, we would first mark [4, 6, 8, ...]
* (multiples of two), then [6, 9, 12, ...] (multiples of three),
* and so on. Once we have done this for all primes less than N, the unmarked numbers that remain will be prime.
*
* Implement this algorithm.

Bonus: Create a generator that produces primes indefinitely (that is, without taking N as an input).
*
* */
public class DCP244 {
    public static void main(String args[]) {
        int N = 50;
        sieveOfErathosthenes(N);
    }

    private static void sieveOfErathosthenes(int n) {
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i < n; i++)
            prime[i] = true;

        for (int p = 2; p * p <= n; p++) {
            // If prime[p] is not changed, then it is a prime
            if (prime[p] == true) {
                // Update all multiples of p
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }

        // Print all prime numbers
        for (int i = 2; i <= n; i++) {
            if (prime[i] == true)
                System.out.print(i + " ");
        }
    }
}
