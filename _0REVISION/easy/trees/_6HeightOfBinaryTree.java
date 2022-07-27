package _0REVISION.easy.trees;

public class _6HeightOfBinaryTree {

  private static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }
  }

  private static int heightOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(heightOfBinaryTree(root.left), heightOfBinaryTree(root.right));
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.left.right.right = new TreeNode(6);
    root.left.right.left = new TreeNode(7);
    root.left.right.left.right = new TreeNode(71);

    System.out.println("yup: height of Binary tree: " + heightOfBinaryTree(
        root));  //  yup: height of Binary tree: 5
  }
}
