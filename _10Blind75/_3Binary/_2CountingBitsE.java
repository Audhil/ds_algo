package _10Blind75._3Binary;

import java.util.Arrays;

//  https://leetcode.com/problems/counting-bits/
//  https://www.youtube.com/watch?v=RyBM56RIWrM&ab_channel=NeetCode
//  notes @ https://photos.google.com/photo/AF1QipO0APDamJ1Zuf7DNHtM5f20Nupbv6BOvnvAXsod
public class _2CountingBitsE {

  public static int[] countBits(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 0;
    int offset = 1;
    for (int i = 1; i < n + 1; i++) {
      if (offset * 2 == i) {
        offset = i;
      }
      dp[i] = 1 + dp[i - offset];
    }
    return dp;
  }

  public static void main(String[] args) {
    System.out.println("yup: countBits : " + Arrays.toString(countBits(2)));
  }
}
