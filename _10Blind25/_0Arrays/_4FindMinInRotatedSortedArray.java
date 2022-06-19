package _10Blind25._0Arrays;

//  https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/solution/
//  solve in O (log n) -  we are using Binary search
public class _4FindMinInRotatedSortedArray {

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

    while (l <= r) {
      int mid = l + (r - l) / 2;

      //  case 1
      //  finding the inflation point
      if (nums[mid] > nums[mid + 1]) {
        return nums[mid + 1];
      }
      if (nums[mid - 1] > nums[mid]) {
        return nums[mid];
      }

      //  case 2 - move pointers to find inflation point
      if (nums[mid] > nums[0]) {
        l = mid + 1;
      } else {
        r = mid - 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: min of rotated array: " + findMin(new int[]{4, 5, 6, -48, -11, -2, 0, 1, 2, 3}));
  }
}
