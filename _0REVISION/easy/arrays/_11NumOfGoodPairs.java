package _0REVISION.easy.arrays;

//  https://leetcode.com/problems/number-of-good-pairs/

import java.util.HashMap;
import java.util.Map;

/*
*   Given an array of integers nums.
    A pair (i,j) is called good if nums[i] == nums[j] and i < j.
    Return the number of good pairs.
* */
public class _11NumOfGoodPairs {

    public static int numIdenticalPairs(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += map.getOrDefault(nums[i], 0);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("yup: no of good pairs : " + numIdenticalPairs(new int[]{1, 1, 1, 1}));
        System.out.println("yup: no of good pairs : " + numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));
    }
}
