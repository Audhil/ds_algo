package _0dynamic_programming._neetcode.__2dDP._6HARD;

import java.util.Arrays;

//  https://leetcode.com/problems/number-of-increasing-paths-in-a-grid/submissions/
public class _6CountIncreasingPathsInGridH {

  private static final long mod = 1000000007;

  public static int countPaths(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    long[][] dp = new long[m][n];
    //  since each cell's value is contributes path of len 1 - it is path
    for (long[] arr : dp) {
      Arrays.fill(arr, -1);
    }
    long pathCount = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (dp[i][j] == -1) {
          dfs(i, j, -1, dp, grid);
        }
        if (dp[i][j] > 0) {
          pathCount = (pathCount + dp[i][j]) % mod;
        }
      }
    }
    return (int) pathCount;
  }

  private static long dfs(int i, int j, long parent, long[][] dp, int[][] grid) {
    if (grid[i][j] <= parent) {
      return 0;
    }
    if (dp[i][j] != -1) {
      return dp[i][j];
    }
    parent = grid[i][j];
    long up = 0, down = 0, left = 0, right = 0;
    if (i - 1 >= 0) {
      up = dfs(i - 1, j, parent, dp, grid);
    }
    if (i + 1 < grid.length) {
      down = dfs(i + 1, j, parent, dp, grid);
    }
    if (j - 1 >= 0) {
      left = dfs(i, j - 1, parent, dp, grid);
    }
    if (j + 1 < grid[0].length) {
      right = dfs(i, j + 1, parent, dp, grid);
    }
    return dp[i][j] =
        //  1(each cell is a path to itself) + max path either from 1 direction
        (1 + left + right + up + down) % mod;
  }

  public static void main(String[] args) {
    System.out.println("yup: num of path: " + countPaths(new int[][]{{1, 1}, {3, 4}})); //  8
    System.out.println("yup: num of path: " + countPaths(new int[][]{{1}, {2}})); //  3
  }
}
