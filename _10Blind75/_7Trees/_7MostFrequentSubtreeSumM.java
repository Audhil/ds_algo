package _10Blind75._7Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//  https://leetcode.com/problems/most-frequent-subtree-sum/
public class _7MostFrequentSubtreeSumM {

  private static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  private static Map<Integer, Integer> cMap = new HashMap<>();
  private static int maxi = -1;

  private static int subTreeSum(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int leftSum = subTreeSum(root.left);
    int rightSum = subTreeSum(root.right);
    int totalSum = root.val + leftSum + rightSum;
    cMap.put(totalSum, cMap.getOrDefault(totalSum, 0) + 1);
    maxi = Math.max(maxi, cMap.get(totalSum));
    return totalSum;
  }

  public static int[] findFrequentTreeSum(TreeNode root) {
    subTreeSum(root);
    List<Integer> tempList = new ArrayList<>();
    for (int key : cMap.keySet()) {
      if (cMap.get(key) == maxi) {
        tempList.add(key);
      }
    }
    int[] result = new int[tempList.size()];
    for (int i = 0; i < tempList.size(); i++) {
      result[i] = tempList.get(i);
    }
    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(2);
    root.right = new TreeNode(-5);
    System.out.println("yup: findFrequentTreeSum : " + Arrays.toString(
        findFrequentTreeSum(root))); //  yup: findFrequentTreeSum : [2]
  }
}
