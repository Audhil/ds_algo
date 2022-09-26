package _0dynamic_programming._neetcode.__2dDP;

//  https://leetcode.com/problems/unique-paths/
//  https://youtu.be/qMky6D6YtXU?t=76
public class _0UniquePathsM {

  //  TC: O (m * n)
  //  SC: O (m * n)
  public static int uniquePaths(int m, int n) {
    int[][] dp = new int[m + 1][n + 1];
    //  no of paths to reach destination from destination grid - this step is not needed - it is shown for understanding purpose
    dp[m][n] = 1;
    //  fill last row
    for (int c = 0; c < n; c++) {
      dp[m - 1][c] = 1;
    }
    //  fill last col
    for (int r = 0; r < m; r++) {
      dp[r][n - 1] = 1;
    }
    //  fill other places, leaving last row, and last col
    for (int r = m - 2; r >= 0; r--) {
      for (int c = n - 2; c >= 0; c--) {
        dp[r][c] = dp[r + 1][c] + dp[r][c + 1];
      }
    }
    return dp[0][0];  //  start position
  }

  public static void main(String[] args) {
    System.out.println("yup: unique paths: " + uniquePaths(3, 7));  //  yup: unique paths: 28
    System.out.println("yup: unique paths: " + uniquePaths(3, 2));  //  yup: unique paths: 3
  }
}
