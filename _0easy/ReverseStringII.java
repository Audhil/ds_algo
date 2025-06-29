package _0easy;

//  https://leetcode.com/problems/reverse-string-ii/
/*
*
Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.

If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.



Example 1:

Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Example 2:

Input: s = "abcd", k = 2
Output: "bacd"


Constraints:

1 <= s.length <= 104
s consists of only lowercase English letters.
1 <= k <= 104
* */
public class ReverseStringII {

  //  https://www.youtube.com/watch?v=SUrrSVfk7pk&ab_channel=KnowledgeCenter
  public static String reverseStrClarified(String s, int k) {
    int n = s.length();
    char[] chArr = s.toCharArray();
    int l = 0, r = Math.min(k - 1, n - 1);
    while (l < n) {
      char temp = chArr[l];
      chArr[l] = chArr[r];
      chArr[r] = temp;
      l += 2 * k;
      r = Math.min(l + k - 1, n - 1);
    }
    return new String(chArr);
  }

  public static String reverseStr(String s, int k) {
    if (s == null) {
      return null;
    }

    char[] a = s.toCharArray();
    for (int start = 0; start < a.length; start += 2 * k) {
      int i = start, j = Math.min(start + k - 1, a.length - 1);
      while (i < j) {
        char tmp = a[i];
        a[i++] = a[j];
        a[j--] = tmp;
      }
    }
    return new String(a);
  }

  public static void main(String[] args) {
    System.out.println("yup: jack and jill : " + reverseStr(
        "jackandjillwentupthehilltofetchapailofwater",
        2)); //  yup: jack and jill : ajcknadjlilwnetutpheihllotfecthaapilfowaetr
    System.out.println("yup: " + reverseStr("abcdefg", 2)); //  yup: bacdfeg

    System.out.println("yup: reverseStrClarified: jack and jill : " + reverseStrClarified(
        "jackandjillwentupthehilltofetchapailofwater",
        2)); //  yup: jack and jill : ajcknadjlilwnetutpheihllotfecthaapilfowaetr
    System.out.println(
        "yup: reverseStrClarified: " + reverseStrClarified("abcdefg", 2)); //  yup: bacdfeg
  }
}
