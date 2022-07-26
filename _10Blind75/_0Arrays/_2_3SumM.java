package _10Blind75._0Arrays;

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

  //  3Sum - https://leetcode.com/problems/3sum/
  //  https://www.youtube.com/watch?v=jzZsG8n2R9A&ab_channel=NeetCode
  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> finalList = new ArrayList<>();
    //  sort the array
    Arrays.sort(nums);  //  O (n log n)
    for (int i = 0; i < nums.length; i++) {
      int a = nums[i];  //  1st element at i index
      //  avoid choosing duplicate nums
      if (i > 0 && a == nums[i - 1]) {
        continue;
      }
      int bIndex = i + 1;  //  2nd element at i +1 index
      int cIndex = nums.length - 1;  //  3rd element at last index
      while (bIndex < cIndex) {
        int target = -a;
        if (nums[bIndex] + nums[cIndex] > target) {
          cIndex--;
        } else if (nums[bIndex] + nums[cIndex] < target) {
          bIndex++;
        }
        //  equal to target
        else {
          List<Integer> list = new ArrayList<>();
          list.add(a);
          list.add(nums[bIndex]);
          list.add(nums[cIndex]);
          finalList.add(list);
          //  https://youtu.be/jzZsG8n2R9A?t=715
          bIndex++;
          while (bIndex < nums.length - 1
              && nums[bIndex] == nums[bIndex - 1]) {
            bIndex++;
          }
        }
      }
    }
    return finalList;
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

    //  3Sum
    System.out.println("3Sum check it out");
    System.out.println(
        "yup: 3Sum int[]{-1, 0, 1, 2, -1, -4} soln: " + threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    System.out.println("yup: 3Sum int[]{} soln: " + threeSum(new int[]{}));
    System.out.println("yup: 3Sum int[]{0} soln: " + threeSum(new int[]{0}));

  }
}
