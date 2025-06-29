package _0Sorting;

import java.util.Arrays;

//  https://www.youtube.com/watch?v=Il45xNUHGp0&ab_channel=Jenny%27slecturesCS%2FITNET%26JRF
//  https://www.youtube.com/watch?v=Tq2tDBLafUk&ab_channel=NikhilLohia
public class _1RadixSortE {

  private static int getMax(int[] arr) {
    int max = Integer.MIN_VALUE;
    for (int num : arr) {
      max = Math.max(max, num);
    }
    return max;
  }

  private static void radixSort(int[] arr) {
    int n = arr.length;
    int max = getMax(arr);
    for (int pos = 1; max / pos > 0; pos *= 10) {
      countSort(arr, n, pos);
    }
  }

  private static void countSort(int[] arr, int n, int pos) {
    int k = 10; //  0,1,2,.... 9
    int[] freqArr = new int[k];
    //  1. populate freqArr
    for (int i = 0; i < n; i++) {
      freqArr[(arr[i] / pos) % 10]++;
    }
    //  2. calculate indexes
    for (int i = 1; i < k; i++) {
      freqArr[i] = freqArr[i] + freqArr[i - 1];
    }
    //  3. populate tempArr -iterating from right side of arr to keep the stability of given array
    int[] tempArr = new int[n];
    for (int i = n - 1; i >= 0; i--) {
      tempArr[--freqArr[(arr[i] / pos) % 10]] = arr[i];
    }
    //  4. copy to original array
    for (int i = 0; i < n; i++) {
      arr[i] = tempArr[i];
    }
  }

  public static void main(String[] args) {
    int[] arr = {432, 8, 530, 90, 88, 231, 11, 45, 677, 199};
    System.out.println("yup: before sorting: " + Arrays.toString(
        arr)); //  yup: before sorting: [432, 8, 530, 90, 88, 231, 11, 45, 677, 199]
    radixSort(arr);
    System.out.println("yup: after sorting: " + Arrays.toString(
        arr));  //  yup: after sorting: [8, 11, 45, 88, 90, 199, 231, 432, 530, 677]
  }
}
