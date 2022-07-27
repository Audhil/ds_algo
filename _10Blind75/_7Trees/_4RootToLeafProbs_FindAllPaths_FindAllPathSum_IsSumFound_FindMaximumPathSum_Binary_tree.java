package _10Blind75._7Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class _4RootToLeafProbs_FindAllPaths_FindAllPathSum_IsSumFound_FindMaximumPathSum_Binary_tree {

  private static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }
  }

  //  https://www.youtube.com/watch?v=HQqoIl2RPLw&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=18&ab_channel=KashishMehndiratta
  private static List<List<Integer>> findAllPathsFromRootToLeaf(TreeNode root) {
    List<List<Integer>> resList = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();
    findPaths(root, path, resList);
    return resList;
  }

  private static void findPaths(TreeNode root,
      Deque<Integer> path,
      List<List<Integer>> resList) {
    if (root == null) {
      return;
    }
    path.addLast(root.val);
    if (root.left == null && root.right == null) {
      resList.add(new ArrayList<>(path));
    }
    findPaths(root.left, path, resList);
    findPaths(root.right, path, resList);
    //  back tracking
    path.removeLast();
  }

  //  find all path sum
  private static void allPathSum(TreeNode root, Deque<Integer> path, List<Integer> resList) {
    if (root == null) {
      return;
    }
    path.addLast(root.val);
    if (root.left == null && root.right == null) {
      Iterator<Integer> it = path.iterator();
      int sum = 0;
      while (it.hasNext()) {
        sum += it.next();
      }
      resList.add(sum);
    }
    allPathSum(root.left, path, resList);
    allPathSum(root.right, path, resList);
    path.removeLast();
  }

  //  is sum found in any path sum of tree?
  //  note: "currSum" will be local to all function calls
  private static void isSumFoundInAnyPath(TreeNode root, int currSum, int targetSum,
      boolean[] flag) {
    if (root == null) {
      return;
    }
    currSum += root.val;
    if (root.left == null && root.right == null) {
      if (currSum == targetSum) {
        flag[0] = true;
      }
    }
    isSumFoundInAnyPath(root.left, currSum, targetSum, flag);
    isSumFoundInAnyPath(root.right, currSum, targetSum, flag);
  }

  //  _15RootToLeafMaxPathSum.java
  //  max path sum
  private static void maxPathSum(TreeNode root, int currSum, int[] maxSum) {
    if (root == null) {
      return;
    }
    currSum += root.val;
    if (root.left == null && root.right == null) {
      maxSum[0] = Math.max(maxSum[0], currSum);
    }
    maxPathSum(root.left, currSum, maxSum);
    maxPathSum(root.right, currSum, maxSum);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.right = new TreeNode(7);
    System.out.println("yup: all paths: " + findAllPathsFromRootToLeaf(
        root));  //  yup: all paths: [[1, 2, 4], [1, 2, 5], [1, 3, 7]]
    List<Integer> resList = new ArrayList<>();
    Deque<Integer> path = new ArrayDeque<>();
    allPathSum(root, path, resList);
    System.out.println("yup: all paths sum: resList: "
        + resList);  //  yup: all paths sum: resList: [7, 8, 11]
    System.out.println("yup: is sum found, in any path!");
    boolean[] flag = {false};
    isSumFoundInAnyPath(root, 0, 8, flag);
    System.out.println("yup: is sum found: " + flag[0]);  //  true
    flag[0] = false;
    isSumFoundInAnyPath(root, 0, 19, flag);
    System.out.println("yup: is sum found: " + flag[0]);  //  false
    int[] maxSum = {0};
    maxPathSum(root, 0, maxSum);
    System.out.println("yup: maxPathSum: maxSum: " + maxSum[0]);  //  yup: maxPathSum: maxSum: 11
  }
}
