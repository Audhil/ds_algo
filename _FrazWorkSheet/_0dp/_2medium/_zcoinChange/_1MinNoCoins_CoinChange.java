package _FrazWorkSheet._0dp._2medium._zcoinChange;

//  https://youtu.be/I-l6PBeERuc?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go
public class _1MinNoCoins_CoinChange {

  private static int minNoCoinsNeeded(int[] coins, int sum) {
    int n = coins.length;
    int[][] dp = new int[n + 1][sum + 1];

//    print2DArray(1, dp);

    //  1. initialization - check https://youtu.be/I-l6PBeERuc?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&t=903
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[i].length; j++) {
        if (i == 0 && j == 0) {
          dp[i][j] = Integer.MAX_VALUE - 1;
        } else if (i == 0) {
          dp[i][j] = Integer.MAX_VALUE - 1;
        } else if (j == 0) {
          dp[i][j] = 0;
        }
      }
    }

//    print2DArray(2, dp);

    //  2. initializing second row
    if (coins.length > 1) {   //  safer check - if there's only one coin available?
      for (int j = 1; j < sum + 1; j++) {
        //  if sum is fully divisible by coin, put 1
        if (j % coins[0] == 0) {
          dp[1][j] = j / coins[0];
        }
        //  if sum is not fully divisible by coin, put infinite
        else {
          dp[1][j] = Integer.MAX_VALUE - 1;
        }
      }
    }

//    print2DArray(3, dp);

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[i].length; j++) {
        //  choice diagram
        if (coins[i - 1] <= j) {
          dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
//    print2DArray(4, dp);
    return dp[n][sum] == Integer.MAX_VALUE - 1 ? -1 : dp[n][sum];
  }

  private static void print2DArray(int pos, int[][] array) {
    System.out.println("yup: pos: " + pos + ", printing 2D array: ");
    for (int[] ints : array) {
      for (int anInt : ints) {
        System.out.print(anInt + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    System.out.println("yup: 1st min no coins : " + minNoCoinsNeeded(new int[]{1, 2, 5}, 11));
    System.out.println("yup: 2nd min no coins : " + minNoCoinsNeeded(new int[]{2}, 3));
    System.out.println("yup: 3rd min no coins : " + minNoCoinsNeeded(new int[]{1}, 0));
  }
}
