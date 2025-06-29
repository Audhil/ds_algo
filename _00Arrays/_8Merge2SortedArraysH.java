package _00Arrays;

import java.util.Arrays;

//  https://www.youtube.com/watch?v=hVl2b3bLzBw&ab_channel=takeUforward
public class _8Merge2SortedArraysH {

  //  1. TC: O (n log n); SC: O (n)
  private static int[] merge2Arrays(int[] arr1, int[] arr2) {
    int[] ans = new int[arr1.length + arr2.length];
    for (int i = 0; i < arr1.length; i++) {
      ans[i] = arr1[i];
    }
    for (int i = 0; i < arr2.length; i++) {
      ans[arr1.length + i] = arr2[i];
    }
    Arrays.sort(ans);
    //  copy back as asked in question
    for (int i = 0; i < arr1.length; i++) {
      arr1[i] = ans[i];
    }
    for (int i = 0; i < arr2.length; i++) {
      arr2[i] = ans[arr1.length + i];
    }
    return ans;
  }

  //  2. TC: O (m * n); SC: O (1)
  //  this method will work for all given sorted input arrays
  private static void merge2ArraysBetter(int[] X, int[] Y) {
    int temp;
    int m = X.length;
    int n = Y.length;
    for (int i = 0; i < m; i++) {
      if (X[i] > Y[0]) {
        temp = X[i];
        X[i] = Y[0];
        Y[0] = temp;
        //  adjust insertion the 2nd array
        int first = Y[0];
        int k;
        for (k = 1; k < n && Y[k] < first; k++) {
          Y[k - 1] = Y[k];
        }
        Y[k - 1] = first;
      }
    }
  }

  //  https://www.geeksforgeeks.org/efficiently-merging-two-sorted-arrays-with-o1-extra-space/
  //  3. TC: O (m + n) * O (log m + n); SC: O (1) - Gap method
  private static void merge2ArraysEfficient(int[] X, int[] Y) {
    mergeWithGapMethod(X, Y, X.length, Y.length);
  }

  private static void mergeWithGapMethod(int[] x, int[] y, int n, int m) {
    int i, j, gap = n + m;
    for (gap = getGap(gap); gap > 0; gap = getGap(gap)) {
      //  iterate arr 1
      for (i = 0; i + gap < n; i++) {
        if (x[i] > x[i + gap]) {
          int temp = x[i + gap];
          x[i + gap] = x[i];
          x[i] = temp;
        }
      }
      //  iterate both arr 1 & arr 2
      for (j = gap > n ? gap - n : 0; i < n && j < m; i++, j++) {
        if (x[i] > y[j]) {
          int temp = y[j];
          y[j] = x[i];
          x[i] = temp;
        }
      }
      //  iterate arr 2
      if (j < m) {
        for (j = 0; j + gap < m; j++) {
          if (y[j] > y[j + gap]) {
            int temp = y[j + gap];
            y[j + gap] = y[j];
            y[j] = temp;
          }
        }
      }
    }
  }

  //  taking ceil value for gap
  private static int getGap(int gap) {
    if (gap <= 1) {
      return 0;
    }
    return (gap / 2) + (gap % 2);
  }

  public static void main(String[] args) {
    int[] arr1 = {5, 33, 1, 6, 88};
    int[] arr2 = {-5, -33, 14, 116, 808};
//    System.out.println("yup: brute-force solution: ");
//    System.out.println("yup: after merging: " + Arrays.toString(
//        merge2Arrays(arr1, arr2))); //  yup: after merging: [-33, -5, 1, 5, 6, 14, 33, 88, 116, 808]
//    System.out.println("yup: arr1: " + Arrays.toString(arr1));  //  yup: arr1: [-33, -5, 1, 5, 6]
//    System.out.println(
//        "yup: arr2: " + Arrays.toString(arr2));  //  yup: arr2: [14, 33, 88, 116, 808]
//    System.out.println("yup: better solution: ");
//    merge2ArraysBetter(arr1, arr2);
//    System.out.println("yup: after merging: ");
//    System.out.println("yup: arr1: " + Arrays.toString(arr1));  //  yup: arr1: [-5, -33, 1, 5, 6]
//    System.out.println(
//        "yup: arr2: " + Arrays.toString(arr2));  //  yup: arr2: [14, 33, 88, 116, 808]
    System.out.println("yup: using efficient Gap method: ");
    merge2ArraysEfficient(arr1, arr2);
    System.out.println("yup: after merging: ");
    System.out.println("yup: arr1: " + Arrays.toString(arr1));  //  yup: arr1: [-33, -5, 1, 5, 6]
    System.out.println(
        "yup: arr2: " + Arrays.toString(arr2));  //  yup: arr2: [14, 33, 88, 116, 808]
  }
}
