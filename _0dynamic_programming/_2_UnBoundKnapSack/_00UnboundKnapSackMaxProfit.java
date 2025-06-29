package _0dynamic_programming._2_UnBoundKnapSack;

public class _00UnboundKnapSackMaxProfit {

  public static void main(String[] args) {
    int[] valArray = new int[]{1, 4, 5, 7};
    int[] wtArray = new int[]{1, 3, 4, 5};
    int maxWeight = 7; //  max weight a knapsack can hold

    //  unBoundKnapsackMaxProfit: maxProfit: 9
    System.out.println(
        "unBoundKnapsackMaxProfit: maxProfit: " + unBoundKnapsackMaxProfit(wtArray, valArray,
            maxWeight, wtArray.length));
  }

  private static int unBoundKnapsackMaxProfit(int[] wtArray,
      int[] valArray,
      int maxWeight,
      int n) {
    int[][] dp = new int[n + 1][maxWeight + 1];
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[i].length; j++) {
        //  base condition
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        } else if (wtArray[i - 1] <= j) {
          dp[i][j] = Math.max(
              valArray[i - 1] + dp[i][j - wtArray[i - 1]],  //  choosing the item - only difference: dp[i] instead of dp[i -1]
              dp[i - 1][j]  //  ignoring the item
          );
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    return dp[n][maxWeight];
  }
}
