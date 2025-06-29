package _0easy._facebook;

import java.util.Arrays;

//  https://www.lintcode.com/problem/64/?fromId=29&_from=collection
public class _8Merge2SortedArrayE {

  //  TC: O (n); SC: O(1)
  public static int[] mergeSortedArray(int[] A, int m, int[] B, int n) {
    int i = m + n - 1;
    int l = m - 1;
    int r = n - 1;
    while (r >= 0) {
      if (l >= 0 && A[l] > B[r]) {
        A[i--] = A[l--];
      } else {
        A[i--] = B[r--];
      }
    }
    return A;
  }

  public static void main(String[] args) {
    System.out.println("yup: merge 2 sorted arrays are : " + Arrays.toString(
        mergeSortedArray(new int[]{1, 2, 3, 0, 0}, 3, new int[]{4, 5},
            2)));  //  yup: merge 2 sorted arrays are : [1, 2, 3, 4, 5]

    System.out.println("yup: merge 2 sorted arrays are : " + Arrays.toString(
        mergeSortedArray(new int[]{1, 2, 5, 0, 0}, 3, new int[]{3, 4},
            2)));  //  yup: merge 2 sorted arrays are : [1, 2, 3, 4, 5]
  }
}
