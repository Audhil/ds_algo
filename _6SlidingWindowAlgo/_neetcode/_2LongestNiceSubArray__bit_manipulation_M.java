package _6SlidingWindowAlgo._neetcode;

//  https://www.youtube.com/watch?v=DrRuCsxb6CI&ab_channel=CodingDecoded
//  https://leetcode.com/problems/longest-nice-subarray/
public class _2LongestNiceSubArray__bit_manipulation_M {

  public static int longestNiceSubarray(int[] nums) {
    int l = 0;
    int bitsUnion = 0;
    int longest = 0;
    for (int r = 0; r < nums.length; r++) {
      int newEl = nums[r];
      //  loop till we reach proper window
      while ((bitsUnion & newEl) != 0) {
        //  remove the element from start -> l
        bitsUnion ^= nums[l++];
      }
      //  include the new element
      bitsUnion |= newEl;
      longest = Math.max(longest, r - l + 1);
    }
    return longest;
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: longestNiceSubarray: " + longestNiceSubarray(
            new int[]{1, 3, 8, 48, 10}));  //  yup: longestNiceSubarray: 3
    System.out.println(
        "yup: longestNiceSubarray: " + longestNiceSubarray(
            new int[]{3, 1, 5, 11, 13}));  //  yup: longestNiceSubarray:  1
  }
}
