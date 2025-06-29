package _10Blind75._10Matrix;

import java.util.Arrays;

//  do it in-place
//  https://leetcode.com/problems/set-matrix-zeroes/
//  https://www.youtube.com/watch?v=T41rL0L3Pnw&ab_channel=NeetCode
public class _1SetMatrixZeroesM {

  public static void revision2(int[][] matrix) {
    int m = matrix.length;  //  m rows
    int n = matrix[0].length; //  n cols
    boolean rowZero = false;
    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (matrix[r][c] == 0) {
          //  mark first item in col as zero
          matrix[0][c] = 0;
          //  mark first item in row as zero
          if (r > 0) {
            matrix[r][0] = 0;
          } else {
            //  special case
            rowZero = true;
          }
        }
      }
    }

    //  check col and mark it as zero
    for (int r = 1; r < m; r++) {
      for (int c = 1; c < n; c++) {
        if (matrix[0][c] == 0 || matrix[r][0] == 0) {
          matrix[r][c] = 0;
        }
      }
    }

    //  mark 0th col as zero
    if (matrix[0][0] == 0) {
      for (int r = 0; r < m; r++) {
        matrix[r][0] = 0;
      }
    }

    //  mark 0th row as zero
    if (rowZero) {
      for (int c = 0; c < n; c++) {
        matrix[0][c] = 0;
      }
    }
  }

  public static void revision(int[][] matrix) {
    int m = matrix.length;
    int n = matrix[0].length;
    boolean rowZero = false;

    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (matrix[r][c] == 0) {
          matrix[0][c] = 0; //  mark the first item in the col to 0
          if (r > 0) {
            matrix[r][0] = 0; //  mark the first item in the row to 0
          } else {
            rowZero = true;
          }
        }
      }
    }

    //  mark zeros
    for (int r = 1; r < m; r++) {
      for (int c = 1; c < n; c++) {
        if (matrix[0][c] == 0 || matrix[r][0] == 0) {
          matrix[r][c] = 0;
        }
      }
    }

    //  mark the 0th col to zero
    if (matrix[0][0] == 0) {
      for (int r = 0; r < m; r++) {
        matrix[r][0] = 0;
      }
    }

    //  mark the 0th row to zero
    if (rowZero) {
      for (int c = 0; c < n; c++) {
        matrix[0][c] = 0;
      }
    }
  }

  //  TC - O (m * n) & SC - O (1)
  public static void setZeroes(int[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;
    boolean rowZero = false;

    //  1. mark which rows and cols to make zero
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        if (matrix[r][c] == 0) {
          matrix[0][c] = 0; //  mark first item of the col as 0
          if (r > 0) {
            matrix[r][0] = 0; //  mark first item of the row as 0
          } else {
            rowZero = true; //  special case of 0,0 - which is overlapping
          }
        }
      }
    }

    //  2. make marked rows/cols zero
    for (int r = 1; r < rows; r++) {
      for (int c = 1; c < cols; c++) {
        if (matrix[0][c] == 0
            || matrix[r][0] == 0) { //  is first item of col or first item of row is marked as 0
          matrix[r][c] = 0;
        }
      }
    }

    //  3. make first col as zero if needed
    if (matrix[0][0] == 0) {
      for (int r = 0; r < rows; r++) {
        matrix[r][0] = 0;
      }
    }

    //  4. make first row as zero if needed
    if (rowZero) {
      for (int c = 0; c < cols; c++) {
        matrix[0][c] = 0;
      }
    }
  }

  public static void main(String[] args) {
    int[][] m1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
    System.out.println("yup: m1 : " + Arrays.deepToString(m1));
    setZeroes(m1);
    System.out.println("yup: after processing m1 : " + Arrays.deepToString(m1));

    int[][] m2 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
    System.out.println("yup: m1 : " + Arrays.deepToString(m2));
    setZeroes(m2);
    System.out.println("yup: after processing m1 : " + Arrays.deepToString(m2));
  }
}
