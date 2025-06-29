package _ZSubX;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//  https://www.youtube.com/watch?v=HEzpaUOAcds&ab_channel=CodingandSystemDesignInterviews
public class _2printAllSubsequences_recursion {

  //  ci - current index, cssi - current sub sequence index
  private static void revision(int[] nums) {
    System.out.println("yup: revision: ");
    int n = nums.length;
    int ci = 0;
    int cssi = 0;
    List<List<Integer>> subSeqList = new ArrayList<>();
    Integer[] tempSubSeqArr = new Integer[n];
    revisionGenerateSubSeq(nums, n, ci, cssi, tempSubSeqArr, subSeqList);
    //  [[null, null, null], [3, null, null], [2, null, null], [2, 3, null], [1, 3, null], [1, 3, null], [1, 2, null], [1, 2, 3]]
    System.out.println(subSeqList);
  }

  private static void revisionGenerateSubSeq(
      int[] nums,
      int n,
      int ci,
      int cssi,
      Integer[] tempSubSeqArr,
      List<List<Integer>> subSeqList) {
    if (ci >= n) {
      List<Integer> tempList = new ArrayList<>();
      Collections.addAll(tempList, tempSubSeqArr);
      subSeqList.add(tempList);
      return;
    }
    //  ignore item
    revisionGenerateSubSeq(nums, n, ci + 1, cssi, tempSubSeqArr, subSeqList);
    //  accept item
    tempSubSeqArr[cssi] = nums[ci];
    revisionGenerateSubSeq(nums, n, ci + 1, cssi + 1, tempSubSeqArr, subSeqList);
  }


  //   if arr is n, it'll have 2^n subsequences
  //  TC: O (2^n)
  private static void subSequence(int[] nums) {
    int n = nums.length;
    int ci = 0;
    int[] subSeqArray = new int[n];
    int cssi = 0;
    generateSubsequence(ci, nums, cssi, subSeqArray);
  }

  private static void generateSubsequence(int ci, int[] nums, int cssi, int[] subSeqArray) {
    if (ci >= nums.length) {
      print(cssi, subSeqArray);
      return;
    }
    //  exclude the item
    generateSubsequence(ci + 1, nums, cssi, subSeqArray);
    //  include the item
    subSeqArray[cssi] = nums[ci];
    generateSubsequence(ci + 1, nums, cssi + 1, subSeqArray);
  }

  private static void print(int currIndex, int[] nums) {
    System.out.print("{");
    for (int i = 0; i < currIndex; i++) {
      System.out.print(nums[i] + " ");
    }
    System.out.println("}");
  }

  /*
  *
    * yup: subSequences of Array:
      {}
      {3 }
      {2 }
      {2 3 }
      {1 }
      {1 3 }
      {1 2 }
      {1 2 3 }
  * */
  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    System.out.println("yup: subSequences of Array: ");
    subSequence(nums);
    revision(nums);
  }
}
