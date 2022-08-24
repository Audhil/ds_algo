package _10Blind75._11Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  https://leetcode.com/problems/pacific-atlantic-water-flow/
//  https://www.youtube.com/watch?v=krL3r7MY7Dc&ab_channel=AlgorithmsMadeEasy
//  https://github.com/Algorithms-Made-Easy/March-Leetcoding-Challenge/blob/main/25.%20Pacific%20Atlantic%20Water%20Flow
public class _6PacificAtlanticWaterFlowM {

  //  brute force approach - TC: O (m * n) * O (m + n){max no of steps to be taken at each cell to reach both atlantic and pacific} - https://youtu.be/krL3r7MY7Dc?t=397
  private static int[][] heights;

  public static List<List<Integer>> pacificAtlanticBruteForce(int[][] heightsCC) {
    int m = heightsCC.length;
    int n = heightsCC[0].length;
    heights = heightsCC;
    List<List<Integer>> resList = new ArrayList<>();
    //  O (m * n)
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (reachPacific(i, j) && reachAtlantic(i, j)) {
          resList.add(Arrays.asList(i, j));
        }
      }
    }
    return resList;
  }

  private static boolean reachAtlantic(int r, int c) {
    if (r == heights.length - 1 || c == heights[0].length - 1) {
      return true;
    }
    //  is the cell already visited
    if (heights[r][c] == -1) {
      return false;
    }
    int val = heights[r][c];
    heights[r][c] = -1;  //  mark it as visited
    boolean flag = false;
    //  b
    if (heights[r + 1][c]
        <= val) { //  no need of r+1 boundary check, we've already base condition at line 28
      flag = reachAtlantic(r + 1, c);
    }
    //  r
    if (!flag
        && heights[r][c + 1]
        <= val) {  //  no need of j+1 boundary check, we've already base condition at line 28
      flag = reachAtlantic(r, c + 1);
    }
    //  t
    if (!flag && (r - 1) >= 0 && heights[r - 1][c] <= val) {
      flag = reachAtlantic(r - 1, c);
    }
    //  l
    if (!flag && (c - 1) >= 0 && heights[r][c - 1] <= val) {
      flag = reachAtlantic(r, c - 1);
    }
    heights[r][c] = val;  //  back tracking
    return flag;
  }

  private static boolean reachPacific(int r, int c) {
    if (r == 0 || c == 0) {
      return true;
    }
    if (heights[r][c] == -1) {
      return false;
    }
    int val = heights[r][c];
    heights[r][c] = -1; //  mark it as visited
    boolean flag = false;
    //  l
    if (heights[r - 1][c] <= val) {
      flag = reachPacific(r - 1, c);
    }
    //  t
    if (!flag && heights[r][c - 1] <= val) {
      flag = reachPacific(r, c - 1);
    }
    //  r
    if (!flag && (r + 1) < heights.length && heights[r + 1][c] <= val) {
      flag = reachPacific(r + 1, c);
    }
    //  b
    if (!flag && (c + 1) < heights[0].length && heights[r][c + 1] <= val) {
      flag = reachPacific(r, c + 1);
    }
    heights[r][c] = val;
    return flag;
  }

  //  Optimized - TC: O (m * n), SC: O (m * n)
  public static List<List<Integer>> pacificAtlanticOptimized(int[][] heights) {
    List<List<Integer>> resList = new ArrayList<>();
    if (heights == null || heights.length == 0 || heights[0].length == 0) {
      return resList;
    }

    int rows = heights.length;
    int cols = heights[0].length;

    boolean[][] pacific = new boolean[rows][cols];
    boolean[][] atlantic = new boolean[rows][cols];

    for (int i = 0; i < rows; i++) {
      dfs(heights, i, 0, Integer.MIN_VALUE, pacific);
      dfs(heights, i, cols - 1, Integer.MIN_VALUE, atlantic);
    }

    for (int i = 0; i < cols; i++) {
      dfs(heights, 0, i, Integer.MIN_VALUE, pacific);
      dfs(heights, rows - 1, i, Integer.MIN_VALUE, atlantic);
    }

    //  copy to result
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (pacific[i][j] && atlantic[i][j]) {
          resList.add(Arrays.asList(i, j));
        }
      }
    }
    return resList;
  }

  private static final int[] dirX = {-1, 0, 1, 0};
  private static final int[] dirY = {0, 1, 0, -1};

  private static void dfs(int[][] matrix, int r, int c, int prev, boolean[][] ocean) {
    if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length) {
      return;
    }
    //  matrix[r][c] < prev - we are checking from ocean to land direction - https://youtu.be/krL3r7MY7Dc?t=630
    if (ocean[r][c] || matrix[r][c] < prev) {
      return;
    }
    ocean[r][c] = true;
    for (int i = 0; i < 4; i++) {
      dfs(matrix, r + dirX[i], c + dirY[i], matrix[r][c], ocean);
    }
  }

  public static void main(String[] args) {
    int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5},
        {5, 1, 1, 2, 4}};
    System.out.println(
        "yup: pacificAtlanticBruteForce cells that can meet both pacific & atlantic: "
            + pacificAtlanticBruteForce(
            heights));  //  yup: pacificAtlanticBruteForce cells that can meet both pacific & atlantic: [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]
    System.out.println(
        "yup: pacificAtlanticOptimized cells that can meet both pacific & atlantic: "
            + pacificAtlanticOptimized(
            heights)); //  yup: pacificAtlanticOptimized cells that can meet both pacific & atlantic: [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]
  }
}
