package _10Blind75._1Strings.slidingwindow;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//  https://leetcode.com/problems/longest-repeating-character-replacement/
public class _9LongestRepeatingReplacementM {

  public static int characterReplacement(String s, int k) {
    Map<Character, Integer> map = new HashMap<>();
    int l = 0;
    int res = 0;
    for (int r = 0; r < s.length(); r++) {
      map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
      while ((r - l + 1) - Collections.max(map.values()) > k) {
        map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
        l++;
      }
      res = Math.max(res, r - l + 1);
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println("yup: ABAB: " + characterReplacement("ABAB", 2));  //  4
    System.out.println("yup: AABABBA: " + characterReplacement("AABABBA", 1));  //  4
  }
}
