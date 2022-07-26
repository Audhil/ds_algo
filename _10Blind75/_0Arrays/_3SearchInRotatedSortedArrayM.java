package _10Blind75._0Arrays;

//  https://leetcode.com/problems/search-in-rotated-sorted-array/
//  soln: https://www.lintcode.com/problem/62/solution/56253
public class _3SearchInRotatedSortedArrayM {

  //  doing with Binary Search
  public static int search(int[] nums, int target) {
    if (nums == null) {
      return -1;
    }
    if (nums.length == 1) {
      return nums[0] == target ? 0 : -1;
    }
    int n = nums.length;
    int l = 0, r = n - 1;
    while (l <= r) {
      int mid = l + (r - l) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      //  left sorted portion
      if (nums[l] <= nums[mid]) {
        if (target > nums[mid] || target < nums[l]) {
          l = mid + 1;
        } else {
          r = mid - 1;
        }
      }
      //  right sorted portion
      else {
        if (target < nums[mid] || target > nums[r]) {
          r = mid - 1;
        } else {
          l = mid + 1;
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    /*
    *
    * yup: index of item: 4
    yup: index of item: -1
    yup: index of item: 5
    yup: index of item: 1
    yup: index of item: 0
    yup: index of item: -1
    yup: index of item: 1
    * */
    System.out.println("yup: index of item: " + search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0)); //  yup: index of item: 4
    System.out.println("yup: index of item: " + search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3)); //  yup: index of item: -1
    System.out.println("yup: index of item: " + search(new int[]{4, 5, 6, 7, 0, 1, 2}, 1)); //  yup: index of item: 5
    System.out.println("yup: index of item: " + search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5)); //  yup: index of item: 1
    System.out.println("yup: index of item: " + search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4)); //  yup: index of item: 0
    System.out.println("yup: index of item: " + search(new int[]{1}, 0)); //  yup: index of item: -1
    System.out.println("yup: index of item: " + search(new int[]{3, 1}, 1));  //  yup: index of item: 1
  }
}
