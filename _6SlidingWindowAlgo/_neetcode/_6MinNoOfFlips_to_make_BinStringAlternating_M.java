package _6SlidingWindowAlgo._neetcode;

//  https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/
public class _6MinNoOfFlips_to_make_BinStringAlternating_M {

  public static int minFlips(String s) {
    int n = s.length();
    s += s;
    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (i % 2 == 0) {
        sb1.append("1");
        sb2.append("0");
      } else {
        sb1.append("0");
        sb2.append("1");
      }
    }
    String alt1 = sb1.toString();
    String alt2 = sb2.toString();
    int minFlips = Integer.MAX_VALUE;
    int diff1 = 0, diff2 = 0;
    int l = 0;
    for (int r = 0; r < s.length(); r++) {
      if (s.charAt(r) != alt1.charAt(r)) {
        diff1++;
      }
      if (s.charAt(r) != alt2.charAt(r)) {
        diff2++;
      }
      //  slide the window
      if (r - l + 1 > n) {
        if (s.charAt(l) != alt1.charAt(l)) {
          diff1--;
        }
        if (s.charAt(l) != alt2.charAt(l)) {
          diff2--;
        }
        l++;
      }
      if (r - l + 1 == n) {
        minFlips = Math.min(minFlips, Math.min(diff1, diff2));
      }
    }
    return minFlips;
  }

  public static void main(String[] args) {
    System.out.println("yup: minflips to make alternating string: " + minFlips(
        "111000"));  //  yup: minflips to make alternating string: 2
    System.out.println("yup: minflips to make alternating string: " + minFlips(
        "010")); //  yup: minflips to make alternating string: 0
    System.out.println("yup: minflips to make alternating string: " + minFlips(
        "1110"));  //  yup: minflips to make alternating string: 1
  }
}
