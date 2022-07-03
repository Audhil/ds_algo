package _10Blind25._0Arrays;

import java.util.Arrays;

public class _11RotateArray {

  //  TC: O (n) & SC: O (1)
  private static void rotateArray(int[] arr, int k) {
    if (arr == null) {
      return;
    }

    System.out.println("array before rotation: " + Arrays.toString(arr));
    //  https://youtu.be/ENcnXXiRT6E?t=352
    //  1. reverse 0, n - k -1
    //  2. reverse n - k, n -1
    //  3. reverse 0, n -1
    int n = arr.length;
    reverse(0, n - k - 1, arr);
    reverse(n - k, n - 1, arr);
    reverse(0, n - 1, arr);
    System.out.println("array after rotation: " + Arrays.toString(arr));
  }

  private static void reverse(int s, int e, int[] arr) {
    int temp;
    while (s < e) {
      temp = arr[s];
      arr[s] = arr[e];
      arr[e] = temp;
      s++;
      e--;
    }
  }

  public static void main(String[] args) {
    //  array before rotation: [1, 2, 3, 4, 5]
    //  array after rotation: [3, 4, 5, 1, 2]
    rotateArray(new int[]{1, 2, 3, 4, 5}, 3);
  }
}
