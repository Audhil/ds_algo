package _00Arrays;

import java.util.Arrays;

//  https://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
public class _10SortArrOf0s1s2s_DutchNationalFlagProblem {

  //  Using pointer technique - TC: O (n); SC: O (1)
  private static int[] sortArrWithPointerTechnique(int[] nums) {
    int l = 0, mid = 0, r = nums.length - 1;
    while (mid <= r) {
      if (nums[mid] == 0) {
        swap(nums, mid, l);
        l += 1;
        mid += 1;
      }
      //  don't do, just increment mid pointer
      else if (nums[mid] == 1) {
        mid += 1;
      }
      //  if nums[i] == 2
      else {
        swap(nums, mid, r);
        r -= 1;
      }
    }
    return nums;
  }

  private static void swap(int[] nums, int indexA, int indexB) {
    nums[indexA] += nums[indexB];
    nums[indexB] = nums[indexA] - nums[indexB];
    nums[indexA] = nums[indexA] - nums[indexB];
  }

  //  Using counter technique - TC: O (n); SC: O (1)
  private static int[] sortArrWithCounterTechnique(int[] nums) {
    int cnt0 = 0, cnt1 = 0, cnt2 = 0;
    for (int num : nums) {
      if (num == 0) {
        cnt0++;
      } else if (num == 1) {
        cnt1++;
      } else {
        cnt2++;
      }
    }

    int i = 0;
    while (cnt0-- > 0) {
      nums[i++] = 0;
    }
    while (cnt1-- > 0) {
      nums[i++] = 1;
    }
    while (cnt2-- > 0) {
      nums[i++] = 2;
    }
    return nums;
  }

  public static void main(String[] args) {
    System.out.println("yup: sort array with 0's, 1's, 2's : " + Arrays.toString(
        sortArrWithPointerTechnique(
            new int[]{0, 1, 2, 0, 1,
                2}))); //  yup: sort array with 0's, 1's, 2's : [0, 0, 1, 1, 2, 2]
    System.out.println("yup: sort array with 0's, 1's, 2's : " + Arrays.toString(
        sortArrWithPointerTechnique(
            new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0,
                1}))); //  yup: sort array with 0's, 1's, 2's : [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]

    System.out.println("yup: sort array with 0's, 1's, 2's : " + Arrays.toString(
        sortArrWithCounterTechnique(
            new int[]{0, 1, 2, 0, 1,
                2}))); //  yup: sort array with 0's, 1's, 2's : [0, 0, 1, 1, 2, 2]
    System.out.println("yup: sort array with 0's, 1's, 2's : " + Arrays.toString(
        sortArrWithCounterTechnique(
            new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0,
                1}))); //  yup: sort array with 0's, 1's, 2's : [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
  }
}
