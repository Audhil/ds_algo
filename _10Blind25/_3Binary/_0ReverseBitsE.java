package _10Blind25._3Binary;


//  good explanation: https://www.youtube.com/watch?v=-5z9dimxxmI&ab_channel=CodeAndCoffee
//  https://leetcode.com/problems/reverse-bits/submissions/
public class _0ReverseBitsE {

  //  1. initialise res = 0 (8 bit, 16 bit or 32 bit or 64 bit)
  //  2. left shift res by 1
  //  3. right shift input by 1
  //  if the last bit of input is 1, make the res last bit as 1
  //  4. keep on shifting upto the given bit size(8, 16, 32 etc)

  // you need treat n as an unsigned value
  public int reverseBits(int n) {
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
}
