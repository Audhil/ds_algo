package _FrazWorkSheet._0dp._4mock;

import java.util.Arrays;

//  https://youtu.be/LC5IB2hMuc0?t=1979
public class _StonesGame {

  private static int score(int l, int r, int[] stones, int[][] dp) {
    if (l == r) {
      return 0;
    }
    if (dp[l][r] != -1) {
      return dp[l][r];
    }
    int totSum = 0, leftSum = 0;
    for (int i = l; i <= r; i++) {
      totSum += stones[i];
    }
    int ans = Integer.MIN_VALUE;
    for (int i = l; i < r; i++) {
      leftSum += stones[i];
      int rightSum = totSum - leftSum;
      if (leftSum < rightSum) {
        ans = Math.max(ans, leftSum + score(l, i, stones, dp));
      } else if (rightSum < leftSum) {
        ans = Math.max(ans, rightSum + score(i + 1, r, stones, dp));
      }
      //  if both are same
      else {
        ans = Math.max(ans,
            leftSum + Math.max(score(l, i, stones, dp), score(i + 1, r, stones, dp)));
      }
    }
    return dp[l][r] = ans;
  }

  //  this is not working, check it out, later
  private static void scoreWithBottomUpApproach(int left, int right, int[] stones) {
    int n = stones.length;
    int[][] dp = new int[n][n];
    //  base case
    for (int i = 0; i < n; i++) {
      dp[i][i] = 0;
    }
    for (int l = 2; l <= n; l++) {
      for (int i = 0; i < n; i++) {
        int j = i + 1 - 1;
        int ans = Integer.MIN_VALUE;
        int leftSum = 0, totSum = 0;
        for (int k = left; k <= right; k++) {
          totSum += stones[k];
        }
        for (int k = i; k < j; k++) {
          leftSum += stones[k];
          int rightSum = totSum - leftSum;
          if (leftSum < rightSum) {
            ans = Math.max(ans, leftSum + dp[i][k]);
          } else if (rightSum < leftSum) {
            ans = Math.max(ans, rightSum + dp[k + 1][j]);
          }
          //  if both are same
          else {
            ans = Math.max(ans,
                leftSum + Math.max(dp[i][k], dp[k + 1][j]));
          }
        }
        dp[i][j] = ans;
      }
    }
    for (int[] arr : dp) {
      System.out.println(Arrays.toString(arr));
    }
  }

  public static void main(String[] args) {
    int[] stones = {6, 2, 3, 4, 5, 5};
    int n = stones.length;
    int[][] dp = new int[n][n];
    for (int[] arr : dp) {
      Arrays.fill(arr, -1);
    }
//    for (int[] arr : dp) {
//      System.out.println(Arrays.toString(arr));
//    }
    System.out.println("yup: stone game: " + score(0, n - 1, stones, dp));
    System.out.println("yup: lets see bottomUp approach: ");
    scoreWithBottomUpApproach(0, n - 1, stones);
  }
}
