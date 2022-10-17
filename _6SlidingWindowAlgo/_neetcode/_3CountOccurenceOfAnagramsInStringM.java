package _6SlidingWindowAlgo._neetcode;

import java.util.HashMap;
import java.util.Map;

//  based on: _3CountOccurenceOfAnagrams.java
public class _3CountOccurenceOfAnagramsInStringM {

  private static int countOfOccurenceOfAnagrams(String str, String pattern) {
    int ans = 0;
    int k = pattern.length();
    int n = str.length();
    //  1. create freq map
    Map<Character, Integer> patternCharCountMap = new HashMap<>(); //  count map
    for (char ch : pattern.toCharArray()) {
      patternCharCountMap.put(ch, patternCharCountMap.getOrDefault(ch, 0) + 1);
    }
    int patternUniqueCharCount = patternCharCountMap.size();  //  helper variable
    //  2. do the calculations, and slide the window if needed
    int l = 0, r = 0;
    while (r < n) {
      char charAtR = str.charAt(r);
      if (patternCharCountMap.containsKey(charAtR)
          && patternCharCountMap.get(charAtR) > 0) {
        patternCharCountMap.put(charAtR, patternCharCountMap.get(charAtR) - 1);
      }
      if (patternCharCountMap.containsKey(charAtR)
          && patternCharCountMap.get(charAtR) == 0) {
        patternUniqueCharCount--;
      }
      //  slide window length NOT reached, increase the window size
      if (r - l + 1 < k) {
        r++;
      }
      //  slide window length reached
      else if (r - l + 1 == k) {
        //  found pattern all chars at given window
        if (patternUniqueCharCount == 0) {
          ans++;
        }
        //  slide the window
        char charAtL = str.charAt(l);
        //  remove the char at l index from the window, update map & count variable accordingly
        if (patternCharCountMap.containsKey(charAtL)) {
          patternCharCountMap.put(charAtL, patternCharCountMap.get(charAtL) + 1);
          patternUniqueCharCount++;
        }
        l++;
        r++;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: _3CountOccurenceOfAnagramsInStringM: " + countOfOccurenceOfAnagrams("aabaabaa",
          "aaba")); //  5 -> 4
                                    //    Explanation : Anagrams of the word aaba - aaba,
                                    //        abaa each appear twice in the text and hence the
                                    //    count is 4.
                                    //  we can use SET and keep track of anagrams encountered; finally size of set is the answer - this is further improvement

    System.out.println(
        "yup: _3CountOccurenceOfAnagramsInStringM: " + countOfOccurenceOfAnagrams("forxxorfxdofr",
            "for"));  //  3
  }
}
