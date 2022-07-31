package _10Blind75._7Trees;

import java.util.Stack;

//  https://leetcode.com/problems/kth-smallest-element-in-a-bst/
//  refer: _11KthSmallestElementInBST.java  - for recursive
//  https://www.youtube.com/watch?v=5LUXSvjmGCw&ab_channel=NeetCode - for iterative
public class _12KthSmallestElementInBST_M {

  //  tip: inOrder traversal of BST is sorted always
  private static class TreeNode {

    int data;
    TreeNode left, right;

    public TreeNode(int data) {
      this.data = data;
    }
  }

  public static int kthSmallest(TreeNode root, int k) {
    int[] res = {0};
    int[] kArr = {k};
    dfs(root, res, kArr);
    return res[0];
  }

  private static void dfs(TreeNode root, int[] res, int[] kArr) {
    if (root == null) {
      return;
    }

    dfs(root.left, res, kArr);
    kArr[0]--;
    if (kArr[0] == 0) {
      res[0] = root.data;
      return;
    }
    dfs(root.right, res, kArr);
  }

  //  iterative
  private static int kthSmallestIterative(TreeNode root, int k) {
    int n = 0;
    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = root;
    while (cur != null) {
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
      cur = stack.pop();
      n++;
      if (n == k) {
        return cur.data;
      }
      cur = cur.right;
    }
    return -1;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(1);
    root.right = new TreeNode(4);
    root.left.right = new TreeNode(2);
    System.out.println("yup: kth smallest item: " + kthSmallest(root, 1));  //  1
    TreeNode root2 = new TreeNode(5);
    root2.left = new TreeNode(3);
    root2.right = new TreeNode(6);
    root2.left.left = new TreeNode(2);
    root2.left.right = new TreeNode(4);
    root2.left.left.left = new TreeNode(1);
    System.out.println("yup: 2nd kth smallest item: " + kthSmallest(root2, 3));  //  3
    System.out.println("yup: iterative results:");
    System.out.println("yup: kth iterative smallest item: " + kthSmallestIterative(root, 1));  //  1
    System.out.println("yup: kth iterative  smallest item: " + kthSmallestIterative(root2, 3));  //  -1 //  this is giving wrong answer
  }
}
