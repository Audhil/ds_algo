package _10Blind75._7Trees;


//  https://leetcode.com/problems/binary-tree-maximum-path-sum/
public class _3MaximumPathSumH {

  private static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(7);
    root.right.right = new TreeNode(6);
  }
}
