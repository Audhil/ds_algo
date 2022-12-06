package _FrazWorkSheet._0dp._2medium;

//  https://leetcode.com/problems/maximal-square/
//  https://www.youtube.com/watch?v=c4W7YmgASpQ&ab_channel=KeertiPurswani
public class _4MaximalSquareMatrixM {

  public static int maximalSquare(char[][] matrix) {
    int r = matrix.length;
    int c = matrix[0].length;
    int[][] dp = new int[r][c];
    int maxSquare = Integer.MIN_VALUE;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        //  value at 0th row, and 0th col are the answer to themselves
        if (i == 0 || j == 0) {
          dp[i][j] = matrix[i][j] - '0';
        } else {
          if (matrix[i][j] != '0') {
            dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1]));
          } else {
            dp[i][j] = 0;
          }
        }
        maxSquare = Math.max(maxSquare, dp[i][j]);
      }
    }
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[i].length; j++) {
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }
    return maxSquare * maxSquare;
  }

  public static void main(String[] args) {
    char[][] chars = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'},
        {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
    System.out.println("yup: maximal square: " + maximalSquare(chars)); //  yup: maximal square: 4
  }
}
