package _00Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//  https://leetcode.com/problems/first-missing-positive/
public class _6FirstMissingPositiveNumH {

  //  https://www.youtube.com/watch?v=8g78yfzMlao&ab_channel=NeetCode
  //  TC: O (n log n)
  public static int firstMissingPositive(int[] nums) {
    Arrays.sort(nums);
    int smallestPositiveNum = 1;

    for (int num : nums) {
      if (num <= 0) {
        continue;
      }
      if (num == smallestPositiveNum) {
        smallestPositiveNum++;
      }
    }
    return smallestPositiveNum;
  }

  //  https://www.youtube.com/watch?v=8g78yfzMlao&ab_channel=NeetCode
  //  TC: O (n), SC: O (n) - using set
  public static int firstMissingPositiveOptimized(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    for (int smallestPositiveNum = 1; smallestPositiveNum < nums.length + 1;
        smallestPositiveNum++) {
      if (!set.contains(smallestPositiveNum)) {
        return smallestPositiveNum;
      }
    }
    return nums.length + 1;
  }

  //  https://www.youtube.com/watch?v=QeBvfH1dpOU&ab_channel=Pepcoding
  //  TC: O (n), SC: O (1)
  public static int firstMissingPositiveEfficient(int[] nums) {
    //  1. mark out of bound items to '1', and keep an eye on '1' exists in the array
    int range = nums.length;
    boolean isOnePresent = false;
    for (int i = 0; i < range; i++) {
      if (nums[i] == 1) {
        isOnePresent = true;
      }
      //  if the element is out of range, ignore them. make them as '1'
      if (nums[i] > range || nums[i] < 1) {
        nums[i] = 1;
      }
    }
    //  if one is not present in the given arr, it is the smallestPositive number as whole world know
    if (!isOnePresent) {
      return 1;
    }
    //  2.  mark the elements with the index
    for (int i = 0; i < range; i++) {
      int index = Math.abs(nums[i]);
      nums[index - 1] = -Math.abs(nums[index - 1]);
    }
    //  3. iterate the array and find the missing number
    for (int i = 0; i < range; i++) {
      if (nums[i] > 0) {
        return i + 1;
      }
    }
    return range + 1;
  }

  public static void main(String[] args) {
    System.out.println("yup: 1,2,0: " + firstMissingPositiveEfficient(new int[]{1, 2, 0})); //  3
    System.out.println(
        "yup: 3,4,-1,1: " + firstMissingPositiveEfficient(new int[]{3, 4, -1, 1}));  //  2
    System.out.println(
        "yup: 7,8,9,11,12: " + firstMissingPositiveEfficient(new int[]{7, 8, 9, 11, 12}));  //  1
  }
}
