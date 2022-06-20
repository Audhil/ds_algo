package _10Blind25._1Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//  https://leetcode.com/problems/valid-anagram/
public class _6ValidAnagramE {

  //  TC: O (n), SC: O (n)
  public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }

    Map<Character, Integer> mapOfS = new HashMap<>();
    Map<Character, Integer> mapOfT = new HashMap<>();
    for (char ch : s.toCharArray()) {
      mapOfS.put(ch, mapOfS.getOrDefault(ch, 0) + 1);
    }
    for (char ch : t.toCharArray()) {
      mapOfT.put(ch, mapOfT.getOrDefault(ch, 0) + 1);
    }
    for (char key : mapOfS.keySet()) {
      if (mapOfS.get(key) != mapOfT.getOrDefault(key, 0)) {
        return false;
      }
    }
    return true;
  }

  //  TC: O n log n, SC: O (1) (some sorting algorithms take O (n) space)
  public static boolean isAnagramEfficientSoln(String s, String t) {
    char[] chars = s.toCharArray();
    Arrays.sort(chars);
    s = String.valueOf(chars);
    chars = t.toCharArray();
    Arrays.sort(chars);
    t = String.valueOf(chars);
    return s.equals(t);
  }

  public static void main(String[] args) {
    System.out.println("yup: is Anagram: " + isAnagram("anagram", "nagaram"));  //  true
    System.out.println("yup: is Anagram: " + isAnagram("rat", "car"));  //  false

    System.out.println("yup: is isAnagramEfficientSoln: " + isAnagramEfficientSoln("anagram", "nagaram"));  //  true
    System.out.println("yup: is isAnagramEfficientSoln: " + isAnagramEfficientSoln("rat", "car"));  //  false
  }
}
