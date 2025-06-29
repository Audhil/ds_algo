package _10Blind75._0Arrays;

import java.util.HashSet;
import java.util.Set;

//  https://leetcode.com/problems/contains-duplicate/
public class _0ContainsDuplicateE {

  //  TC: O (n) & SC: O (n)
  public static boolean containsDuplicate(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (set.contains(num)) {
        return true;
      }
      set.add(num);
    }
    return false;
  }

  public static boolean containsDuplicateRevision(int[] nums) {
    Set<Integer> hSet = new HashSet<>();
    for (int num : nums) {
      if (!hSet.add(num)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: contains duplicate: " + containsDuplicate(new int[]{1, 2, 3, 1})); //  true
    System.out.println(
        "yup: contains duplicate: " + containsDuplicateRevision(new int[]{1, 2, 3, 4})); //  false
    System.out.println(
        "yup: contains duplicate: " + containsDuplicateRevision(
            new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));  //  true
  }
}
