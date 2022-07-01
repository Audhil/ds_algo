package basicToACE._0Greedy;

import java.util.Arrays;

//  https://youtu.be/qdFUpU7sdRs?t=6119
public class _1MinAbsDiffBetweenAnyTwoElement {

  //  TC : O (n log n) -> due to sorting
  private static int minDiffWithSorting(int[] nums) {
    Arrays.sort(nums);
    int minDiff = Integer.MAX_VALUE;
    for (int i = 1; i < nums.length; i++) {
      minDiff = Math.min(minDiff, nums[i] - nums[i - 1]);
    }
    return minDiff;
  }

  //  TC: O (n)  -> not sorting items
  private static int minDiff(int[] nums) {
    int minDiff = Integer.MAX_VALUE;
    for (int i = 1; i < nums.length; i++) {
      minDiff = Math.min(minDiff, Math.abs(nums[i] - nums[i - 1]));
    }
    return minDiff;
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: minDiffWithSorting: " + minDiffWithSorting(new int[]{99, 3, 77, 1, 9, 11}));

    System.out.println(
        "yup: minDiff: " + minDiffWithSorting(new int[]{99, 3, 77, 1, 9, 11}));
  }
}
