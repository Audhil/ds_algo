package _10Blind25;

import java.util.Arrays;

//  https://leetcode.com/problems/rotate-image/
public class RotateMatrixM {

  //  with extra matrix
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

  public static void main(String[] args) {
    System.out.println(
        "yup: rotat: Matrix: " + Arrays.deepToString(
            rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));

    System.out.println(
        "yup: rotat: Matrix: " + Arrays.deepToString(
            rotate(new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}})));
  }
}
