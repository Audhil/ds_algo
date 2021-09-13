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

    public static void main(String[] args) {
        System.out.println("yup: " + reverse(0b0011));
    }
}
