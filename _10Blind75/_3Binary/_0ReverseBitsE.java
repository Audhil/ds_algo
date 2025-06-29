package _10Blind75._3Binary;


//  good explanation: https://youtu.be/-5z9dimxxmI?t=110
//  https://leetcode.com/problems/reverse-bits/submissions/
public class _0ReverseBitsE {

  //  1. initialise res = 0 (8 bit, 16 bit or 32 bit or 64 bit)
  //  2. left shift res by 1
  //  3. right shift input by 1
  //  if the last bit of input is 1, increase the res value by 1
  //  4. keep on shifting upto the given bit size(8, 16, 32 etc)

  // you need treat n as an unsigned value
  public static int reverseBits(int n) {
    int res = 0;
    for (int i = 0; i < 32; i++) {
      //  1. left shift res by 1
      res <<= 1;
      //  3. find last bit of input is 1 or not, if it is 1, increment result
      if ((n & 1) > 0) {
        res += 1;
      }
      //  2. right shift the input
      n >>= 1;
    }
    return res;
  }

  public static int revision(int n) {
    int result = 0;
    for (int i = 31; i >= 0; i--) {
      //  1. left shift result
      result <<= 1;
      //  2. check is it 1 in the number
      if ((n & 1) == 1) {
        result |= 1;  //  result += 1;
      }
      //  3. right shift result
      n >>= 1;
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println("yup: reversedBits : " + reverseBits(3));
    System.out.println("yup: reversedBits : " + revision(3));
  }
}
