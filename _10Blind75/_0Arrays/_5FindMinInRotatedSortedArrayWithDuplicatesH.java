package _10Blind75._0Arrays;

//  https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/solution/
//  https://www.youtube.com/watch?v=oOxU48LTRdE&ab_channel=CodingDecoded
public class _5FindMinInRotatedSortedArrayWithDuplicatesH {

  public static int findMin(int[] nums) {
    if (nums == null) {
      return -1;
    }
    if (nums.length == 1) {
      return nums[0];
    }

    int l = 0, r = nums.length - 1;
    //  this is perfect sorted array
    if (nums[l] < nums[r]) {
      return nums[l];
    }

    while (l < r) {
      int mid = l + (r - l) / 2;
      if (nums[mid] == nums[r]) {
        r -= 1;
      }
      if (nums[mid] < nums[r]) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }
    return nums[l]; //  here becomes l = r.
  }

  //  TC : O (n) instead of O (log n) -> due to checking the duplicates
  public static int revision(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    int low = 0, high = nums.length - 1;
    while (low < high) {
      int mid = low + (high - low) / 2;
      if (nums[mid] == nums[high]) {
        high -= 1;
      } else if (nums[mid] < nums[high]) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return nums[low];
  }

  public static void main(String[] args) {
    System.out.println("yup: find min with duplicates: " + findMin(
        new int[]{100, 120, 120, 1, 1, 3, 6, 7, 20, 60, 80, 90, 100, 100}));  //  1

    System.out.println("yup: find min with duplicates: " + findMin(
        new int[]{120, 120, 120, 120, -111, 120, 120}));  //  -111
  }
}
