package _6SlidingWindowAlgo._neetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//  https://www.youtube.com/watch?v=UbyhOgBN834&ab_channel=NeetCode
//  https://leetcode.com/problems/permutation-in-string/
public class _4PermutationInStringM {

  //  Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

  //  TC: O (26) + O (n); SC: O (26 * 2)
  public static boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) {
      return false;
    }
    int[] s1Arr = new int[26];
    int[] s2Arr = new int[26];
    for (int i = 0; i < s1.length(); i++) {
      s1Arr[s1.charAt(i) - 'a']++;
      s2Arr[s2.charAt(i) - 'a']++;
    }
    //  it'll contain tot char matches between s1 & s2 at any given time
    int matches = 0;
    for (int i = 0; i < 26; i++) {
      if (s1Arr[i] == s2Arr[i]) {
        matches++;
      }
    }
    //  sliding window & check matches == 26
    int l = 0;
    for (int r = s1.length(); r < s2.length(); r++) {
      if (matches == 26) {
        return true;
      }
      //  add char at r index
      int index = s2.charAt(r) - 'a';
      s2Arr[index]++;
      if (s1Arr[index] == s2Arr[index]) {
        matches++;
      } else if (s1Arr[index] + 1 == s2Arr[index]) {
        matches--;
      }
      //  remove char at l index
      index = s2.charAt(l) - 'a';
      s2Arr[index]--;
      if (s1Arr[index] == s2Arr[index]) {
        matches++;
      } else if (s1Arr[index] + 1 == s2Arr[index]) {
        matches--;
      }
      l++;
    }
    return matches == 26;
  }

  public static boolean isEmpty(int[] arr1, int[] arr2) {
    System.out.println("yup: arr1: "+ Arrays.toString(arr1));
    System.out.println("yup: arr2: "+ Arrays.toString(arr2));
    for (int i = 0; i < arr1.length; i++) {
      if (arr1[i] != arr2[i]) {
        return false;
      }
    }
    return true;
  }

  public static boolean checkInclusionWorkingFlow(String s1, String s2) {
    if (s2.length() < s1.length()) {
      return false;
    }
    int[] arr = new int[26];
    //add the values to the hash array
    for (int i = 0; i < s1.length(); i++) {
      arr[s1.charAt(i) - 'a']++;
    }
    int i = 0;
    int j = 0;
    //point j to it's position
    for (; j < s1.length(); j++) {
      arr[s2.charAt(j) - 'a']--;
    }
    j--;
    if (isEmpty(arr)) {
      return true;
    }
    while (j < s2.length()) {
      arr[s2.charAt(i) - 'a']++;
      i++;
      j++;
      if (j < s2.length()) {
        arr[s2.charAt(j) - 'a']--;
      }
      if (isEmpty(arr)) {
        return true;
      }
    }
    return isEmpty(arr);
  }

  public static boolean isEmpty(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
//    System.out.println(
//        "yup: permutation in string: " + checkInclusion("hello", "ooolleoooleh")); //  false
//    System.out.println(
//        "yup: permutation in string: " + checkInclusion("abc", "ccccbbbbaaaa")); //  false
//    System.out.println("yup: permutation in string: " + checkInclusion("adc", "dcda"));  //  true
//    System.out.println("yup: permutation in string: " + checkInclusion("abc", "bbbca")); //  true
    System.out.println(
        "yup: permutation in string: " + checkInclusion("abc", "cccccbabbbaaaa")); //  true
  }
}
