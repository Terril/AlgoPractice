package dcp;

/*
 * This problem was asked by Flipkart.
 *
 * Snakes and Ladders is a game played on a 10 x 10 board,
 * the goal of which is get from square 1 to square 100.
 * On each turn players will roll a six-sided die and move forward a number of spaces equal to the result.
 * If they land on a square that represents a snake or ladder,
 * they will be transported ahead or behind, respectively, to a new square.
 *
 * Find the smallest number of turns it takes to play snakes and ladders.
 *
 * For convenience, here are the squares representing snakes and ladders, and their outcomes:
 * */
public class DCP229 {
    static int M = 10, N = 10;

    public static void main(String args[]) {
        int[][] snakes = {{16, 6}, {48, 26}, {49, 11}, {56, 53}, {62, 19},
                {64, 60}, {87, 24}, {93, 73}, {95, 75}, {98, 78}};
        int[][] ladders = {{1, 38}, {4, 14}, {9, 31}, {21, 42}, {28, 84},
                {36, 44}, {51, 67}, {71, 91}, {80, 100}};

        smallestTurnsToPlay(snakes, ladders);
    }

    private static void smallestTurnsToPlay(int[][] snakes, int[][] ladders) {

        for (int row = 0; row < M; row++) {
            for (int col = 0; col < N; col++) {

            }
        }
    }
}
