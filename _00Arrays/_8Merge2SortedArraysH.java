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

  //  2. TC: O (n); SC: O (1)
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

  public static void main(String[] args) {
    int[] arr1 = {5, 33, 1, 6, 88};
    int[] arr2 = {-5, -33, 14, 116, 808};
    System.out.println("yup: brute-force solution: ");
    System.out.println("yup: after merging: " + Arrays.toString(
        merge2Arrays(arr1, arr2))); //  yup: after merging: [-33, -5, 1, 5, 6, 14, 33, 88, 116, 808]
    System.out.println("yup: arr1: " + Arrays.toString(arr1));  //  yup: arr1: [-33, -5, 1, 5, 6]
    System.out.println(
        "yup: arr2: " + Arrays.toString(arr2));  //  yup: arr2: [14, 33, 88, 116, 808]
    System.out.println("yup: better solution: ");
    merge2ArraysBetter(arr1, arr2);
    System.out.println("yup: after merging: ");
    System.out.println("yup: arr1: " + Arrays.toString(arr1));  //  yup: arr1: [-5, -33, 1, 5, 6]
    System.out.println(
        "yup: arr2: " + Arrays.toString(arr2));  //  yup: arr2: [14, 33, 88, 116, 808]
  }
}
