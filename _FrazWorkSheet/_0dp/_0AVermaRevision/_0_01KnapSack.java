package _FrazWorkSheet._0dp._0AVermaRevision;

import java.util.Arrays;

public class _0_01KnapSack {

  private static int maxProfit(int[] wtArray, int[] valueArray, int W, int n) {
    if (W == 0 || n == 0) {
      return 0;
    }
    //  can/not choose my wish
    if (wtArray[n - 1] <= W) {
      return
          Math.max(
              //  I can choose weight
              valueArray[n - 1] + maxProfit(wtArray, valueArray, W - wtArray[n - 1], n - 1),
              //  or not choose the weight
              maxProfit(wtArray, valueArray, W, n - 1)
          );
    }
    //  I cannot choose, since, wtArray[n - 1] > W
    else {
      return maxProfit(wtArray, valueArray, W, n - 1);
    }
  }

  private static int maxProfitWithMemoization(int[] wtArray, int[] valueArray, int W, int n,
      int[][] dp) {
    if (W == 0 || n == 0) {
      return 0;
    }
    if (dp[n][W] != -1) {
      return dp[n][W];
    }
    //  can/not choose my wish
    if (wtArray[n - 1] <= W) {
      return
          dp[n][W] = Math.max(
              //  I can choose weight
              valueArray[n - 1] +
                  maxProfitWithMemoization(wtArray, valueArray, W - wtArray[n - 1], n - 1, dp),
              //  or not choose the weight
              maxProfitWithMemoization(wtArray, valueArray, W, n - 1, dp)
          );
    }
    //  I cannot choose, since, wtArray[n - 1] > W
    else {
      return dp[n][W] = maxProfitWithMemoization(wtArray, valueArray, W, n - 1, dp);
    }
  }

  public static void main(String[] args) {
    int[] wtArray = {1, 2, 3, 4};
    int[] valArray = {4, 3, 2, 1};
    int W = 9;  //  max weight can be hold by knapsack
    int n = wtArray.length;
    System.out.println("yup: maxProfit after choosing wts: " + maxProfit(wtArray, valArray, W,
        n)); //  yup: maxProfit after choosing wts: 9(1 + 2 + 3 -> 4 + 3 + 2)
    System.out.println("yup: with memoization");
    int[][] dp = new int[100][100];
    for (int[] items : dp) {
      Arrays.fill(items, -1);
    }
    System.out.println(
        "yup: maxProfit after choosing wts: " + maxProfitWithMemoization(wtArray, valArray, W,
            n, dp)); //  yup: maxProfit after choosing wts: 9
  }
}
