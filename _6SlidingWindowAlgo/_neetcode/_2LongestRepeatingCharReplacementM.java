package _6SlidingWindowAlgo._neetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//  https://leetcode.com/problems/longest-repeating-character-replacement/
public class _2LongestRepeatingCharReplacementM {

  //  TC: O (26 * n) - https://youtu.be/gqXU1UyA8pk?t=1009
  //  code explanation: https://youtu.be/gqXU1UyA8pk?t=436
  public static int characterReplacement(String s, int k) {
    int l = 0;
    Map<Character, Integer> freqMap = new HashMap<>();
    int res = Integer.MIN_VALUE;
    for (int r = 0; r < s.length(); r++) {
      char charAtR = s.charAt(r);
      freqMap.put(charAtR, freqMap.getOrDefault(charAtR, 0) + 1);
      //  while window size - maxFreq val is greater than k; move l pointer
      while ((r - l + 1) - Collections.max(freqMap.values()) > k) {
        char charAtL = s.charAt(l);
        freqMap.put(charAtL, freqMap.get(charAtL) - 1);
        l++;
      }
      res = Math.max(res, r - l + 1);
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: _2LongestRepeatingCharReplacementM: " + characterReplacement("ABAB",
            2)); //  yup: _2LongestRepeatingCharReplacementM: 4
    System.out.println(
        "yup: _2LongestRepeatingCharReplacementM: " + characterReplacement("AABABBA",
            1));  //  yup: _2LongestRepeatingCharReplacementM: 4
  }
}
