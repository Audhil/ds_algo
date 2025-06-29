package _10Blind75._7Trees;

import java.util.LinkedList;

//  https://leetcode.com/problems/invert-binary-tree/
public class _2InvertBinaryTreeE {

  public static class TreeNode {

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

  public TreeNode invertTree(TreeNode root) {
    invert(root);
    return root;
  }

  private static void invert(TreeNode root) {
    if (root == null) {
      return;
    }
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
    invert(root.left);
    invert(root.right);
  }

  private static void printLevelOrder(TreeNode root) {
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode temp = queue.poll();
      System.out.print(temp.val + " ");
      if (temp.left != null) {
        queue.add(temp.left);
      }
      if (temp.right != null) {
        queue.add(temp.right);
      }
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.right = new TreeNode(6);
    /*
    * yup: given tree:
      1 2 3 4 5 6
      After inverting tree:
      1 3 2 6 5 4
      *
      * */
    System.out.println("yup: given tree: ");
    printLevelOrder(root);
    invert(root);
    System.out.println("\nAfter inverting tree: ");
    printLevelOrder(root);
  }
}
