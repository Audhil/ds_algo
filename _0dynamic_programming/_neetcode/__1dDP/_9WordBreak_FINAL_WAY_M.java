package _0dynamic_programming._neetcode.__1dDP;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//  https://youtu.be/_i4Yxeh5ceQ?t=7908
public class _9WordBreak_FINAL_WAY_M {

  //  BOTTOM-UP approach
  //  iterating from last index
  //  TC: O (n)
  public static boolean wordBreak(String s, List<String> wordDict) {
    int strLen = s.length();
    boolean[] dp = new boolean[strLen + 1];
    dp[strLen] = true;  //  base case
    Set<String> wordSet = new HashSet<>(wordDict);
    for (int i = strLen; i >= 0; i--) {
      for (String word : wordSet) {
        int wordLen = word.length();
        if ((i + wordLen) <= strLen
            && s.substring(i, i + wordLen).startsWith(word)) {
          dp[i] = dp[i + wordLen];  //  https://youtu.be/_i4Yxeh5ceQ?t=8592
        }
        //  comparing 1 time is enough
        if (dp[i]) {
          break;
        }
      }
    }
    return dp[0];
  }

  public static void main(String[] args) {
    System.out.println(
        "wordBreak: " + wordBreak("jackandjill", Arrays.asList("jack", "jill", "and")));  //  true
  }
}
