package _6SlidingWindowAlgo._neetcode;

import java.util.HashSet;
import java.util.Set;

//  https://www.youtube.com/watch?v=wiGpQwVHdE0&ab_channel=NeetCode
//  https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class _1LongestSubstringWithoutDuplicatesM {

  //  TC: O (n); SC: O (n)
  public static int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<>();
    int l = 0;
    int maxLength = 0;
    for (int r = 0; r < s.length(); r++) {
      while (set.contains(s.charAt(r))) {
        set.remove(s.charAt(l++));
      }
      set.add(s.charAt(r));
      maxLength = Math.max(maxLength, r - l + 1);
    }
    return maxLength;
  }

  public static int lengthOfLongestSubstringRevision(String str) {
    Set<Character> set = new HashSet<>();
    int maxLength = Integer.MIN_VALUE;
    int l = 0;
    for (int r = 0; r < str.length(); r++) {
      while (set.contains(str.charAt(r))){
        set.remove(str.charAt(l++));
      }
      set.add(str.charAt(r));
      maxLength = Math.max(maxLength, r - l +1);
    }
    return maxLength;
  }

  public static void main(String[] args) {
    System.out.println("yup: longestSubstring: " + lengthOfLongestSubstring("abcabcbb")); //  3
    System.out.println("yup: longestSubstring: " + lengthOfLongestSubstring("bbbbb"));  //  1
    System.out.println("yup: longestSubstring: " + lengthOfLongestSubstring("pwwkew")); //  3

    System.out.println("yup: lengthOfLongestSubstringRevision: " + lengthOfLongestSubstringRevision("abcabcbb")); //  3
    System.out.println("yup: lengthOfLongestSubstringRevision: " + lengthOfLongestSubstringRevision("bbbbb"));  //  1
    System.out.println("yup: lengthOfLongestSubstringRevision: " + lengthOfLongestSubstringRevision("pwwkew")); //  3
  }
}
