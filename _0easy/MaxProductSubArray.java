package _0easy;

//  https://leetcode.com/problems/maximum-product-subarray/
/*
* Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

It is guaranteed that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.



Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.


Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
* */
public class MaxProductSubArray {

    //  O (n^3) - solution
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];

        int product, maxProduct = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                product = 1;
                for (int k = i; k <= j; k++) {
                    product *= nums[k];
                    maxProduct = Math.max(product, maxProduct);
                }
            }
        }
        return maxProduct;
    }

    //  O(n^2)
    public static int maxProductt(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];

        int product, maxProduct = 0;
        for (int i = 0; i < nums.length; i++) {
            product = 1;
            for (int j = 0; j < nums.length; j++) {
                product *= nums[j];
                maxProduct = Math.max(product, maxProduct);
            }
        }
        return maxProduct;
    }

    public static int maxProducttt(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];

        int maxP = nums[0];  //Stores the maximum product soo far
        int minP = nums[0];  //Stores the minimum product soo far basically the -ve product
        int ans = nums[0];   //Stores the answer to be returned

        for (int i = 1; i < nums.length; i++) {
            int first = nums[i];         //First Possibility
            int second = maxP * nums[i];   //Second Possibility
            int third = minP * nums[i];    //Third Possibility
            minP = Math.min(Math.min(first, second), third);
            maxP = Math.max(Math.max(first, second), third);
            ans = Math.max(ans, maxP);
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println("yup: max product: " + maxProduct(new int[]{2, 3, -2, 4}));
//        System.out.println("yup: max product: " + maxProduct(new int[]{-2, 0, -1}));

//        System.out.println("yup: max product: " + maxProductt(new int[]{2, 3, -2, 4}));
//        System.out.println("yup: max product: " + maxProductt(new int[]{-2, 0, -1}));

        System.out.println("yup: max product : " + maxProducttt(new int[]{2, 3, -2, 4}));
        System.out.println("yup: max product : " + maxProducttt(new int[]{-2, 0, -1}));
    }
}
