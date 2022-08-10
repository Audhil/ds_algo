package _0Sorting;

import java.util.Arrays;

//  suitable for small digits numbers,
//  TC: O (n) + O(k); SC: O (n) + O (k)
//  https://www.youtube.com/watch?v=pEJiGC-ObQE&ab_channel=Jenny%27slecturesCS%2FITNET%26JRF
public class _0CountingSortE {

  //  sorting the +ve numbers
  private static int[] countingSort(int[] arr) {
    int n = arr.length;
    //  1. find k, if not given
    int k = Integer.MIN_VALUE;
    for (int j : arr) {
      k = Math.max(k, j);
    }
    //  2. create freq arr
    int[] freqArr = new int[k + 1];
    for (int j : arr) {
      freqArr[j]++;
    }
    //  3. fill up indices
    for (int i = 1; i < freqArr.length; i++) {
      freqArr[i] += freqArr[i - 1];
    }
    //  4. fill up the temp array - iterating from right side of arr to keep the stability of given array
    int[] tempArr = new int[n];
    for (int i = n - 1; i >= 0; i--) {
      tempArr[--freqArr[arr[i]]] = arr[i];
    }
    //  5. copy back to original array
    for (int i = 0; i < tempArr.length; i++) {
      arr[i] = tempArr[i];
    }
    return arr;
  }

  public static void main(String[] args) {
    int[] arr = {1, 0, 2, 1, 0, 1, 1, 5, 6, 7, 5, 4, 2, 2, 0, 0, 1};
    System.out.println("yup: after Counting Sort: " + Arrays.toString(countingSort(
        arr)));  //  yup: after Counting Sort: [0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 4, 5, 5, 6, 7]

    int[] arr2 = {1, 0, 2, 1, 0, 1, 1, 5, -6, -7, 5, 4, 2, 2, 0, 0, 1};
    System.out.println("yup: 2nd original array : " + Arrays.toString(
        arr2)); //  yup: 2nd original array : [1, 0, 2, 1, 0, 1, 1, 5, -6, -7, 5, 4, 2, 2, 0, 0, 1]
    normalise(arr2);
    System.out.println("yup: 2nd after normalise : " + Arrays.toString(
        arr2));  //  yup: 2nd after normalise : [8, 7, 9, 8, 7, 8, 8, 12, 1, 0, 12, 11, 9, 9, 7, 7, 8]
    System.out.println("yup: 2nd after Counting Sort: " + Arrays.toString(countingSort(
        arr2))); //  yup: 2nd after Counting Sort: [0, 1, 7, 7, 7, 7, 8, 8, 8, 8, 8, 9, 9, 9, 11, 12, 12]
    deNormalise(arr2);
    System.out.println("yup: 2nd original array after deNormalise: " + Arrays.toString(
        arr2));  //  yup: 2nd original array after deNormalise: [-7, -6, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 4, 5, 5]
  }

  private static void deNormalise(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      arr[i] = arr[i] - Math.abs(min);
    }
  }

  private static int min = Integer.MAX_VALUE;

  private static void normalise(int[] arr) {
    //  1. find min
    for (int num : arr) {
      min = Math.min(min, num);
    }
    //  2. normalise
    for (int i = 0; i < arr.length; i++) {
      arr[i] = arr[i] + Math.abs(min);
    }
  }
}
