package _00Arrays;

import java.util.Arrays;

public class _3Find2ndLargestItemInTheArray {

  //  TC: O (n log n)
  private static void print2ndLargest(int[] arr) {
    if (arr.length < 2) {
      return;
    }
    int n = arr.length;
    Arrays.sort(arr);
    for (int i = n - 2; i >= 0; i--) {
      if (arr[i] != arr[n - 1]) {
        System.out.println("the second largest item is : " + arr[i]);
        return;
      }
    }
    System.out.println("yup: print2ndLargest : something went wrong!");
  }

  //  TC: O (n)
  private static void print2ndLargestWithBetterApproach(int[] arr) {
    if (arr.length < 2) {
      return;
    }
    int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
    for (int j : arr) {
      first = Math.max(first, j);
    }
    //  find 2nd largest item
    for (int j : arr) {
      if (j != first) {
        second = Math.max(second, j);
      }
    }
    System.out.println("yup: 2nd largest : " + second);
  }

  //  efficient solution - O (n)
  private static void print2ndLargestWithEfficientSolution(int[] arr) {
    if (arr.length < 2) {
      return;
    }
    int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
    for (int num : arr) {
      if (num > first) {
        second = first;
        first = num;
      } else if (num > second && num != first) {
        second = num;
      }
    }
    System.out.println("yup: the second largest number: " + second);
  }

  public static void main(String[] args) {
    int[] arr = {33, 2, 0, -1, 3};
    print2ndLargest(arr); //  3
    print2ndLargestWithBetterApproach(arr); //  3
    print2ndLargestWithEfficientSolution(arr);  //  3
  }
}
