package _0easy;

import java.util.Arrays;

//  https://leetcode.com/problems/plus-one/
/*
* Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Example 3:

Input: digits = [0]
Output: [1]


Constraints:

1 <= digits.length <= 100
0 <= digits[i] <= 9
* */
public class PlusOne {

    /*
    * fails for
    Input
        [9,8,7,6,5,4,3,2,1,0]
        Output
        [1,2,8,6,6,0,8,6,1,9]
        Expected
        [9,8,7,6,5,4,3,2,1,1]
    * */
    public static int[] plusOnee(int[] digits) {
        if (digits == null || digits.length == 0)
            return null;

        int givenValue = 0;
        for (int digit : digits)
            givenValue = (givenValue * 10) + digit;

        givenValue++;
        int temp = givenValue;
        int noOfDigits = 0;
        for (; temp > 0; temp /= 10, ++noOfDigits) ;
        int[] res = new int[noOfDigits];
        int index = noOfDigits - 1;
        while (givenValue > 0 && index >= 0) {
            res[index--] = givenValue % 10;
            givenValue /= 10;
        }
        return res;
    }

    public static int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0)
            return null;

        if (digits[digits.length - 1] < 9) {
            digits[digits.length - 1] += 1;
            return digits;
        }
        //  if last digit is 9
        else {
            int j = digits.length - 1;
            while (j >= 0 && digits[j] == 9) {
                digits[j] = 0;
                j--;
            }   //j == -1 --> whole array is == 9 else j will stop inside loop
            if (j == -1) {    // if this case 999 --> 1000 array size increases so create new
                int[] arr = new int[digits.length + 1];
                arr[0] = 1;
                return arr;
            } else {
                digits[j] += 1; // increase digits at j with 1 rest 0
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        System.out.println("yup: " + Arrays.toString(plusOne(new int[]{1, 2, 3})));
        System.out.println("yup: 199: " + Arrays.toString(plusOne(new int[]{1, 9, 9})));
        System.out.println("yup: " + Arrays.toString(plusOne(new int[]{4, 3, 2, 1})));
        System.out.println("yup: " + Arrays.toString(plusOne(new int[]{4, 3, 2, 9})));
        System.out.println("yup: " + Arrays.toString(plusOne(new int[]{4, 3, 2, 9, 9})));
        System.out.println("yup: " + Arrays.toString(plusOne(new int[]{0})));
        System.out.println("yup: " + Arrays.toString(plusOne(new int[]{9})));
        System.out.println("yup: " + Arrays.toString(plusOne(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0})));
    }
}
