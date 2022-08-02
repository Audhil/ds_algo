package _10Blind75._10Matrix;

import java.util.ArrayList;
import java.util.List;

//  https://www.youtube.com/watch?v=BJnMZNwUk1M&ab_channel=NeetCode
//  https://leetcode.com/problems/spiral-matrix/
public class _2SpiralMatrixM {

  public static List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> resList = new ArrayList<>();
    //  4 pointers
    int left = 0, right = matrix[0].length, top = 0, bottom = matrix.length;
    while (left < right && top < bottom) {
      //  l to r
      for (int i = left; i < right; i++) {
        resList.add(matrix[top][i]);
      }
      top += 1;
      //  t to b
      for (int i = top; i < bottom; i++) {
        resList.add(matrix[i][right - 1]);
      }
      right -= 1;
      //  mandatory break
      if (!(left < right && top < bottom)) {
        break;
      }
      //  r to l
      for (int i = right - 1; i >= left; i--) {
        resList.add(matrix[bottom - 1][i]);
      }
      bottom -= 1;
      //  b to t
      for (int i = bottom - 1; i >= top; i--) {
        resList.add(matrix[i][left]);
      }
      left += 1;
    }
    return resList;
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: spiral matrix: " + spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6},
            {7, 8, 9}}));  //  yup: spiral matrix: [1, 2, 3, 6, 9, 8, 7, 4, 5]

    System.out.println(
        "yup: 2nd spiral matrix: " + spiralOrder(
            new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11,
                12}})); //  yup: 2nd spiral matrix: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
  }
}