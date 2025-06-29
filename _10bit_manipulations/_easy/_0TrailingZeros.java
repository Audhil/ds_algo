package _10bit_manipulations._easy;

//  https://www.interviewbit.com/problems/trailing-zeroes/
/*
* Given an integer A, count and return the number of trailing zeroes.
* Example Input
Input 1:

 A = 18
Input 2:

 A = 8


Example Output
Output 1:

 1
Output 2:

 3


Example Explanation
Explanation 1:

 18 in binary is represented as: 10010, there is 1 trailing zero.
Explanation 2:

 8 in binary is represented as: 1000, there are 3 trailing zeroes.
*/
public class _0TrailingZeros {

    public static int solve(int A) {
        String bit = Integer.toBinaryString(A);
        System.out.println("yup: bin of A: " + A + " is bit: " + bit);
        int rPtr = bit.length() - 1, zero = 0;

        while (rPtr >= 0) {
            if (bit.charAt(rPtr) != '0')
                break;
            zero++;
            rPtr--;
        }
        return zero;
    }

    public static void main(String[] args) {
        System.out.println("yup: _0TrailingZeros: " + solve(6));
        System.out.println("yup: _0TrailingZeros: " + solve(12));
        /*
        *   yup: bin of A: 6 is bit: 110
            yup: _0TrailingZeros: 1
            yup: bin of A: 12 is bit: 1100
            yup: _0TrailingZeros: 2
*       */
    }
}
