package _0easy;

//  https://leetcode.com/problems/maximum-subarray/
//  https://www.youtube.com/watch?v=w_KEocd__20 - Kadane's Algorithm
public class MaxSubArray {

    //  O (n^3) - solution
    public static int maxSubArray(int[] nums) {
        int sum = 0, maxValue = 0;
        for (int i = 0; i < nums.length; i++) {
//            sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum = 0;
                for (int k = i; k < j; k++) {
                    sum += nums[i] + nums[j];
                    maxValue = Math.max(sum, maxValue);
                }
            }
        }
        return maxValue;
    }

    //  O (n^2) - solution
    public static int maxSubArrayy(int[] nums) {
        int sum = 0, maxValue = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += nums[j];
            }
        }
        return sum;
    }

    //O(N) - Kadane's ALGORITHM
    public static int maxSubArrayyy(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];

        int sum = 0, maxValue = nums[0];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxValue = Math.max(sum, maxValue);
            if (sum < 0)
                sum = 0;
        }
        return maxValue;
    }

    public static void main(String[] args) {
//        System.out.println("yup: max sub array: " + maxSubArray(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));
//        System.out.println("yup: max sub array: " + maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
//        System.out.println("yup: max sub array: " + maxSubArrayy(new int[]{5, 4, -1, 7, 8}));
        System.out.println("yup: max sub array: " + maxSubArrayyy(new int[]{5, 4, -1, 7, 8}));
    }
}
