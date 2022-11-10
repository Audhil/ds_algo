package _0medium._facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2FindAllSubsetsM {

  public static List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> resList = new ArrayList<>();
    sHelper(0, nums, new ArrayList<>(), resList);
    return resList;
  }

  private static void sHelper(int index, int[] nums, List<Integer> tempList,
      List<List<Integer>> resList) {
    if (index == nums.length) {
      resList.add(new ArrayList<>(tempList));
      return;
    }

    sHelper(index + 1, nums, tempList, resList);
    tempList.add(nums[index]);
    sHelper(index + 1, nums, tempList, resList);
    tempList.remove(tempList.size() - 1);
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    System.out.println("yup: subsets of [" + Arrays.toString(nums) + "] is: " + subsets(
        nums)); //  yup: subsets of [[1, 2, 3]] is: [[], [3], [2], [2, 3], [1], [1, 3], [1, 2], [1, 2, 3]]

  }
}