package _ZSubX;

import java.util.ArrayList;
import java.util.List;

//  https://www.youtube.com/watch?v=U_Pe95r41Rs&list=PLNxqWc8Uj2LTaaxs-8vzK0Ft47rMggFnN&index=4&ab_channel=KashishMehndiratta
public class _3printAllSubsets_backtracking {

  /*
  *
  * generated subsets are:
      []
      [3]
      [2]
      [2, 3]
      [1]
      [1, 3]
      [1, 2]
      [1, 2, 3]
  * */

  //  refer: _0FindAllSubsetsOfSet.java, _0Subsets.java
  private static void subSets(int[] nums) {
    int n = nums.length;
    int currIndex = 0;
    List<List<Integer>> subsetList = new ArrayList<>();
    List<Integer> currList = new ArrayList<>();
    generateSubsets(currIndex, nums, n, currList, subsetList);
    System.out.println("generated subsets are: ");
    for (List<Integer> list : subsetList) {
      System.out.println(list);
    }
  }

  private static void generateSubsets(int currIndex, int[] nums, int n, List<Integer> currList,
      List<List<Integer>> subsetList) {
    if (currIndex >= n) {
      subsetList.add(new ArrayList<>(currList));
      return;
    }
    //  not include, & call left tree
    generateSubsets(currIndex + 1, nums, n, currList, subsetList);
    //  include & call right tree
    currList.add(nums[currIndex]);
    generateSubsets(currIndex + 1, nums, n, currList, subsetList);
    currList.remove(currList.size() - 1); //  backtracking - remove the last item
  }

  public static void main(String[] args) {
    subSets(new int[]{1, 2, 3});
  }
}
