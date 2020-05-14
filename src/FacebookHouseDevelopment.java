public class FacebookHouseDevelopment {

  public static void main(String args[]) {
    int nRows = 5;
    int kCOlor = 3;

    int[][] cost = new int[][] // COSTS[color][house]

        // HOUSE  1 2 3 4 5 6
        {
          {1, 2, 3, 4, 5, 1}, // Red
          {1, 3, 4, 5, 1, 2}, // Blue
          {1, 4, 5, 9, 1, 3}, // Green
          {2, 3, 5, 4, 1, 3} // Yellow
        };

   int minCost = findMinCost(cost);
   System.out.println(minCost);
  }

  private static int findMinCost(int[][] cost) {
    if (cost != null && cost.length == 0) return 0;

    int minCost = 0;
    int minSecondCost = 0;
    int preColor = -1;
    for (int i = 0; i < cost.length; i++) {
      int curMin = Integer.MAX_VALUE;
      int curSecndMin = Integer.MAX_VALUE;
      int curColor = -1;
      for (int j = 0; j < cost[0].length; j++) {
        cost[i][j] = cost[i][j] + (preColor == j ? minSecondCost : minCost);

        if (cost[i][j] < curMin) {
          curSecndMin = curMin;
          curMin = cost[i][j];
          curColor = j;
        } else if (cost[i][j] < curSecndMin) {
          curSecndMin = cost[i][j];
        }
      }
      minCost = curMin;
      minSecondCost = curSecndMin;
      preColor = curColor;
    }

    return minCost;
  }
}
