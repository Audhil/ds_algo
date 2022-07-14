package _FrazWorkSheet._0dp._3hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//  https://leetcode.com/problems/word-break-ii/
public class _1WordBreakII {

  //  refer _3WordBreakM.java
  //  explanation: https://www.youtube.com/watch?v=jQJyWcRPEpE&ab_channel=NareshGupta
  public static List<String> wordBreak(String s, List<String> wordDict) {
    List<String> result = new ArrayList<>();
    if (wordDict.contains(s)) {
      result.add(s);
    }
    //  recursive call
    for (int i = 1; i <= s.length(); i++) {
      //  break left part
      String leftPart = s.substring(0, i);
      if (wordDict.contains(leftPart)) {
        //  break right part and get words
        List<String> subList = wordBreak(s.substring(i), wordDict);
        for (String word : subList) {
          result.add(leftPart + " " + word);
        }
      }
    }
    return result;
  }

  //  memoization
  public static List<String> wordBreakWithCache(
      String s,
      List<String> wordDict,
      Map<String, List<String>> mMap) {
    if (mMap.get(s) != null) {
      return mMap.get(s);
    }
    List<String> result = new ArrayList<>();
    if (wordDict.contains(s)) {
      result.add(s);
    }
    //  recursive call
    for (int i = 1; i <= s.length(); i++) {
      //  break left part
      String leftPart = s.substring(0, i);
      if (wordDict.contains(leftPart)) {
        //  break right part and get words
        List<String> subList = wordBreakWithCache(s.substring(i), wordDict, mMap);
        for (String word : subList) {
          result.add(leftPart + " " + word);
        }
      }
    }
    mMap.put(s, result);
    return result;
  }

  /*
  * yup: catsanddog: wordBreakII : [cat sand dog, cats and dog]
    yup: pineapplepenapple: wordBreakII : [pine apple pen apple, pine applepen apple, pineapple pen apple]
    yup: catsandog: wordBreakII : []
    yup: memoization: catsandog: wordBreakII : []
    yup: memoization: pineapplepenapple: wordBreakII : [pine apple pen apple, pine applepen apple, pineapple pen apple]
    * */
  public static void main(String[] args) {
    System.out.println("yup: catsanddog: wordBreakII : " + wordBreak("catsanddog",
        Arrays.asList("cat", "cats", "and", "sand", "dog")));
    System.out.println("yup: pineapplepenapple: wordBreakII : " + wordBreak("pineapplepenapple",
        Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
    System.out.println("yup: catsandog: wordBreakII : " + wordBreak("catsandog",
        Arrays.asList("cats", "dog", "sand", "and", "cat")));
    System.out.println(
        "yup: memoization: catsandog: wordBreakII : " + wordBreakWithCache("catsandog",
            Arrays.asList("cats", "dog", "sand", "and", "cat"), new HashMap<>()));
    System.out.println("yup: memoization: pineapplepenapple: wordBreakII : " + wordBreakWithCache(
        "pineapplepenapple",
        Arrays.asList("apple", "pen", "applepen", "pine", "pineapple"), new HashMap<>()));
  }
}
