package _10Blind25._0Arrays;

import java.util.HashMap;
import java.util.Map;

//  https://leetcode.com/problems/contains-duplicate/submissions/
public class _9ContainsDuplicateE {

  //  option 1 my solution - TC: O(n); SC - O(n)
  public static boolean containsDuplicate(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        return true;
      }
      map.put(nums[i], i);
    }
    return false;
  }

  //  option 2: sort the array, duplicates will be placed near to each other, iterate & find
  //  TC - O(n log n) + O(n); SC - O (1)

  public static void main(String[] args) {
    System.out.println("yup: contains duplicate: " + containsDuplicate(
        new int[]{1, 2, 3, 1})); //  yup: contains duplicate: true
    System.out.println("yup: contains duplicate: " + containsDuplicate(
        new int[]{1, 2, 3})); //  yup: contains duplicate: false
  }
}
