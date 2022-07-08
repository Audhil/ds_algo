package basicToACE._1dp;

import java.util.Arrays;

public class _2NoOfWaysToClimbingStairsWithDp {

  //  refer _0Basic_Recursion_1.java
  //  1 or 2 steps allowed to jump
  private static int noOfWaysToClimbTop(int pos, int des, int[] dp) {
    if (pos == des) {
      return 1;
    }
    if (pos > des) {
      return 0;
    }
    if (dp[pos] != -1) {
      return dp[pos];
    }
    return dp[pos] = noOfWaysToClimbTop(pos + 1, des, dp) + noOfWaysToClimbTop(pos + 2, des, dp);
  }

  public static void main(String[] args) {
    int dest = 4;
    int[] dp = new int[dest + 1];
    Arrays.fill(dp, -1);
    System.out.println("yup: noOfWays to reach dest: " + noOfWaysToClimbTop(0, 4, dp)); //  yup: noOfWays to reach dest: 5
  }
}
