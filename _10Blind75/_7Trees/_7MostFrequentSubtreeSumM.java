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

  private static int subTreeSum(TreeNode root, Map<Integer, Integer> cMap, int[] maxi) {
    if (root == null) {
      return 0;
    }
    int leftSum = subTreeSum(root.left, cMap, maxi);
    int rightSum = subTreeSum(root.right, cMap, maxi);
    int totalSum = root.val + leftSum + rightSum;
    cMap.put(totalSum, cMap.getOrDefault(totalSum, 0) + 1);
    maxi[0] = Math.max(maxi[0], cMap.get(totalSum));
    return totalSum;
  }

  public static int[] findFrequentTreeSum(TreeNode root) {
    Map<Integer, Integer> cMap = new HashMap<>();
    int[] maxi = {-1};
    subTreeSum(root, cMap, maxi);
    List<Integer> tempList = new ArrayList<>();
    for (int key : cMap.keySet()) {
      if (cMap.get(key) == maxi[0]) {
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
