package _10Blind75._1Strings.slidingwindow;

import java.util.HashSet;
import java.util.Set;

//  https://www.youtube.com/watch?v=wiGpQwVHdE0&ab_channel=NeetCode
//  https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class _8LongestSubstringWithoutRepeatingCharsM {

  //  solving with Sliding window
  public static int lengthOfLongestSubstring(String s) {
    int l = 0;
    Set<Character> set = new HashSet<>();
    int result = 0;
    for (int r = 0; r < s.length(); r++) {
      while (set.contains(s.charAt(r))) {
        set.remove(s.charAt(l++));  //  remove char at l
      }
      set.add(s.charAt(r));
      result = Math.max(result, r - l + 1);
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println("yup: abcabcbb: " + lengthOfLongestSubstring("abcabcbb")); //  3 - "abc"
    System.out.println("yup: bbbbb: " + lengthOfLongestSubstring("bbbbb")); //  1 - "b"
    System.out.println("yup: pwwkew: " + lengthOfLongestSubstring("pwwkew")); //  3 - "wke"
  }
}
