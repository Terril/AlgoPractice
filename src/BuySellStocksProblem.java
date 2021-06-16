public class BuySellStocksProblem {
    public static void main(String args[]) {
        int[] days = {7, 1, 5, 3, 6, 4};
        System.out.println(buySell(days));
    }

    private static int buySell(int[] stockOnDay) {

        if (stockOnDay.length <= 0) {
            return 0;
        }

        int max = 0;
        int min = stockOnDay[0];

        for (int i = 1; i < stockOnDay.length; i++) {

            if(stockOnDay[i] > min) {
                max = Math.max(max, stockOnDay[i] - min);
            } else {
                min = stockOnDay[i];
            }
        }

        return max;
    }

}
