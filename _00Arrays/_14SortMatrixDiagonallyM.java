package _00Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//  https://youtu.be/JBqUl7avtG8
//  https://leetcode.com/problems/sort-the-matrix-diagonally/
public class _14SortMatrixDiagonallyM {

  //  using count sort techinque
  //  TC: O ((m + n) * (k)); SC: O (1)
  private static void withCountSort(int row, int col, int[][] mat, int m, int n) {
    int[] vals = new int[101];  //  constraint given in prob
    int r = row, c = col;
    while (r < m && c < n) {
      vals[mat[r][c]]++;
      r++;
      c++;
    }
    r = row;
    c = col;
    for (int i = 1; i < 101; i++) {
      if (vals[i] > 0) {
        int count = vals[i];
        while (count-- > 0) {
          mat[r][c] = i;
          r++;
          c++;
        }
      }
    }
  }


  //  TC: O ((m + n) * (k log k)); SC: O (k) => k = min(m,n)
  public static int[][] diagonalSort(int[][] mat) {
    int m = mat.length; //  rows
    int n = mat[0].length;  //  cols

    //  sort row 0
    for (int c = 0; c < n; c++) {
//      sort(0, c, mat, m, n);
      withCountSort(0, c, mat, m, n);
    }

    //  sort col 0
    for (int r = 0; r < m; r++) {
//      sort(r, 0, mat, m, n);
      withCountSort(r, 0, mat, m, n);
    }
    return mat;
  }

  private static void sort(int row, int col, int[][] mat, int m, int n) {
    List<Integer> list = new ArrayList<>();
    int r = row, c = col;
    while (r < m && c < n) {
      list.add(mat[r][c]);
      r++;
      c++;
    }
    Collections.sort(list);
    r = row;
    c = col;
    int ind = 0;
    while (r < m && c < n) {
      mat[r][c] = list.get(ind++);
      r++;
      c++;
    }
  }

  public static void main(String[] args) {
    System.out.println("yup: diagonally sorted matrix: " + Arrays.deepToString(
        diagonalSort(new int[][]{
            {3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}
        }))
    );  //  yup: diagonally sorted matrix: [[1, 1, 1, 1], [1, 2, 2, 2], [1, 2, 3, 3]]

    System.out.println("yup: diagonally sorted matrix: " + Arrays.deepToString(
        diagonalSort(new int[][]{
            {11, 25, 66, 1, 69, 7}, {23, 55, 17, 45, 15, 52}, {75, 31, 36, 44, 58, 8},
            {22, 27, 33, 25, 68, 4}, {84, 28, 14, 11, 5, 50}
        }))
    );  //  yup: diagonally sorted matrix: [[5, 17, 4, 1, 52, 7], [11, 11, 25, 45, 8, 69], [14, 23, 25, 44, 58, 15], [22, 27, 31, 36, 50, 66], [84, 28, 75, 33, 55, 68]]
  }
}
