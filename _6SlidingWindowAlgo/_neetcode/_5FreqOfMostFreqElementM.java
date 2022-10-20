package _6SlidingWindowAlgo._neetcode;

import java.util.Arrays;

//  https://youtu.be/vgBrQ0NM5vE
//  https://leetcode.com/problems/frequency-of-the-most-frequent-element/
public class _5FreqOfMostFreqElementM {

  //  TC: O (n log n)
  public static int maxFrequency(int[] nums, int k) {
    Arrays.sort(nums);
    int maxWindowLen = 0, l = 0, r = 0;
    long totalTillWindow = 0;
    while (r < nums.length) {
      totalTillWindow += nums[r];
      //  avoiding invalid window
      while ((long) nums[r] * (r - l + 1) > totalTillWindow + k) {
        totalTillWindow -= nums[l];
        l++;
      }
      //  once we reach valid window
      maxWindowLen = Math.max(maxWindowLen, (r - l + 1));
      r++;
    }
    return maxWindowLen;
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: freq of most freq elements: " + maxFrequency(new int[]{1, 1, 1, 2, 2, 4},
            2));  //  yup: freq of most freq elements: 4

    System.out.println(
        "yup: freq of most freq elements: " + maxFrequency(new int[]{1, 2, 4},
            5)); //  yup: freq of most freq elements: 3

    System.out.println(
        "yup: freq of most freq elements: " + maxFrequency(new int[]{1, 4, 8, 13},
            5)); //  yup: freq of most freq elements: 2

    System.out.println(
        "yup: freq of most freq elements: " + maxFrequency(new int[]{3, 9, 6},
            2)); //  yup: freq of most freq elements: 1
  }
}
