package _0dynamic_programming._neetcode.__1dDP;

//  https://youtu.be/_i4Yxeh5ceQ?t=6994
public class _8MaximumProductSubarray_FINAL_WAY_M {

  //  always keep track of min & max values
  public static int maxProduct(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    int currMin = 1, currMax = 1;
    int res = 0;
    for (int n : nums) {
      if (n == 0) {
        currMin = 1;
        currMax = 1;
        continue;
      }
      int temp = currMax;
      currMax = Math.max(n,
          Math.max(n * currMax, n * currMin));  //  https://youtu.be/_i4Yxeh5ceQ?t=7684
      currMin = Math.min(n,
          Math.min(n * temp, n * currMin)); //  https://youtu.be/_i4Yxeh5ceQ?t=7684
      res = Math.max(res, Math.max(currMax, currMin));
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: max product : " + maxProduct(new int[]{2, 3, -2, 4})); //  yup: max product : 6
    System.out.println(
        "yup: max product : " + maxProduct(new int[]{-2, 0, -1})); //  yup: max product : 0
  }
}
