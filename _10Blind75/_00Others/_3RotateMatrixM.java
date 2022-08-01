package _10Blind75._00Others;

import java.util.Arrays;

//  https://leetcode.com/problems/rotate-image/
public class _3RotateMatrixM {

  //  with extra matrix - TC: O(n^2), SC: O(n)
  public static int[][] rotate(int[][] matrix) {
    int size = matrix.length;
    int[][] output = new int[size][size];
    for (int j = 0; j < size; j++) {
      for (int i = size - 1; i >= 0; i--) {
        output[j][size - 1 - i] = matrix[i][j];
      }
    }

    //  print matrix
    System.out.println("printing res matrix: ");
    for (int i = 0; i < output.length; i++) {
      for (int j = 0; j < output[0].length; j++) {
        System.out.print(output[i][j] + " ");
      }
      System.out.println();
    }
    return output;
  }

  //  with TC - O(n^2) & SC - O(1)
  //  https://www.youtube.com/watch?v=fMSJSS7eO1w&ab_channel=NeetCode
  public static int[][] rotateInPlaceAlgo(int[][] matrix) {
    if (matrix == null) {
      return null;
    }

    int l = 0, r = matrix.length - 1;

    while (l < r) {
      for (int i = 0; i < (r - l); i++) {
        int top = l, bottom = r;
        int topLeft = matrix[top][l + i]; //  save the value

        //  replace top left with bottom left
        matrix[top][l + i] =
            matrix[bottom - i][l]; //  using i, we'll shift pointers 1 place at a time

        //  replace bottom left to bottom right
        matrix[bottom - i][l] = matrix[bottom][r - i];

        //  replace bottom right with top right
        matrix[bottom][r - i] = matrix[top + i][r];

        //  replace top right with top left
        matrix[top + i][r] = topLeft;
      }
      l += 1;
      r -= 1;
    }
    return matrix;
  }

  private static void printMatrix(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
//    System.out.println(
//        "yup: rotat: Matrix: " + Arrays.deepToString(
//            rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
//
//    System.out.println(
//        "yup: rotat: Matrix: " + Arrays.deepToString(
//            rotate(new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}})));

    int[][] matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
    printMatrix(matrix);
    System.out.println(
        "yup: rotateInPlaceAlgo: Matrix: " + Arrays.deepToString(rotateInPlaceAlgo(matrix)));
    printMatrix(matrix);
  }
}
