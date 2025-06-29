package _10Blind75._7Trees;

//  https://leetcode.com/problems/balanced-binary-tree/
//  https://www.youtube.com/watch?v=QfJsau0ItOY&list=PLot-Xpze53ldg4pN6PfzoJY7KsKcxF1jg&ab_channel=NeetCode
//  trick is to check the balance condition from leaves
public class _11BalancedBinaryTreeE {

  //  Given a binary tree, determine if it is height-balanced (A height-balanced binary tree is a binary tree
  //  in which the depth of the two subtrees of every node never differs by more than one.)

  private static class TreeNode {

    int val;
    TreeNode left, right;

    public TreeNode(int val) {
      this.val = val;
    }
  }

  private static class Pair {

    boolean isBalance;
    int height;

    public Pair(boolean isBalance, int height) {
      this.isBalance = isBalance;
      this.height = height;
    }
  }

  public static boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    return dfs(root).isBalance;
  }

  private static Pair dfs(TreeNode root) {
    if (root == null) {
      return new Pair(true, 0);
    }
    Pair left = dfs(root.left);
    Pair right = dfs(root.right);
    boolean isBalanced =
        left.isBalance && right.isBalance && Math.abs(left.height - right.height) <= 1;
    return new Pair(isBalanced, 1 + Math.max(left.height, right.height));
  }

  private static boolean isBalancedTree2(TreeNode root) {
    return revisionWithDFS(root).isBalance;
  }

  private static Pair revisionWithDFS(TreeNode root) {
    if (root == null) {
      return new Pair(true, 0);
    }
    Pair left = revisionWithDFS(root.left);
    Pair right = revisionWithDFS(root.right);
    boolean isBalanced =
        left.isBalance && right.isBalance && Math.abs(left.height - right.height) <= 1;
    return new Pair(isBalanced, 1 + Math.max(left.height, right.height));
  }

  public static void main(String[] args) {
    //  tree 1
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    System.out.println("yup: is root balanced tree: " + isBalanced(root));  //  true
    System.out.println("yup: is root balanced tree: " + isBalancedTree2(root));  //  true
    //  tree 2
    TreeNode root2 = new TreeNode(1);
    root2.left = new TreeNode(2);
    root2.right = new TreeNode(2);
    root2.left.left = new TreeNode(3);
    root2.left.right = new TreeNode(3);
    root2.left.left.left = new TreeNode(4);
    root2.left.left.right = new TreeNode(4);
    System.out.println("yup: is root2 balanced tree: " + isBalanced(root2));  //  false
    System.out.println("yup: is root2 balanced tree: " + isBalancedTree2(root2));  //  false
  }
}
