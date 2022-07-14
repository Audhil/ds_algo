package _FrazWorkSheet._0dp._2medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//  https://leetcode.com/problems/word-break/
public class _3WordBreakM {

  //  this, test case fails. wordBreak("cars", Arrays.asList("car", "ca", "rs")); //  yup: cars: wordBreak: false
  public static boolean wordBreak(String s, List<String> wordDict) {
    for (String word : wordDict) {
      s = s.replace(word, "");
    }
    return s.isEmpty();
  }

  //  TOP-DOWN approach - dp
  private static boolean help(int index, String s, List<String> wordDict,
      Map<Integer, Boolean> mMap) {
    //  we fragmented whole string
    if (index == s.length()) {
      return true;
    }
    if (mMap.get(index) != null) {
      return mMap.get(index);
    }
    StringBuilder temp = new StringBuilder();
    for (int i = index; i < s.length(); i++) {
      temp.append(s.charAt(i));
      if (wordDict.contains(temp.toString())) {
        if (help(i + 1, s, wordDict, mMap)) {
          mMap.put(index, true);
          return true;
        }
      }
    }
    return false;
  }

  //  https://youtu.be/_iIK7Gu7MNo?t=334
  public static boolean wordBreak1(String s, List<String> wordDict) {
    return help(0, s, wordDict, new HashMap<>());
  }

  private static boolean help2(String s, List<String> wordDict, int[] dp) {
    int n = s.length();
    for (int i = n - 1; i >= 0; i--) {
      StringBuilder temp = new StringBuilder();
      for (int j = i; j < n; j++) {
        temp.append(s.charAt(j));
        if (wordDict.contains(temp.toString())) {
          dp[i] = dp[j + 1];
        }
      }
      dp[i] = 0;
    }
    return dp[0] == 1;
  }

  //  BOTTOM-UP approach - dp
  public static boolean wordBreak2(String s, List<String> wordDict) {
    int[] dp = new int[301];  //  constraint given in question
    return help2(s, wordDict, dp);
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: leetcode: wordBreak: " + wordBreak("leetcode", Arrays.asList("leet", "code")));
    System.out.println(
        "yup: applepenapple: wordBreak: " + wordBreak("applepenapple",
            Arrays.asList("apple", "pen")));

    System.out.println("yup: TOP-DOWN : catsandog: wordBreak1: " + wordBreak1("catsandog",
        Arrays.asList("cats", "dog", "sand", "and", "cat")));
    System.out.println(
        "yup: TOP-DOWN : cars: wordBreak1: " + wordBreak1("cars",
            Arrays.asList("car", "ca", "rs")));
    System.out.println("yup: BOTTOM-UP : catsandog: wordBreak1: " + wordBreak2("catsandog",
        Arrays.asList("cats", "dog", "sand", "and", "cat")));
    System.out.println(
        "yup: BOTTOM-UP : cars: wordBreak2: " + wordBreak2("cars",
            Arrays.asList("car", "ca", "rs")));
  }
}
