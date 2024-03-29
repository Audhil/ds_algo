package _10Blind75._1Strings;

//  https://leetcode.com/problems/valid-palindrome/
public class _3ValidPalindromeE {

  public static boolean isPalindrome(String s) {
    int l = 0, r = s.length() - 1;
    while (l < r) {
      while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
        l++;
      }
      while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
        r--;
      }
      if (l < r) {
        if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
          return false;
        }
        l++;
        r--;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: isPlaindrome(): " + isPalindrome("A man, a plan, a canal: Panama"));  //  true
    System.out.println(
        "yup: isPlaindrome(): " + isPalindromeRevision("A man, a plan, a canal: Panama"));  //  true
  }

  private static boolean isPalindromeRevision(String input) {
    int l = 0, r = input.length() - 1;
    while (l < r) {
      while (l < r && !Character.isLetterOrDigit(input.charAt(l))) {
        l++;
      }
      while (l < r && !Character.isLetterOrDigit(input.charAt(r))) {
        r--;
      }
      if (l < r) {
        if (Character.toLowerCase(input.charAt(l)) != Character.toLowerCase(input.charAt(r))) {
          return false;
        }
        l++;
        r--;
      }
    }
    return true;
  }
}
