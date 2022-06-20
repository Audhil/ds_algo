package _10Blind25._1Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//  https://leetcode.com/problems/group-anagrams/
//  https://www.youtube.com/watch?v=vzdNOK2oB2E&ab_channel=NeetCode
public class _5GroupAnagramsM {

  //  TC: O (m * n) -> m - no of strs, n - length of each str
  public static List<List<String>> groupAnagrams(String[] strs) {
    if (strs == null || strs.length == 0) {
      return new ArrayList<>();
    }

    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String key = String.valueOf(chars);
      if (!map.containsKey(key)) {
        map.put(key, new ArrayList<>());
      }
      map.get(key).add(str);
    }
    return new ArrayList<>(map.values());
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: anagrams: " + groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    System.out.println(
        "yup: anagrams: " + groupAnagrams(new String[]{""}));
    System.out.println(
        "yup: anagrams: " + groupAnagrams(new String[]{"a"}));
  }
}
