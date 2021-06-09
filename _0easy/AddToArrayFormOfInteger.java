package _0easy;

import java.util.ArrayList;
import java.util.List;

//  https://leetcode.com/problems/add-to-array-form-of-integer/
/*
* The array-form of an integer num is an array representing its digits in left to right order.

For example, for num = 1321, the array form is [1,3,2,1].
Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.



Example 1:

Input: num = [1,2,0,0], k = 34
Output: [1,2,3,4]
Explanation: 1200 + 34 = 1234
Example 2:

Input: num = [2,7,4], k = 181
Output: [4,5,5]
Explanation: 274 + 181 = 455
Example 3:

Input: num = [2,1,5], k = 806
Output: [1,0,2,1]
Explanation: 215 + 806 = 1021
Example 4:

Input: num = [9,9,9,9,9,9,9,9,9,9], k = 1
Output: [1,0,0,0,0,0,0,0,0,0,0]
Explanation: 9999999999 + 1 = 10000000000
*
* */
public class AddToArrayFormOfInteger {

    public static List<Integer> addToArrayForm(int[] num, int k) {
        if (num == null)
            return null;

        int index, sum, carry = 0;
        List<Integer> intList = new ArrayList<>();
        for (index = num.length - 1; index >= 0 && k > 0; index--) {
            sum = carry;
            sum += num[index] + (k % 10);
            carry = sum / 10;
            intList.add(sum % 10);
            k /= 10;
        }
        if (k > 0)
            carry = k;
        System.out.println("yup: index: " + index);
        System.out.println("yup: k: " + k);
        System.out.println("yup: carry: " + carry);
        while (index >= 0) {
            sum = carry;
            sum += num[index--];
            carry = sum / 10;
            intList.add(sum % 10);
        }

        if (carry != 0) {
            while (carry != 0) {
                intList.add(carry % 10);
                carry /= 10;
            }
        }
        return reverseList(intList);
    }

    public static List<Integer> reverseList(List<Integer> list) {
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.set(i, list.get(i) + list.get(j));
            list.set(j, list.get(i) - list.get(j));
            list.set(i, list.get(i) - list.get(j));
            i++;
            j--;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println("yup: it is value: " + addToArrayForm(new int[]{1, 2, 0, 0}, 34));
        System.out.println("yup: it is value: " + addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1));
        System.out.println("yup: it is value: " + addToArrayForm(new int[]{0}, 23));
        System.out.println("yup: it is value: " + addToArrayForm(new int[]{0}, 10000));
        System.out.println("yup: it is value: " + addToArrayForm(new int[]{6}, 809));   //  fails, check it later
    }
}
