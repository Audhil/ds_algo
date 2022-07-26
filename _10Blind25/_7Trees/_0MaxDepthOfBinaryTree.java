package _10Blind25._7Trees;

import java.util.LinkedList;
import java.util.Stack;

//  https://leetcode.com/problems/maximum-depth-of-binary-tree/submissions/
public class _0MaxDepthOfBinaryTree {

  private static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  //  by level order traversal - iterative - TC: O (n) - BFS
  private static int maxDepthIterativeBFS1(TreeNode root) {
    if (root == null) {
      return 0;
    }

    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    queue.add(null);
    int maxDepth = 0;
    while (!queue.isEmpty()) {
      TreeNode temp = queue.poll();
      if (temp == null) {
        maxDepth++;
        if (queue.isEmpty()) {
          return maxDepth;
        }
        queue.add(null);
      } else {
        if (temp.left != null) {
          queue.add(temp.left);
        }
        if (temp.right != null) {
          queue.add(temp.right);
        }
      }
    }
    return maxDepth;
  }

  //  by level order traversal - iterative - TC: O (n) - BFS
  private static int maxDepthIterativeBFS2(TreeNode root) {
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int level = 0;
    while (!queue.isEmpty()) {
      for (int i = 0; i < queue.size(); i++) {
        TreeNode temp = queue.poll();
        if (temp.left != null) {
          queue.add(temp.left);
        }
        if (temp.right != null) {
          queue.add(temp.right);
        }
      }
      level++;
    }
    return level;
  }

  //  by recursive - TC: O (n) - DFS
  //  InOrder DFS?
  private static int maxDepthRecursiveDFS(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(maxDepthRecursiveDFS(root.left), maxDepthRecursiveDFS(root.right));
  }

  //  PreOrder DFS
  private static class NodeWithDepth {

    private final TreeNode node;
    private final int depth;

    public NodeWithDepth(TreeNode root, int depth) {
      this.node = root;
      this.depth = depth;
    }
  }

  private static int maxDepthIterativeDFS2(TreeNode root) {
    Stack<NodeWithDepth> stack = new Stack<>();
    stack.push(new NodeWithDepth(root, 1));
    int res = 0;
    while (!stack.isEmpty()) {
      NodeWithDepth nodeWithDepth = stack.pop();
      if (nodeWithDepth.node != null) {
        res = Math.max(res, nodeWithDepth.depth);
        stack.push(new NodeWithDepth(nodeWithDepth.node.left, res + 1));
        stack.push(new NodeWithDepth(nodeWithDepth.node.right, res + 1));
      }
    }
    return res;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    System.out.println(
        "yup: maxDepthIterativeBFS1 : max Depth of binary tree: " + maxDepthIterativeBFS1(
            root)); //  yup: maxDepthIterativeBFS1: max Depth of binary tree: 3
    System.out.println(
        "yup: maxDepthIterativeBFS2 : max Depth of binary tree: " + maxDepthIterativeBFS2(
            root)); //  yup: maxDepthIterativeBFS2: max Depth of binary tree: 3
    System.out.println(
        "yup: maxDepthRecursiveDFS : max Depth of binary tree: " + maxDepthRecursiveDFS(
            root)); //  yup: maxDepthRecursiveDFS: max Depth of binary tree: 3
    System.out.println(
        "yup: maxDepthIterativeDFS2 : max Depth of binary tree: " + maxDepthIterativeDFS2(
            root)); //  yup: maxDepthIterativeDFS2: max Depth of binary tree: 3
  }
}
