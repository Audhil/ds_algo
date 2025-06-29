package _0easy._facebook;

import java.util.Arrays;

//  https://www.geeksforgeeks.org/find-next-greater-number-set-digits/
public class _2FindNextGreatestNumberWithSameDigitsE {

  /*
      Traverse the given number from rightmost digit, keep traversing till you find a digit which is smaller than the previously traversed digit.
      For example, if the input number is “534976”, we stop at 4 because 4 is smaller than next digit 9.
      If we do not find such a digit, then output is “Not Possible”.
      Now search the right side of above found digit ‘d’ for the smallest digit greater than ‘d’.
      For “534976″, the right side of 4 contains “976”.
      The smallest digit greater than 4 is 6.
      Swap the above found two digits, we get 536974 in above example.
      Now sort all digits from position next to ‘d’ to the end of number.
      The number that we get after sorting is the output.
      For above example, we sort digits in bold 536974.
      We get “536479” which is the next greater number for input 534976.
   */
  //  TC: O (n log n); SC: O (1)
  private static void nextGreatestNum(char[] num) {
    int n = num.length, r = num.length - 1;
    //  1. find smallest num from right
    for (; r > 0; r--) {
      if (num[r] > num[r - 1]) {
        break;
      }
    }
    //  edge case - since all chars are in decreasing order
    if (r == 0) {
      System.out.println("NOT POSSIBLE");
      return;
    }
    //  2. find next greatest number from the smallest num
    int min = r;
    for (int i = r + 1; i < n; i++) {
      if (num[i] > num[r - 1] && num[i] < num[min]) {
        min = i;
      }
    }
    //  3. swap smallest num with next greatest number
    char temp = num[r - 1];
    num[r - 1] = num[min];
    num[min] = temp;
    //  4. sort the array after r-1 index
    Arrays.sort(num, r, n);
    //  5. the final result - next smallest greater number of given is,
    System.out.println(num);
  }

  //  TC: O (n); SC: O (1)
  private static int[] nextGreatestNumOptimised(int[] num) {
    int n = num.length, r = num.length - 1;
    //  1. find smallest num from right
    for (; r > 0; r--) {
      if (num[r] > num[r - 1]) {
        break;
      }
    }
    //  edge case - since all chars are in decreasing order
    if (r == 0) {
      System.out.println("NOT POSSIBLE");
      return num;
    }
    //  2. find next greatest number from the smallest num
    int min = r;
    for (int i = r + 1; i < n; i++) {
      if (num[i] > num[r - 1] && num[i] < num[min]) {
        min = i;
      }
    }
    //  3. swap smallest num with next greatest number
    int temp = num[r - 1];
    num[r - 1] = num[min];
    num[min] = temp;

    //  3. copy original items till r-1
    int[] res = new int[n];
    for (int j = 0; j < r; j++) {
      res[j] = num[j];
    }
    //  4. copy reverse from right index(since items from r is in decreasing order)
    int index = n - 1;
    for (int j = r; j < n; j++) {
      res[j] = num[index--];
    }
    return res;
  }

  public static void main(String[] args) {
    char[] chars = {'5', '3', '4', '9', '7', '6'};
    System.out.println(
        "yup: given num : " + Arrays.toString(chars)); //  yup: given num : [5, 3, 4, 9, 7, 6]
    nextGreatestNum(chars);
    System.out.println("yup: next greatest num : " + Arrays.toString(
        chars)); //  yup: next greatest num : [5, 3, 6, 4, 7, 9]
    System.out.println("yup: with int arr: ");
    int[] nums = {5, 3, 4, 9, 7, 6};
    System.out.println(
        "yup: given num : " + Arrays.toString(nums)); //  yup: given num : [5, 3, 4, 9, 7, 6]
    System.out.println(
        "yup: next greatest num : " + Arrays.toString(
            nextGreatestNumOptimised(nums))); //  yup: next greatest num : [5, 3, 6, 4, 7, 9]
  }
}
