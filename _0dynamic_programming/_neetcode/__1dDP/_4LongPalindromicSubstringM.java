package _0dynamic_programming._neetcode.__1dDP;

//  https://www.youtube.com/watch?v=_i4Yxeh5ceQ&ab_channel=NeetCode
public class _4LongPalindromicSubstringM {

  //  refer: _2LongestPalindromeSubstringM.java

  //  TC: O (n^2)
  public static String longestPalindrome(String s) {
    int l, r;
    int n = s.length();
    int resLength = 0;
    String res = "";
    for (int i = 0; i < n; i++) {
      //  odd length
      l = i;
      r = i;
      while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
        //  comparing palindrome length
        if (r - l + 1 > resLength) {
          res = s.substring(l, r + 1);
          resLength = r - l + 1;
        }
        l--;
        r++;
      }
      //  even length
      l = i;
      r = i + 1;
      while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
        //  comparing palindrome length
        if (r - l + 1 > resLength) {
          res = s.substring(l, r + 1);
          resLength = r - l + 1;
        }
        l--;
        r++;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println("yup: " + longestPalindrome("babad")); //  bab
    System.out.println("yup: " + longestPalindrome("abbd"));  //  bb
  }
}
