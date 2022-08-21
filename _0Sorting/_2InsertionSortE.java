package _0Sorting;

import java.util.Arrays;

//  https://www.youtube.com/watch?v=JU767SDMDvA&ab_channel=MichaelSambol
public class _2InsertionSortE {

  //  TC: O (n^2)
  private static void insertionSort(int[] arr) {
    int j;
    for (int i = 0; i < arr.length; i++) {
      j = i;
      while (j > 0 && arr[j - 1] > arr[j]) {
        swap(arr, j - 1, j);
        j--;
      }
    }
  }

  private static void swap(int[] arr, int a, int b) {
    arr[a] = arr[a] + arr[b];
    arr[b] = arr[a] - arr[b];
    arr[a] = arr[a] - arr[b];
  }

  public static void main(String[] args) {
    int[] arr = {4, 2, 1, 44, 8, 3};
    insertionSort(arr);
    System.out.println(
        "yup: sorted array: " + Arrays.toString(arr)); //  yup: sorted array: [1, 2, 3, 4, 8, 44]
  }
}
