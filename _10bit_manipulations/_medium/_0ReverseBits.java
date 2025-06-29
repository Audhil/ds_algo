package _10bit_manipulations._medium;

//  https://www.interviewbit.com/problems/reverse-bits/
/*
* Problem Description

Reverse the bits of an 32 bit unsigned integer A.



Problem Constraints
0 <= A <= 2^32



Input Format
First and only argument of input contains an integer A.



Output Format
Return a single unsigned integer denoting the decimal value of reversed bits.*/
public class _0ReverseBits {

    public static long reverse(long n) {
        long res = 0;
        for (int i = 0; i < 4; i++) {
            res <<= 1;
            if ((n & 1) > 0) {
                res++;
            }
            n >>= 1;
        }
        return res;
    }

    //  logic is correct, but leading zeros are making issues
    public static int reverseWithBitwise(int n) {
        int mask = 0b11111111111111110000000000000000;
        int temp = n & mask;
        temp >>>= 16;
        int mask2 = 0b00000000000000001111111111111111;
        int temp2 = n & mask2;
        temp2 <<= 16;
        int mask3 = 0b1111111100000000;
        int t = temp & mask3;
        t >>>= 8;
        int mask4 = 0b0000000011111111;
        int t2 = temp & mask4;
        t2 <<= 8;
        temp = t | t2;

        int t3 = temp2 & mask3;
        t3 >>>= 8;
        int t4 = temp2 & mask4;
        t4 <<= 8;
        temp2 = t3 | t4;

        int res = temp | temp2;
        System.out.println("yup: Integer.toBinaryString(res): " + Integer.toBinaryString(res));
        return res;
    }

    public static void main(String[] args) {
//        System.out.println("yup: reverse: " + reverse(0b0011));
        System.out.println("yup: reverseWithBitwise: " + reverseWithBitwise(0b10101010101010100000000000000111));
//        System.out.println("yup: reverseWithBitwise: " + reverseWithBitwise(0b11111111111111110000000000000000));
    }
}
