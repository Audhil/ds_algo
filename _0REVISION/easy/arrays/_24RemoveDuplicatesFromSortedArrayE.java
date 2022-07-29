package _0REVISION.easy.arrays;

import java.util.Arrays;

//  https://www.youtube.com/watch?v=DEJAZBq0FDA&ab_channel=NeetCode
public class _24RemoveDuplicatesFromSortedArrayE {

  private static int removeDuplicates(int[] arr) {
    int n = arr.length;
    if (n == 0 || n == 1) {
      return n;
    }
    int l = 1;
    for (int r = 1; r < n; r++) {
      if (arr[r] != arr[r - 1]) {
        arr[l++] = arr[r];
      }
    }
    //  fill extra spaces in array with anything you like
    for (int i = l; i < n; i++) {
      arr[i] = Integer.MAX_VALUE;
    }
    return l;
  }

  public static void main(String[] args) {
    int[] arr = {1, 1, 2, 2, 3, 5, 5};
    System.out.println("yup:  no of unique values: " + removeDuplicates(arr));
    System.out.println("yup: final array: " + Arrays.toString(arr));
  }
}
