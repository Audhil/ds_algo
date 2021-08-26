package _0REVISION.easy.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//  https://leetcode.com/problems/two-sum/
/*
* Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
* */
public class _0TwoSums {

    public static int[] twoSum(int[] nums, int target) {
        if (nums == null)
            return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])
                    && map.get(target - nums[i]) != i) {    //  not the same item
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println("yup: indices: " + Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println("yup: indices: " + Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println("yup: indices: " + Arrays.toString(twoSum(new int[]{3, 3}, 6)));
    }
}
