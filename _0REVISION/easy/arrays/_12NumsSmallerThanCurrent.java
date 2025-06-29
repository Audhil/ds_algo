package _0REVISION.easy.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//  https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
/*
*   Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is,
*   for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
    Return the answer in an array.
*/
public class _12NumsSmallerThanCurrent {

    //  O(n^2)
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        if (nums == null)
            return null;

        int[] res = new int[nums.length];
        int y = 0, count;
        while (y < nums.length) {
            count = 0;
            for (int num : nums) {
                if (nums[y] > num)
                    count++;
            }
            res[y++] = count;
        }
        return res;
    }

    //  O(n log n)
    public static int[] smallerNumbersThanCurrentOptimized(int[] nums) {
        if (nums == null)
            return nums;
        Map<Integer, Integer> map = new HashMap<>();
        int[] temp = nums.clone();
        Arrays.sort(temp);
        for (int i = 0; i < temp.length; i++) {
            if (!map.containsKey(temp[i])) {
                map.put(temp[i], i);
            }
        }
//        System.out.println("yup: map: " + map);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = map.get(nums[i]);
        }
        return nums;
    }

    //  O(n) - https://www.youtube.com/watch?v=eHqwoWiMDfY
    public static int[] smallerNumbersThanCurrentMoreOptimized(int[] nums) {
        if (nums == null)
            return nums;
        int[] arr = new int[101];   //  0 <= nums[i] <= 100 - given in array
        for (int i = 0; i < nums.length; i++)
            arr[nums[i]]++;
        for (int i = 1; i < arr.length; i++)
            arr[i] += arr[i - 1];

        for (int i = 0; i < nums.length; i++) {
            int pos = nums[i];
            if (pos == 0)
                nums[i] = 0;
            else {
                nums[i] = arr[pos - 1];
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println("yup: smallerNumbersThanCurrent: " + Arrays.toString(smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})));
        System.out.println("yup: smallerNumbersThanCurrentOptimized: " + Arrays.toString(smallerNumbersThanCurrentOptimized(new int[]{8, 1, 2, 2, 3})));
        System.out.println("yup: smallerNumbersThanCurrentMoreOptimized: " + Arrays.toString(smallerNumbersThanCurrentMoreOptimized(new int[]{8, 1, 2, 2, 3})));
    }
}
