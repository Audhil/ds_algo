package _0medium;

//  https://leetcode.com/problems/sum-of-two-integers/
/*
Given two integers a and b, return the sum of the two integers without using the operators + and -.



Example 1:

Input: a = 1, b = 2
Output: 3
Example 2:

Input: a = 2, b = 3
Output: 5


Constraints:

-1000 <= a, b <= 1000

* */
public class SumOfTwoIntsWithBitwise {
    /*
     * xor = a ^ b
     * carry = a & b
     * if(carry != 0)
     *   carry = xor ^ (carry << 1)
     * else
     *   return xor
     * */

    //  recursive approach
    public static int getSum(int a, int b) {
        int xor = a ^ b;
        int carry = a & b;

        if (carry == 0)
            return xor;
        else
            return getSum(xor, carry << 1);
    }

    //  iterative approach
    public static int getSumm(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println("yup: it is getSum: " + getSum(2, 3));
        System.out.println("yup: it is getSumm: " + getSumm(2, 3));
        System.out.println("yup: it is getSumm: " + getSumm(2, -3));
        System.out.println("yup: it is getSumm: " + getSumm(-2, -3));
    }
}
