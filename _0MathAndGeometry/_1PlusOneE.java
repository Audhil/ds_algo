package _0MathAndGeometry;

//  https://leetcode.com/problems/plus-one/
//  https://youtu.be/jIaA8boiG1s
public class _1PlusOneE {

  public int[] plusOne(int[] digits) {
    int n = digits.length;
    if (digits[n - 1] < 9) {
      digits[n - 1] += 1;
      return digits;
    } else {
      int j = n - 1;
      while (j > 0 && digits[j] == 9) {
        digits[j--] = 0;
      }
      //  iterated whole array, 999 + 1 = 1000 case, create new array
      if (j < 0) {
        digits = new int[digits.length + 1];
        digits[0] = 1;
      } else {
        digits[j] += 1;
      }
    }
    return digits;
  }
}
