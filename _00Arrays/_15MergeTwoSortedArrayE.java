package _00Arrays;

import java.util.Arrays;

//  https://leetcode.com/problems/merge-sorted-array/
//  https://youtu.be/C4oBXLr3zos
public class _15MergeTwoSortedArrayE {

  //  TC: O (n); SC: O (1)
  public static void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m + n - 1;
    int l = m - 1;
    int r = n - 1;
    while (r >= 0) {
      if (l >= 0 && nums1[l] > nums2[r]) {
        nums1[i--] = nums1[l--];
      } else {
        nums1[i--] = nums2[r--];
      }
    }
    System.out.println("yup: finally: " + Arrays.toString(nums1));
  }

  public static void main(String[] args) {
    merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
  }
}
