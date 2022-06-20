package _10Blind25._1Strings;

//  https://leetcode.com/problems/palindromic-substrings/
//  explanation @ https://www.youtube.com/watch?v=4RACzI5-du8&ab_channel=NeetCode
public class _1PalindromicSubstringsM {

  public static int countSubstrings(String s) {
    int res = 0;
    for (int i = 0; i < s.length(); i++) {
      //  iterate palindromes from odd index -> 1, 3(l + curr char + r), 5, 7 etc
      res += calculatePalindromeLength(i, i, s);
      //  iterate palindromes from even index -> 0, 1, 2, etc
      res += calculatePalindromeLength(i, i + 1, s);
    }
    return res;
  }

  private static int calculatePalindromeLength(int l, int r, String s) {
    int res = 0;
    while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
      res++;
      l -= 1;
      r += 1;
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println("yup: countSubstrings palindromic : " + countSubstrings(
        "aaab"));  //  yup: countSubstrings palindromic : 7 -> a, a, a, b, aaa, aa, aa
  }
}
