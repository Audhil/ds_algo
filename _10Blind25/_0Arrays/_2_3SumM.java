package _10Blind25._0Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//  https://leetcode.com/problems/3sum/
public class _2_3SumM {

  //  similar problems 2Sum - https://github.com/Audhil/ds_algo/blob/main/_0REVISION/easy/arrays/_2TwoSumsWithBST.java - solving with 2 pointers
  private static class TreeNode {

    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value, TreeNode left, TreeNode right) {
      this.value = value;
      this.left = left;
      this.right = right;
    }
  }

  private static void inOrderTraversal(TreeNode root, List<Integer> list) {
    if (root == null) {
      return;
    }

    inOrderTraversal(root.left, list);
    list.add(root.value);
    inOrderTraversal(root.right, list);
  }

  private static boolean isTwoSumExists(TreeNode root, int target) {
    if (root == null) {
      return false;
    }

    //  1. find inOrder traversal - it'll give sorted array
    List<Integer> list = new ArrayList<>();
    inOrderTraversal(root, list);

    //  2 pointer to find 2Sum
    int i = 0, j = list.size() - 1;
    while (i < j) {
      if (list.get(i) + list.get(j) < target) {
        i++;  //  increase left pointer
      } else if (list.get(i) + list.get(j) > target) {
        j--;
      }
      //  2Sum exists
      else {
        return true;
      }
    }
    return false;
  }

  //  2Sum using List & Set
  //  https://www.youtube.com/watch?v=Y-uK-gljw3E&ab_channel=LaurenLyu
  private static List<Integer> list;

  private static void add(int num) {
    if (list == null) {
      list = new ArrayList<>();
    }
    list.add(num);
  }

  private static boolean find(int sum) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < list.size(); i++) {
      int num1 = list.get(i);
      int num2 = sum - num1;
      if (set.contains(num2)) {
        return true;
      }
      set.add(list.get(i));
    }
    return false;
  }

  //  2Sum using Map
  private static Map<Integer, Integer> map = new HashMap<>();

  private static void addWithMap(int num) {
    map.put(num, map.getOrDefault(num, 0) + 1); //  adding key with occurrence count
  }

  private static boolean findWithMap(int sum) {
    for (Integer key : map.keySet()) {
      int num1 = key;
      int num2 = sum - num1;
      //  with 2 ifs
      if (num1 != num2 && map.containsKey(num2)) {
        return true;
      }

      if (num1 == num2 && map.get(num1) > 1) {
        return true;
      }

      //  with nested ifs
//      if (map.containsKey(num2)) {
//        if (num2 != num1 || map.get(num2) > 1) {
//          return true;
//        }
//      }
    }
    return false;
  }

  //  return indices of 2Sum
  //  https://leetcode.com/problems/two-sum
  public static int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int num1 = nums[i];
      int num2 = target - num1;
      if (map.containsKey(num2)) {
        return new int[]{i, map.get(num2)}; //  indices of num1 & num2
      }
      map.put(nums[i], i);  //  load map with num & it's indices
    }
    return new int[2];
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5,
        new TreeNode(3, new TreeNode(2, null, null), new TreeNode(4, null, null)),
        new TreeNode(6, null, new TreeNode(7, null, null)));
    System.out.println("yup: isTwoSumExists(9): " + isTwoSumExists(root, 9)); //  true
    System.out.println("yup: isTwoSumExists(28): " + isTwoSumExists(root, 28)); //  false

    //  2Sum with List & Set
    System.out.println("yup: 2Sum with List & Set");
    add(5);
    add(3);
    add(2);
    add(4);
    add(6);
    add(7);
    System.out.println("yup: with List & Set 2Sum exists: " + find(
        81));  //  yup: with List & Set 2Sum exists: false

    //  2Sum with Map
    System.out.println("yup: 2Sum with Map");
    addWithMap(5);
    addWithMap(3);
    addWithMap(2);
    addWithMap(4);
    addWithMap(6);
    addWithMap(7);
    System.out.println("yup: with Map 2Sum exists: " + findWithMap(
        8));  //  yup: with Map 2Sum exists: true

    //  2Sum find indices
    System.out.println("yup: find indices");
    System.out.println(
        "yup: indices of 2Sum: " + Arrays.toString(
            twoSum(new int[]{5, 3, 2, 4, 6, 7}, 7)));  //  yup: indices of 2Sum: [2, 0]
  }
}
