package _0easy;

import java.util.HashSet;
import java.util.Set;

//  https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/
//  https://youtu.be/rOZgz6gc8Yo
public class CheckValidMatrixE {

  //  TC: O (n^2); SC: O (n^2)
  public static boolean checkValid(int[][] matrix) {
    int n = matrix.length;
    Set<Integer> set = new HashSet<>();
    //  move row wise
    for (int i = 0; i < n; i++) {
      set.clear();
      for (int j = 0; j < n; j++) {
        if (!set.add(matrix[i][j])) {
          return false;
        }
      }
    }
    //  move col wise
    for (int i = 0; i < n; i++) {
      set.clear();
      for (int j = 0; j < n; j++) {
        if (!set.add(matrix[j][i])) {
          return false;
        }
      }
    }
    return true;
  }

  //  using XOR - a^a = 0; 0^a = a;
  //  TC: O (n^2); SC: O (1)
  public static boolean checkValidWithXor(int[][] matrix) {
    int n = matrix.length;
    int rXor, cXor;
    for (int i = 0; i < n; i++) {
      rXor = 0;
      cXor = 0;
      for (int j = 0; j < n; j++) {
        //  0^(value at 0,0)^1; 0^(value at 0,1)^2; 0^(value at 0,2)^3
        rXor ^= matrix[i][j] ^ (j + 1);
        cXor ^= matrix[j][i] ^ (j + 1);
      }
      if (rXor != 0 || cXor != 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
//    System.out.println("yup: is valid matrix: " + checkValid(new int[][]{
//        {1, 1, 1}, {1, 2, 3}, {1, 2, 3}
//    }));  //  yup: is valid matrix: false
//    System.out.println(
//        "yup: is valid matrix with checkValidWithXor: " + checkValidWithXor(new int[][]{
//            {1, 1, 1}, {1, 2, 3}, {1, 2, 3}
//        }));  //  yup: is valid matrix: false
    System.out.println(
        "yup: is valid matrix with checkValid: " + checkValid(new int[][]{
            {1, 2, 2, 4, 5, 6, 6}, {2, 2, 4, 5, 6, 6, 1}, {2, 4, 5, 6, 6, 1, 2},
            {4, 5, 6, 6, 1, 2, 2}, {5, 6, 6, 1, 2, 2, 4}, {6, 6, 1, 2, 2, 4, 5},
            {6, 1, 2, 2, 4, 5, 6}
        }));  //  yup: is valid matrix: false
//    System.out.println(
//        "yup: is valid matrix with checkValidWithXor: " + checkValidWithXor(new int[][]{
//            {1, 2, 2, 4, 5, 6, 6}, {2, 2, 4, 5, 6, 6, 1}, {2, 4, 5, 6, 6, 1, 2},
//            {4, 5, 6, 6, 1, 2, 2}, {5, 6, 6, 1, 2, 2, 4}, {6, 6, 1, 2, 2, 4, 5},
//            {6, 1, 2, 2, 4, 5, 6}
//        }));  //  yup: is valid matrix: false
  }
}
