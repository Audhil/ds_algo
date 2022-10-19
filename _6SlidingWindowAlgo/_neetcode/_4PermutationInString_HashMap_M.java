package _6SlidingWindowAlgo._neetcode;

import java.util.HashMap;
import java.util.Map;

public class _4PermutationInString_HashMap_M {

  //  TC: O (n1 + 26 n1 (n2 - n1)); SC: O (1)
  public static boolean checkInclusion(String s1, String s2) {
    Map<Character, Integer> cMap = new HashMap<>();
    for (char ch : s1.toCharArray()) {
      cMap.put(ch, cMap.getOrDefault(ch, 0) + 1);
    }
    Map<Character, Integer> dMap = new HashMap<>();
    for (int i = 0; i <= s2.length() - s1.length(); i++) {
      dMap.clear();
      for (int j = 0; j < s1.length(); j++) {
        dMap.put(s2.charAt(i + j), dMap.getOrDefault(s2.charAt(i + j), 0) + 1);
      }
      if (matches(cMap, dMap)) {
        return true;
      }
    }
    return false;
  }

  private static boolean matches(Map<Character, Integer> cMap, Map<Character, Integer> dMap) {
    for (char ch : cMap.keySet()) {
      if ((cMap.get(ch) - dMap.getOrDefault(ch, 0)) > 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: permutation in string: " + checkInclusion("hello", "ooolleoooleh")); //  false
    System.out.println(
        "yup: permutation in string: " + checkInclusion("abc", "ccccbbbbaaaa")); //  false
    System.out.println("yup: permutation in string: " + checkInclusion("adc", "dcda"));  //  true
    System.out.println("yup: permutation in string: " + checkInclusion("abc", "bbbca")); //  true
    System.out.println(
        "yup: permutation in string: " + checkInclusion("abc", "cccccbabbbaaaa")); //  true
  }
}
