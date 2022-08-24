package _10Blind75._11Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  https://leetcode.com/problems/pacific-atlantic-water-flow/
//  https://www.youtube.com/watch?v=krL3r7MY7Dc&ab_channel=AlgorithmsMadeEasy
//  https://github.com/Algorithms-Made-Easy/March-Leetcoding-Challenge/blob/main/25.%20Pacific%20Atlantic%20Water%20Flow
public class _6PacificAtlanticWaterFlowM {

  //  brute force approach - TC: O (m * n) + O (m + n) or O (m * n)^2
  private static int[][] heights;

  public static List<List<Integer>> pacificAtlanticBruteForce(int[][] heightsCC) {
    int m = heightsCC.length;
    int n = heightsCC[0].length;
    heights = heightsCC;
    List<List<Integer>> resList = new ArrayList<>();
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
    heights[r][c] = -1;  //  mark it as visited array
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
    heights[r][c] = -1;
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

  public static void main(String[] args) {
    int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5},
        {5, 1, 1, 2, 4}};
    System.out.println(
        "yup: cells that can meet both pacific & atlantic: " + pacificAtlanticBruteForce(heights));
  }
}
