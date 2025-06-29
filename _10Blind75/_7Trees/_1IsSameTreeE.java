package _10Blind75._7Trees;

//  https://leetcode.com/problems/same-tree/
public class _1IsSameTreeE {

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

  public static boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if (p == null || q == null) {
      return false;
    }
    if (p.val != q.val) {
      return false;
    }
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    TreeNode root2 = new TreeNode(1);
    root2.left = new TreeNode(2);
    root2.right = new TreeNode(3);
    root2.left.left = new TreeNode(4);
    root2.left.right = new TreeNode(5);
    root2.right.right = new TreeNode(9);
    System.out.println("yup: 1st is Same Tree: " + isSameTree(root, root2));  //  false
    TreeNode root3 = new TreeNode(1);
    root3.left = new TreeNode(2);
    TreeNode root4 = new TreeNode(1);
    root4.left = new TreeNode(2);
    System.out.println("yup: 2nd is Same Tree: " + isSameTree(root3, root4)); //  true
    TreeNode p = new TreeNode(1);
    p.left = new TreeNode(2);
    p.right = new TreeNode(1);
    TreeNode q = new TreeNode(1);
    q.left = new TreeNode(1);
    q.right = new TreeNode(2);
    System.out.println("yup: 3rd is Same Tree: " + isSameTree(p, q)); //  false
  }
}
