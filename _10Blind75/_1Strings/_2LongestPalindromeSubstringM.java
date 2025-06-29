package _10Blind75._1Strings;

//  https://leetcode.com/problems/longest-palindromic-substring/
public class _2LongestPalindromeSubstringM {

  //  TC: O (n^2) - https://youtu.be/_i4Yxeh5ceQ?t=3770
  public static String longestPalindrome(String s) {
    String res = null;
    int resLen = 0;
    for (int i = 0; i < s.length(); i++) {
      //  left side palindrome - odd length
      int l = i;
      int r = i;
      while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
        if (r - l + 1 > resLen) {
          res = s.substring(l, r + 1);
          resLen = r - l + 1;
        }
        l -= 1;
        r += 1;
      }
      //  right side palindrome - even length
      l = i;
      r = i + 1;
      while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
        if (r - l + 1 > resLen) {
          res = s.substring(l, r + 1);
          resLen = r - l + 1;
        }
        l -= 1;
        r += 1;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println("yup: longest palindrome substring: " + longestPalindrome(
        "babad")); //  yup: longest palindrome substring: bab or aba
    System.out.println("yup: longest palindrome substring: " + longestPalindrome(
        "cbba")); //  yup: longest palindrome substring: bb
  }
}
