public class DCP193 {
    public static void main(String args[]) {

        int stockPrices[] = {1, 3, 2, 8, 4, 10};
        int fee = 2;

        int profit = calculateMaxProfit(stockPrices, 0, stockPrices.length - 1, fee);

        System.out.println(profit);
    }

    private static int calculateMaxProfit(int price[], int start
            , int end, int fee) {
        if (end <= start)
            return 0;

        // Initialise the profit
        int profit = 0;

        // The day at which the stock
        // must be bought
        for (int i = start; i < end; i++) {

            // The day at which the
            // stock must be sold
            for (int j = i + 1; j <= end; j++) {

                // If buying the stock at ith day and
                // selling it at jth day is profitable
                if (price[j] > price[i]) {

                    // Update the current profit
                    int curr_profit = price[j] - price[i]
                            + calculateMaxProfit(price, start, i - 1, fee)
                            + calculateMaxProfit(price, j + 1, end, fee);

                    // Update the maximum profit so far
                    profit = Math.max(profit, curr_profit - fee);
                }
            }
        }

        return profit;
    }
}
