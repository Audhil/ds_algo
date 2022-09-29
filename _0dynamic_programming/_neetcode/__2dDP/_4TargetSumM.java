package _0dynamic_programming._neetcode.__2dDP;

import java.util.HashMap;
import java.util.Map;

//  https://leetcode.com/problems/target-sum/
//  https://youtu.be/qMky6D6YtXU?t=4218
public class _4TargetSumM {

  //  TC: O (2^n) -> since we've 2 decisions at each node
  //  TC: O (n * t) -> num of items * total sum of the array element from -ve to +ve value for eg.,(-5, 5)
  public static int findTargetSumWays(int[] nums, int target) {
    Map<String, Integer> dpMap = new HashMap<>();
    return dfs(0, 0, nums, target, dpMap);
  }

  private static int dfs(int index,
      int sumSoFar,
      int[] nums,
      int target,
      Map<String, Integer> dpMap) {
    if (index >= nums.length) {
      if (sumSoFar == target) {
        return 1;
      }
      return 0;
    }
    String key = index + "_" + sumSoFar;
    if (dpMap.containsKey(key)) {
      return dpMap.get(key);
    }
    int positiveSum = dfs(index + 1, sumSoFar + nums[index], nums, target, dpMap);
    int negativeSum = dfs(index + 1, sumSoFar - nums[index], nums, target, dpMap);
    dpMap.put(key, positiveSum + negativeSum);
    return dpMap.get(key);
  }

  public static void main(String[] args) {
    System.out.println("yup: targe sum: " + findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));  //  yup: targe sum: 5
    System.out.println("yup: targe sum: " + findTargetSumWays(new int[]{1}, 1));  //  yup: targe sum: 1
  }
}