package _0easy;

import java.util.Arrays;

//  https://leetcode.com/problems/reverse-string/
/*
* Write a function that reverses a string. The input string is given as an array of characters s.



Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]


Constraints:

1 <= s.length <= 105
s[i] is a printable ascii character.


Follow up: Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.


* */
public class ReverseString {

    public static void reverseString(char[] s) {
        if (s == null || s.length <= 1) {
            System.out.println("yup : " + Arrays.toString(s));
            return;
        }

        System.out.println("yup: before reversed string in : " + Arrays.toString(s));
        int i = 0, j = s.length - 1;
        while (i < j) {
            char tmp = s[i];
            s[i++] = s[j];
            s[j--] = tmp;
        }

        System.out.println("yup: reversed string in : " + Arrays.toString(s));
    }

    public static void main(String[] args) {
        reverseString("hello".toCharArray());
    }
}
