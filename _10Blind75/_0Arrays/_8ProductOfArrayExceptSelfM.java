package _10Blind75._0Arrays;

import java.util.Arrays;

//  https://leetcode.com/problems/product-of-array-except-self/
public class _8ProductOfArrayExceptSelfM {

  //  with extra array for prefix & postfix - TC - O (n), SC - O (n)
  public static int[] revision_productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] prefix = new int[n];
    int[] postfix = new int[n];
    int product = 1;
    //  prefix
    for (int i = 0; i < n; i++) {
      product *= nums[i];
      prefix[i] = product;
    }
    //  postfix
    product = 1;
    for (int i = n - 1; i >= 0; i--) {
      product *= nums[i];
      postfix[i] = product;
    }

    //  final ans
    for (int i = 0; i < n; i++) {
      if (i - 1 < 0) {
        nums[i] = postfix[i + 1];
      } else if (i + 1 >= n) {
        nums[i] = prefix[i - 1];
      } else {
        nums[i] = prefix[i - 1] * postfix[i + 1];
      }
    }
    return nums;
  }

  public static int[] productExceptSelf(int[] nums) {
    int[] preFix = new int[nums.length];
    int[] postFix = new int[nums.length];

    int product = 1;
    for (int i = 0; i < nums.length; i++) {
      product *= nums[i];
      preFix[i] = product;
    }
    product = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      product *= nums[i];
      postFix[i] = product;
    }

    for (int i = 0; i < nums.length; i++) {
      if (i - 1 < 0) {
        nums[i] = postFix[i + 1];
      } else {
        if (i + 1 >= nums.length) {
          nums[i] = preFix[i - 1];
        } else {
          nums[i] = preFix[i - 1] * postFix[i + 1];
        }
      }
    }
    return nums;
  }

  //  with SC - O(1) - based on https://www.youtube.com/watch?v=bNvIQI2wAjk&ab_channel=NeetCode
  public static int[] productExceptSelfWithOofOneSC(int[] nums) {
    int[] res = new int[nums.length];
    //  iterating for prefix
    int prefix = 1;
    for (int i = 0; i < nums.length; i++) {
      res[i] = prefix;
      prefix *= nums[i];
    }
    //  iterating for postfix
    int postfix = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      res[i] *= postfix;  //  res[i] will contain prefix calculated earlier
      postfix *= nums[i];
    }
    return res;
  }


  //  revision
  public static int[] revision(int[] nums) {
    int[] res = new int[nums.length];
    //  prefix
    int prefix = 1;
    for (int i = 0; i < nums.length; i++) {
      res[i] = prefix;
      prefix *= nums[i];
    }
    //  postfix
    int postfix = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      res[i] *= postfix;  //  since res[i] will hold the prefix value
      postfix *= nums[i];
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println("yup: product of array except self: " + Arrays.toString(
        productExceptSelf(
            new int[]{1, 2, 3, 4}))); //  yup: product of array except self: [24, 12, 8, 6]

    System.out.println(
        "yup: productExceptSelfWithOofOneSC product of array except self: " + Arrays.toString(
            productExceptSelfWithOofOneSC(
                new int[]{1, 2, 3, 4}))); //  yup: product of array except self: [24, 12, 8, 6]

    System.out.println(
        "yup: productExceptSelfWithOofOneSC product of array except self: " + Arrays.toString(
            productExceptSelfWithOofOneSC(
                new int[]{1, 2, -3, -4}))); //  yup: product of array except self: [24, 12, -8, -6]

    System.out.println(
        "yup: productExceptSelfWithOofOneSC product of array except self: " + Arrays.toString(
            productExceptSelfWithOofOneSC(
                new int[]{1, 0, -3, -4}))); //  yup: product of array except self: [0, 12, 0, 0]
  }
}
