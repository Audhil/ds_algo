package _0easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//  https://leetcode.com/problems/two-sum/solution/
/*
* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
*
* Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].
*
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
*
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]



* */
public class TwoSum {

  //  effective solution
  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement) && map.get(complement) != i) {
        return new int[]{map.get(complement), i};
      }
      map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution!");
  }


  public static int[] twoSumRevision(int[] nums, int target) {
    Map<Integer, Integer> numIndexMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (numIndexMap.containsKey(complement) && numIndexMap.get(complement) != i) {
        return new int[]{numIndexMap.get(complement), i};
      }
      numIndexMap.put(nums[i], i);
    }
    throw new Error("Something went wrong!");
  }

//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], i);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            int complement = target - nums[i];
//            if (map.containsKey(complement) && map.get(complement) != i) {
//                return new int[] { i, map.get(complement) };
//            }
//        }
//        throw new IllegalArgumentException("No two sum solution");
//    }

  //  brute fore
//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[j] == target - nums[i]) {
//                    return new int[] { i, j };
//                }
//            }
//        }
//        throw new IllegalArgumentException("No two sum solution");
//    }

  public static void main(String[] args) {
    System.out.println("yup: " + Arrays.toString(twoSumRevision(new int[]{2, 1, 5, 3}, 3)));  //  yup: [0, 1]
  }
}
