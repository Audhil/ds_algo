package _00Arrays;

import java.util.Arrays;

//  https://www.geeksforgeeks.org/segregate-0s-and-1s-in-an-array-by-traversing-array-once/
public class _11Segregate0sAnd1sInArrayE {

  //  TC: O (n); SC: O (1)
  private static int[] segregateWithPointerTechnique(int[] nums) {
    int l = 0, r = nums.length - 1;
    while (l < r) {
      while (nums[l] == 0 && l < r) {
        l++;
      }
      while (nums[r] == 1 && l < r) {
        r--;
      }
      if (l < r) {
        swap(nums, l, r);
        l++;
        r--;
      }
    }
    return nums;
  }

  private static void swap(int[] nums, int l, int r) {
    nums[l] += nums[r];
    nums[r] = nums[l] - nums[r];
    nums[l] = nums[l] - nums[r];
  }

  //  TC: O (n); SC: O (1)
  private static int[] segregateWithCounterTechnique(int[] nums) {
    int cnt0 = 0;
    for (int num : nums) {
      if (num == 0) {
        cnt0++;
      }
    }
    //  fill with 0's and 1's
    int i = 0;
    while (cnt0-- > 0) {
      nums[i++] = 0;
    }
    for (int j = i; j < nums.length; j++) {
      nums[j] = 1;
    }
    return nums;
  }

  public static void main(String[] args) {
    System.out.println("yup: segregated array: " + Arrays.toString(
        segregateWithCounterTechnique(new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1,
            0})));  //  yup: segregated array: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1]

    System.out.println("yup: segregated array: " + Arrays.toString(
        segregateWithPointerTechnique(new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1,
            0})));  //  yup: segregated array: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1]
  }
}
