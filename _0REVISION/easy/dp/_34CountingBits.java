package _0REVISION.easy.dp;

import java.util.Arrays;

//  https://leetcode.com/problems/counting-bits/
/*
*
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

Example 1:

Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10
Example 2:

Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
* */
public class _34CountingBits {

    /*
    * expln
    *   0 -> 0 -> 0
        1 -> 1 -> 1
        2 -> 10 -> 1
        3 -> 11 -> 2 we can right shift 1 to get 1, and check 3 % 2 = 1, so we have 1 + 1 = 2 ones
        4 -> 100 -> 1 we can right shift 1 to get 10, and check 4 % 2 = 0, so we have 1 + 0 = 1 ones
    * */
    public static int[] countBits(int n) {
        int[] bits = new int[n + 1];
        bits[0] = 0;
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i >> 1] + (i % 2);
        }
        return bits;
    }

    public static void main(String[] args) {
        System.out.println("yup: countBits: " + Arrays.toString(countBits(5))); //  yup: countBits: [0, 1, 1, 2, 1, 2]
        System.out.println("yup: countBits: " + Arrays.toString(countBits(9))); //  yup: countBits: [0, 1, 1, 2, 1, 2, 2, 3, 1, 2]
    }
}
