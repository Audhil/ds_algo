package _10Blind75._0Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//  https://leetcode.com/problems/two-sum/
public class _0TwoSumE {

  /*
  * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.
  * */
  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int num1 = nums[i];
      int num2 = target - num1;
      if (map.containsKey(num2)) {
        return new int[]{i, map.get(num2)};
      }
      map.put(nums[i], i);
    }
    return new int[2];
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: 1st : " + Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));  //  yup: 1st : [1, 0]
    System.out.println(
        "yup: 2nd : " + Arrays.toString(twoSum(new int[]{3, 2, 4}, 6))); //  yup: 2nd : [2, 1]
    System.out.println(
        "yup: 3rd : " + Arrays.toString(twoSum(new int[]{3, 3}, 6)));  //  yup: 3rd : [1, 0]
  }
}
