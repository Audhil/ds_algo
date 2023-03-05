package _0easy;

import java.util.HashMap;
import java.util.Map;

//  https://www.youtube.com/watch?v=5L9Jrehvoew&ab_channel=CodeLibrary-byYogesh%26Shailesh
public class _CountPairsWithGivenSum_SimilarTwoSum {

  public static int getPairsCount(int[] arr, int k) {
    int ans = 0;
    Map<Integer, Integer> cMap = new HashMap<>();
    for (int num : arr) {
      int b = k - num;
      if (cMap.containsKey(b)) {
        ans += cMap.get(b);
      }
      cMap.put(num, cMap.getOrDefault(num, 0) + 1);
    }
    return ans;
  }


  //  TC : O (n)
  public static int getPairsCountRevision(int[] arr, int k) {
    Map<Integer, Integer> freqMap = new HashMap<>();
    int ans = 0;
    for (int num : arr) {
      int complement = k - num;
      if (freqMap.containsKey(complement)) {
        ans += freqMap.get(complement);
      }
      freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println("yup: " + getPairsCountRevision(new int[]{1, 1, 1, 1}, 2));  //  6 -> ab, bc, cd, da, ac, bd
  }
}
