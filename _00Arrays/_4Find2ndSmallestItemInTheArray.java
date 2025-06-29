package _00Arrays;

import java.util.Arrays;

public class _4Find2ndSmallestItemInTheArray {

  //  TC: O (n log n)
  private static void print2ndSmallest(int[] arr) {
    if (arr.length < 2) {
      return;
    }
    Arrays.sort(arr);
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] != arr[0]) {
        System.out.println("yup: second smallest item: " + arr[i]);
        return;
      }
    }
    System.out.println("yup: there's no second smallest item");
  }

  //  TC: O (n)
  private static void print2ndSmallestBetterSolution(int[] arr) {
    if (arr.length < 2) {
      return;
    }
    int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
    for (int j : arr) {
      first = Math.min(first, j);
    }
    //  find 2nd min
    for (int j : arr) {
      if (j != first) {
        second = Math.min(second, j);
      }
    }
    System.out.println("yup: second min item: " + second);
  }

  //  TC: O (n)
  private static void print2ndSmallestEfficientSolution(int[] arr) {
    if (arr.length < 2) {
      return;
    }
    int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
    for (int num : arr) {
      if (num < first) {
        second = first;
        first = num;
      } else if (num < second && num != first) {
        second = num;
      }
    }
    System.out.println("yup: second min item: " + second);
  }

  public static void main(String[] args) {
    int[] arr = {33, 2, 1, -1, 3};
    print2ndSmallest(arr);  //  1
    print2ndSmallestBetterSolution(arr);  //  1
    print2ndSmallestEfficientSolution(arr);  //  1
  }
}
