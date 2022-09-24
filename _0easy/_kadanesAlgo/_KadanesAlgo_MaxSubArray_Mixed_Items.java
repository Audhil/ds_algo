package _0easy._kadanesAlgo;

//  https://youtu.be/HCL4_bOd3-4
public class _KadanesAlgo_MaxSubArray_Mixed_Items {

  private static int maxSumSubArray(int[] nums) {
    if (nums == null) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }

    int currSum = 0, maxSum = Integer.MIN_VALUE;
    for (int num : nums) {
      currSum += num;
      maxSum = Math.max(maxSum, currSum);
      if (currSum < 0) {
        currSum = 0;
      }
    }
    return maxSum;
  }

  public static void main(String[] args) {
    System.out.println("yup: maxSumSubArray: " + maxSumSubArray(
        new int[]{-5, 4, 6, -3, 4, -1})); //  yup: maxSumSubArray: 11

    System.out.println(
        "yup: max sub array: " + maxSumSubArray(
            new int[]{-5, -4, -6, -3, -4, -1})); //  yup: max sub array: -1
  }
}
