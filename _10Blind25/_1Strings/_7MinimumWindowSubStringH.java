package _10Blind25._1Strings;

import java.util.HashMap;
import java.util.Map;

//  best sliding window!
//  https://leetcode.com/problems/minimum-window-substring/
//  best explanation: https://www.youtube.com/watch?v=iwv1llyN6mo&ab_channel=AdityaVerma
public class _7MinimumWindowSubStringH {

  //  code based on https://www.youtube.com/watch?v=jSto0O4AJbM&ab_channel=NeetCode
  public String minWindow(String s, String t) {
    if (s.length() < t.length() || t.equals("")) {
      return "";
    }

    Map<Character, Integer> countMap = new HashMap<>();
    Map<Character, Integer> windowMap = new HashMap<>();

    for (char ch : t.toCharArray()) {
      countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
    }

    int have = 0, need = countMap.size();
    for (char ch : s.toCharArray()) {
      windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);
      if (countMap.containsKey(ch) && windowMap.get(ch).equals(countMap.get(ch))) {
        have++;
      }
      while (have == need){

      }
    }

    return "";
  }
}
