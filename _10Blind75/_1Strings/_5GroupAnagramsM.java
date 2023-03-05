package _10Blind75._1Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//  https://leetcode.com/problems/group-anagrams/
//  https://www.youtube.com/watch?v=vzdNOK2oB2E&ab_channel=NeetCode
public class _5GroupAnagramsM {

  /*
   * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
   * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
   * typically using all the original letters exactly once.
   * */

  //  TC: O (m * n log n) -> m - no of strs, n - length of each str
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

  //  revision
  //  TC: O (m * n log n); SC: O (n)
  public static List<List<String>> groupAnagramsRevision(String[] strs) {
    Map<String, List<String>> resMap = new HashMap<>();
    for (String str : strs) {
      char[] chArr = str.toCharArray();
      Arrays.sort(chArr);
      String key = String.valueOf(chArr);
      if (!resMap.containsKey(key)) {
        resMap.put(key, new ArrayList<>());
      }
      resMap.get(key).add(str);
    }
    return new ArrayList<>(resMap.values());
  }

  //  TC: O (m * n); SC: O (m)
  public static List<List<String>> groupAnagramsEfficientRevision(String[] strs) {
    Map<String, List<String>> resMap = new HashMap<>();
    for (String str : strs) {
      char[] chars = new char[26];
      for (char ch : str.toCharArray()) {
        chars[ch - 'a']++;
      }
      String key = String.valueOf(chars);
      if (!resMap.containsKey(key)) {
        resMap.put(key, new ArrayList<>());
      }
      resMap.get(key).add(str);
    }
    return new ArrayList<>(resMap.values());
  }

  //  TC: O (m * n)
  public static List<List<String>> groupAnagramsEfficient(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();
    for (String str : strs) {
      int[] arr = new int[26];
      for (char ch : str.toCharArray()) {
        arr[ch - 'a']++;
      }
      String key = Arrays.toString(arr);
      if (!map.containsKey(key)) {
        List<String> list = new ArrayList<>();
        list.add(str);
        map.put(key, list);
      } else {
        map.get(key).add(str);
      }
    }
    return new ArrayList<>(map.values());
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: anagrams: " + groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat",
            "bat"})); //  yup: anagrams: [[eat, tea, ate], [bat], [tan, nat]]
    System.out.println(
        "yup: anagrams: " + groupAnagrams(new String[]{""})); //  yup: anagrams: [[]]
    System.out.println(
        "yup: anagrams: " + groupAnagrams(new String[]{"a"}));  //  yup: anagrams: [[a]]

    System.out.println(
        "yup: groupAnagramsEfficient: " + groupAnagramsEfficientRevision(
            new String[]{"eat", "tea", "tan", "ate", "nat",
                "bat"})); //  yup: anagrams: [[eat, tea, ate], [bat], [tan, nat]]
    System.out.println(
        "yup: groupAnagramsEfficient: " + groupAnagramsEfficientRevision(
            new String[]{""})); //  yup: anagrams: [[]]
    System.out.println(
        "yup: groupAnagramsEfficient: " + groupAnagramsEfficientRevision(
            new String[]{"a"}));  //  yup: anagrams: [[a]]
  }
}
