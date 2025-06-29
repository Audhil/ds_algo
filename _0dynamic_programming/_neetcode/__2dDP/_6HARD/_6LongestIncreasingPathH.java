package _0dynamic_programming._neetcode.__2dDP._6HARD;

import java.util.Arrays;

//  https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
//  https://youtu.be/qMky6D6YtXU?t=6093
public class _6LongestIncreasingPathH {

  //  TC: O (m * n); SC: O (m * n)
  public static int longestIncreasingPath(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] dp = new int[m][n];
    //  since each cell's value is contributes path of len 1 - it is path
    for (int[] arr : dp) {
      Arrays.fill(arr, -1);
    }
    int maxSoFar = Integer.MIN_VALUE;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (dp[i][j] == -1) {
          dfs(i, j, -1, dp, matrix);
        }
        maxSoFar = Math.max(maxSoFar, dp[i][j]);
      }
    }
    return maxSoFar;
  }

  private static int dfs(int i, int j, int parent, int[][] dp, int[][] matrix) {
    if (matrix[i][j] <= parent) {
      return 0;
    }
    if (dp[i][j] != -1) {
      return dp[i][j];
    }
    parent = matrix[i][j];
    int up = 0, down = 0, left = 0, right = 0;
    if (i - 1 >= 0) {
      up = dfs(i - 1, j, parent, dp, matrix);
    }
    if (i + 1 < matrix.length) {
      down = dfs(i + 1, j, parent, dp, matrix);
    }
    if (j - 1 >= 0) {
      left = dfs(i, j - 1, parent, dp, matrix);
    }
    if (j + 1 < matrix[0].length) {
      right = dfs(i, j + 1, parent, dp, matrix);
    }
    return dp[i][j] =
        1 + Math.max(left, Math.max(up, Math.max(right,
            down)));  //  1(each cell is a path to itself) + max path either from 1 direction
  }

  public static void main(String[] args) {
    System.out.println("yup: longest increasing path: " + longestIncreasingPath(
        new int[][]{{3, 4, 5}, {3, 2, 6}, {2, 2, 1}})); //  4

    System.out.println("yup: longest increasing path: " + longestIncreasingPath(
        new int[][]{{1}})); //  1
  }
}
