package _10Blind25._3Binary;

import java.util.HashMap;
import java.util.Map;

//  https://leetcode.com/problems/missing-number/
public class _1MissingNumberE {

  //  https://www.youtube.com/watch?v=WnPLSRLSANE&ab_channel=NeetCode
  //  with SC - O(n)
  public static int missingNumber(int[] nums) {
    int range = nums.length;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < range + 1; i++) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }
    for (int num : nums) {
      map.remove(num);
    }
    int missingNo = -1;
    for (Integer key : map.keySet()) {
      missingNo = key;
    }
    return missingNo;
  }

  //  with SC - O(1) - using XoR operator; know this XoR property: 5^5 = 0, 0^9 = 9;
  public static int missingNumberXoR(int[] nums) {
    // Compute XOR of all the elements in the array
    int xor = 0;
    for (int num : nums) {
      xor ^= num;
    }

    // Compute XOR of all the elements from 1 to `n+1`
    for (int num = 0; num <= nums.length; num++) {
      xor ^= num;
    }
    return xor;
  }

  //  another soln - SC - O(1) - sum up
  public static int missingNumberSumUp(int[] nums) {
    int range = nums.length;
    int sum = 0;
    for (int i = 0; i < range + 1; i++) {
      sum += i;
    }
    int totSumOfArray = 0;
    for (int num : nums) {
      totSumOfArray += num;
    }
    return sum - totSumOfArray;
  }

  public static int missingNumberSumUpWithSingleLoop(int[] nums) {
    int res = nums.length;
    for (int i = 0; i < nums.length; i++) {
      res += (i - nums[i]);
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: missingNumber: " + missingNumber(new int[]{3, 0, 1})); //  yup: missingNumber: 2
    System.out.println(
        "yup: missingNumber: " + missingNumber(new int[]{0, 1}));  //  yup: missingNumber: 2
    System.out.println(
        "yup: missingNumber: " + missingNumber(
            new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));  //  yup: missingNumber: 8

    System.out.println(
        "yup: missingNumberXoR: " + missingNumberXoR(
            new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));  //  yup: missingNumberXoR: 8

    System.out.println(
        "yup: missingNumberSumUp: " + missingNumberSumUp(
            new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));  //  yup: missingNumberSumUp: 8

    System.out.println(
        "yup: missingNumberSumUpWithSingleLoop: " + missingNumberSumUpWithSingleLoop(
            new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));  //  yup: missingNumberSumUpWithSingleLoop: 8
  }
}
