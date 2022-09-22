package _0easy;

import java.util.Arrays;

//  https://www.geeksforgeeks.org/given-pairwise-sum-n-numbers-find-numbers/
//  notes @ https://photos.google.com/photo/AF1QipO0ei-6wwk3RoDLpAfm1eY5x4ZfwG3DJpuCKUMC
public class _Pairwise_sum_n_numbersE {

  /*
  * Observation :
    b_minus_a = b - a = arr[n-1] - arr[1]
    b = (arr[0] + b_minus_a)/2
    a = (arr[0] - b)
    c = arr[1] - a
    d = arr[2] - a
    ..........

    n = 5, {a+b, a+c, a+d, a+e, b+c,
            b+d, b+e, c+d, c+e, d+e}

    Then calculate b-a = arr[n-1] - arr[1]
                       = (b+c) - (a+c)
    Then b = (arr[0] + (b-a)) / 2
           = ((a+b) + (b-a)) / 2
         a = arr[0] - b
           = (a+b) - b
    Then for i=1 to n-2,
    remaining numbers are calculated as
    arr[i] - a, like
           c = arr[1] - a
             = (a+c) - a
           d = arr[2] - a
             = (a+c) - a      and so on,
              .
              .
              .
              .
    last number = arr[n-2] - a
    * */

  public static void main(String[] args) {
    int[] arr = {13, 10, 14, 9, 17, 21,
        16, 18, 13, 17};
    // n is not size of array, but number of
    // elements whose pairwise sum is stored
    // in arr[]
    int n = 5;
    findNumbers(arr, n);
  }

  // n is not size of array, but number of
  // elements whose pairwise sum is stored
  // in arr[]
  private static void findNumbers(int[] arr, int n) {
    int[] nums = new int[n];
    //  1. find b-a => arr[n - 1] - arr[1]
    int b_minus_a = arr[n - 1] - arr[1];
    //  2. find b => (arr[0] + b_minus_a) / 2
    int b = (arr[0] + b_minus_a) / 2;
    nums[1] = b;
    //  3. find a => (arr[0] - b)
    int a = arr[0] - b;
    nums[0] = a;
    //  4. find other nums - considering items with a's contribution (a+b, a+c, a+d, a+e, a+f)
    for (int i = 1; i <= (n - 2); i++) {
      nums[i + 1] = arr[i] - a;
    }

    //  5. print numbers
    System.out.println("yup the numbers are : " + Arrays.toString(
        nums)); //  yup the numbers are : [3, 10, 7, 11, 6]
  }
}
