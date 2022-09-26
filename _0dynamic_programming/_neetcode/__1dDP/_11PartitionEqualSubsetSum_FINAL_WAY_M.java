package _0dynamic_programming._neetcode.__1dDP;

import java.util.HashSet;
import java.util.Set;

//  https://leetcode.com/problems/partition-equal-subset-sum/
//  https://youtu.be/_i4Yxeh5ceQ?t=9922
public class _11PartitionEqualSubsetSum_FINAL_WAY_M {

  //  BOTTOM-UP approach

  //  TC: O (n * sum(nums))
  //  SC: O (sum(nums))
  //  https://youtu.be/_i4Yxeh5ceQ?t=10527
  public static boolean canPartition(int[] nums) {
    int sum = 0;
    for (int n : nums) {
      sum += n;
    }
    //  if sum is odd, we cannot divide it into 2 halves
    if (sum % 2 == 1) {
      return false;
    }
    int target = sum / 2;
    int n = nums.length;
    Set<Integer> dp = new HashSet<>();
    dp.add(0);  //  base case
    for (int i = n - 1; i >= 0; i--) {
      Set<Integer> tempDp = new HashSet<>();
      for (int t : dp) {
//        un comment this lines for optimal solution
//        if (t + nums[i] == target) {
//          return true;
//        }
        tempDp.add(t + nums[i]);
        tempDp.add(t);  //  don't want to miss older values
      }
      dp.addAll(tempDp);
    }
    return dp.contains(target);
  }

  public static void main(String[] args) {
    System.out.println("yup: " + canPartition(new int[]{1, 5, 11, 5})); //  true
    System.out.println("yup: " + canPartition(new int[]{1, 2, 3, 5}));  //  false
  }
}
