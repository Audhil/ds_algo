package _10Blind75._10Matrix;

import java.util.Arrays;

//  https://leetcode.com/problems/rotate-image/
//  _3RotateMatrixInPlaceM.java
public class _3RotateImageMatrixInplaceM {

  private static void rotateRevision(int[][] matrix) {
    int l = 0, r = matrix[0].length - 1;
    while (l < r) {
      for (int i = 0; i < (r - l); i++) {
        int top = l, bottom = r;
        int topLeft = matrix[top][l + i];
        matrix[top][l + i] = matrix[bottom - i][l];
        matrix[bottom - i][l] = matrix[bottom][r - i];
        matrix[bottom][r - i] = matrix[top + i][r];
        matrix[top + i][r] = topLeft;
      }
      l++;
      r--;
    }
  }

  public static void rotate(int[][] matrix) {
    int l = 0, r = matrix[0].length - 1;
    while (l < r) {
      for (int i = 0; i < (r - l); i++) {
        int top = l, bottom = r;
        int topLeft = matrix[top][l + i];
        matrix[top][l + i] = matrix[bottom - i][l];
        matrix[bottom - i][l] = matrix[bottom][r - i];
        matrix[bottom][r - i] = matrix[top + i][r];
        matrix[top + i][r] = topLeft;
      }
      l++;
      r--;
    }
  }

  public static void main(String[] args) {
    int[][] m1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    rotate(m1);
    System.out.println("yup: rotated Matrix: " + Arrays.deepToString(
        m1));  //  yup: rotated Matrix: [[7, 4, 1], [8, 5, 2], [9, 6, 3]]
    int[][] m2 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
    rotate(m2);
    System.out.println("yup: rotated Matrix: " + Arrays.deepToString(
        m2));  //  yup: rotated Matrix: [[15, 13, 2, 5], [14, 3, 4, 1], [12, 6, 8, 9], [16, 7, 10, 11]]
  }
}