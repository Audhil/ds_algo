package _10Blind75._11Graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//  https://leetcode.com/problems/longest-consecutive-sequence/
public class _7LongestConsecutiveSequenceOfNumsM {

  //  brute force - TC: O (n^3), SC: O (1)
  public static int longestConsecutive(int[] nums) {
    int longContinuousStreak = 0;
    int currStreak;
    int currNum;
    for (int num : nums) {
      currNum = num;
      currStreak = 1;
      while (arrayHas(currNum + 1, nums)) {
        currNum++;
        currStreak++;
      }
      longContinuousStreak = Math.max(longContinuousStreak, currStreak);
    }
    return longContinuousStreak;
  }

  private static boolean arrayHas(int num, int[] nums) {
    for (int item : nums) {
      if (item == num) {
        return true;
      }
    }
    return false;
  }

  //  sorting - TC: O (n log n); SC: O (1)
  public static int longestConsecutive_withSorting(int[] nums) {
    int longestContinuousStreak = 1;
    int currStreak = 1;
    Arrays.sort(nums);
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[i - 1]) {
        if (nums[i] == nums[i - 1] + 1) {
          currStreak++;
        } else {
          longestContinuousStreak = Math.max(longestContinuousStreak, currStreak);
          currStreak = 1;
        }
      }
    }
    return Math.max(longestContinuousStreak, currStreak);
  }

  //  TC: O (n); SC: O (n)
  public static int longestConsecutive_withHashSet_Optimal(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      set.add(num);
    }
    int longestStreak = 0;
    for (int num : set) {
      if (!set.contains(num - 1)) {
        int currNum = num;
        int currStreak = 1;
        while (set.contains(currNum + 1)) {
          currNum++;
          currStreak++;
        }
        longestStreak = Math.max(longestStreak, currStreak);
      }
    }
    return longestStreak;
  }

  //  brute force
  //  brute force - TC: O (n^3), SC: O (1)
  public static int longestConsecutiveRevision(int[] nums) {
    int currNum, currStreak;
    int longestConsecutiveStreak = 0;
    for (Integer num : nums) {
      currNum = num;
      currStreak = 1;
      while (arrayHas(currNum + 1, nums)) {
        currNum++;
        currStreak++;
      }
      longestConsecutiveStreak = Math.max(longestConsecutiveStreak, currStreak);
    }
    return longestConsecutiveStreak;
  }

  //  TC: O (n log n); SC: O (1)
  public static int longestConsecutive_withSortingRevison(int[] nums) {
    int currStreak = 1, longestStreak = 1;
    Arrays.sort(nums);
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[i - 1]) {
        if (nums[i] == nums[i - 1] + 1) {
          currStreak++;
        } else {
          longestStreak = Math.max(longestStreak, currStreak);
          currStreak = 1;
        }
      }
    }
    return Math.max(longestStreak, currStreak);
  }

  //  TC: O (n); SC: O (n)
  public static int longestConsecutive_withHashSet_OptimalRevision(int[] nums) {
    int longestStreak = 0;
    Set<Integer> hSet = new HashSet<>();
    for (Integer num : nums) {
      hSet.add(num);
    }
    int currNum, currStreak;
    for (int num : hSet) {
      if (!hSet.contains(num - 1)) {
        currNum = num;
        currStreak = 1;
        while (hSet.contains(currNum + 1)) {
          currStreak++;
          currNum++;
        }
        longestStreak = Math.max(longestStreak, currStreak);
      }
    }
    return longestStreak;
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: longestConsecutive: " + longestConsecutiveRevision(
            new int[]{100, 4, 200, 1, 3, 2})); //  4 -> 1,2,3,4
    System.out.println(
        "yup: longestConsecutive: " + longestConsecutiveRevision(
            new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1})); //  9 -> 0, 1, .... 8
    System.out.println(
        "yup: longestConsecutive_withSorting: " + longestConsecutive_withSortingRevison(
            new int[]{100, 4, 200, 1, 3, 2})); //  4 -> 1,2,3,4
    System.out.println(
        "yup: longestConsecutive_withSorting: " + longestConsecutive_withSortingRevison(
            new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1})); //  9 -> 0, 1, .... 8
    System.out.println(
        "yup: longestConsecutive_withHashSet_Optimal: " + longestConsecutive_withHashSet_OptimalRevision(
            new int[]{100, 4, 200, 1, 3, 2})); //  4 -> 1,2,3,4
    System.out.println(
        "yup: longestConsecutive_withHashSet_Optimal: " + longestConsecutive_withHashSet_OptimalRevision(
            new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1})); //  9 -> 0, 1, .... 8
  }
}
