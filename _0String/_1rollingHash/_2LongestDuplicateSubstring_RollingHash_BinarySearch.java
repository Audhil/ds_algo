package _0String._1rollingHash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//  https://leetcode.com/problems/longest-duplicate-substring/
//  https://youtu.be/FQ8hcOOzQMU
public class _2LongestDuplicateSubstring_RollingHash_BinarySearch {

  //  not working at all
  private static final int base = 26;
  private static final int p = (int) (1E7 + 7);  //  large prime number

  //  TC: O (log n * n * log n) -> (BinSearch * sliding window * map insertion & search)
  public static String longestDupSubstring(String s) {
    int len = s.length();
    if (len == 0) {
      return "";
    }
    //  roll arr
    int[] rollArr = new int[len];
    rollArr[0] = 1; //  26^0 is 1
    for (int i = 1; i < len; i++) {
      rollArr[i] = (rollArr[i - 1] * base) % p;
    }
    //  binary search
    int low = 1, high = len, mid;
    String ans = "";
    String[] temp = {""}; //  passing by reference
    while (low <= high) {
      temp[0] = "";
      mid = low + (high - low) / 2;
      boolean isMatched = match(s, len, mid, temp, rollArr);
      if (isMatched) {
        if (temp[0].length() > ans.length()) {
          ans = temp[0];
        }
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return ans;
  }

  private static boolean match(String s, int len, int size, String[] ans, int[] rollArr) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    int hash = 0;
    for (int i = 0; i < size; i++) {
      hash *= base;
      hash += (s.charAt(i) - 'a' + 1) % p;
    }
    List<Integer> list = new ArrayList<>();
    list.add(0);
    map.put(hash, list);
    //  rolling hash - sliding window
    for (int j = size; j < len; j++) {
//      hash -= ((s.charAt(j) - 'a' + 1) * (int) (Math.pow(base, size - 1)));
//      //  making a^1 -> a^2
//      hash *= base;
//      //  even txtHash += (text.charAt(i + M) - 'A' + 1); works fine
//      hash += (s.charAt(j + size) - 'a' + 1) % p;
      hash = ((hash - rollArr[size - 1] * (s.charAt(j - size) - 'a')) % p + p) % p;
      hash = (hash * base + (s.charAt(j) - 'a')) % p;

      if (map.containsKey(hash)) {
        for (int startIndex : map.get(hash)) {
          String temp = s.substring(startIndex, size);
          String curr = s.substring(j - size + 1, size);
          if (temp.equals(curr)) {
            ans[0] = temp;
            return true;
          }
        }
      }
      List<Integer> tempList = new ArrayList<>();
      tempList.add(j - size + 1);
      map.put(hash, tempList);
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println("yup: longest duplicate substring: " + longestDupSubstring("banana"));
    System.out.println("yup: longest duplicate substring: " + longestDupSubstring("abcd"));
  }
}
