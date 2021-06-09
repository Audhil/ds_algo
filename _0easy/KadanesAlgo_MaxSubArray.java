package _0easy;

//  https://www.youtube.com/watch?v=jnoVtCKECmQ
//  the max sub array sum
public class KadanesAlgo_MaxSubArray {

    public static int maxConsecutiveSubArray(int[] nums) {
        if (nums == null)
            return 0;

        if (nums.length == 1)
            return nums[0];

        int maxSum = nums[0];
        int currSum = maxSum;
        for (int j = 1; j < nums.length; j++) {
            currSum = Math.max(nums[j], currSum + nums[j]); //  choose max of curr+value or start from the value in the index
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("yup: max sub array: " + maxConsecutiveSubArray(new int[]{-2, 2, 5, -11, 6}));
        System.out.println("yup: max sub array: " + maxConsecutiveSubArray(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));
        System.out.println("yup: max sub array: " + maxConsecutiveSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println("yup: max sub array: " + maxConsecutiveSubArray(new int[]{5, 4, -1, 7, 8}));
    }
}
