package _00Arrays._2DArray_Matrix;

//  https://leetcode.com/problems/search-a-2d-matrix/description/
public class _0Search2DMatrixM {

  //  TC: O (m + n)
  public static boolean searchMatrix(int[][] matrix, int target) {
    int pos = -1, m = matrix.length, n = matrix[0].length;
    for (int i = 0; i < m; i++) {
      if (target >= matrix[i][0] && target <= matrix[i][n - 1]) {
        pos = i;
        break;
      }
    }
    if (pos < 0) {
      return false;
    }
    for (int i = 0; i < n; i++) {
      if (target == matrix[pos][i]) {
        return true;
      }
    }
    return false;
  }

  //  TC: O (log m + log n) - with binary search
  public static boolean searchMatrixEfficient(int[][] matrix, int target) {
    int m = matrix.length, n = matrix[0].length;
    int top = 0, bot = m - 1;
    int row = 0;
    //  binary search in col
    while (top <= bot) {
      row = (top + bot) / 2;
      if (target > matrix[row][n - 1]) {
        top = row + 1;
      } else if (target < matrix[row][0]) {
        bot = row - 1;
      } else {
        break;
      }
    }
    //  if we didn't find the value in col, return false immediately
    if (top > bot) {
      return false;
    }
    //  binary search in row
    int l = 0, r = n - 1;
    while (l <= r) {
      int mid = (l + r) / 2;
      if (target > matrix[row][mid]) {
        l = mid + 1;
      } else if (target < matrix[row][mid]) {
        r = mid - 1;
      }
      //  we found the value
      else {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println("yup: searching matrix: " + searchMatrix(
        new int[][]{
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        }, 3
    )); //  yup: searching matrix: true
    System.out.println("yup: searching matrix: " + searchMatrix(
        new int[][]{
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        }, 13
    )); //  yup: searching matrix: false

    System.out.println("yup: searchMatrixEfficient matrix: " + searchMatrixEfficient(
        new int[][]{
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        }, 3
    )); //  yup: searchMatrixEfficient matrix: true
    System.out.println("yup: searchMatrixEfficient matrix: " + searchMatrixEfficient(
        new int[][]{
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        }, 13
    )); //  yup: searchMatrixEfficient matrix: false

    System.out.println("yup: searchMatrixEfficient matrix: " + searchMatrixEfficient(
        new int[][]{
            {1}
        }, 1
    )); //  yup: searchMatrixEfficient matrix: true
  }
}
