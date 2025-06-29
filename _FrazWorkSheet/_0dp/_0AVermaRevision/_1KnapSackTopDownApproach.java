package _FrazWorkSheet._0dp._0AVermaRevision;

public class _1KnapSackTopDownApproach {

  //  this code is based on 01Knapsack.java (recursive code)
  //  refer: https://www.youtube.com/watch?v=ntCGbPMeqgg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&ab_channel=AdityaVerma
  //  tabular way
  private static int maxProfit(int[] wtArray, int[] valArray, int W) {
    int N = wtArray.length; //  wtArray.length = valArray.length
    int[][] dp = new int[N + 1][W + 1];
    //  base condition - need to fill 0's in 1st row & col
    for (int i = 0; i <= N; i++) {
      for (int j = 0; j <= W; j++) {
        dp[i][j] = 0;
      }
    }
    //  fill tabular
    for (int n = 1; n <= N; n++) {
      for (int w = 1; w <= W; w++) {
        if (wtArray[n - 1] <= w) {
          dp[n][w] = Math.max(valArray[n - 1] + dp[n - 1][w - wtArray[n - 1]], dp[n - 1][w]);
        } else {
          dp[n][w] = dp[n - 1][w];
        }
      }
    }
    return dp[wtArray.length][W];
  }

  public static void main(String[] args) {
    int[] wtArray = {1, 2, 3, 4};
    int[] valArray = {4, 3, 2, 1};
    int W = 9;  //  max weight can be hold by knapsack
    System.out.println(
        "yup: maxProfit with tabular/top-down approach: " + maxProfit(wtArray, valArray, W)); //  yup: maxProfit with tabular/top-down approach: 9

  }
}
