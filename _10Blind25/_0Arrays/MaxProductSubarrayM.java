package _10Blind25._0Arrays;

//  https://leetcode.com/problems/maximum-product-subarray/
//  https://www.youtube.com/watch?v=lXVy6YWFcRM&ab_channel=NeetCode - always keep track of +ve & -ve products
public class MaxProductSubarrayM {

  public static int maxProduct(int[] nums) {
    if (nums == null) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    int maxP = nums[0], minP = nums[0], ans = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int currNum = nums[i];
      int posProduct = currNum * maxP;
      int negProduct = currNum * minP;

      maxP = Math.max(currNum, Math.max(posProduct, negProduct));
      minP = Math.min(currNum, Math.min(posProduct, negProduct));
      ans = Math.max(ans, maxP);
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println("yup: maxProduct of array: " + maxProduct(new int[]{2, 3, -2, 4}));
    System.out.println("yup: maxProduct of array: " + maxProduct(new int[]{-2, 0, -1}));
  }
}
