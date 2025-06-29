package _8Trees;

//  https://www.youtube.com/watch?v=HQHp_UyJnxU&ab_channel=codeExplainer
//  https://leetcode.com/problems/binary-tree-tilt/
public class _41BinaryTreeTiltE {

  private static class TreeNode {

    int val;
    TreeNode left, right;

    public TreeNode(int val) {
      this.val = val;
    }
  }

  public static int findTilt(TreeNode root) {
    int[] tilt = {0};
    solve(root, tilt);
    return tilt[0];
  }

  private static int solve(TreeNode root, int[] tilt) {
    if (root == null) {
      return 0;
    }
    int left = solve(root.left, tilt);
    int right = solve(root.right, tilt);
    tilt[0] += Math.abs(left - right);
    return root.val + left + right;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    System.out.println("yup: tilt: " + findTilt(root)); //  yup: tilt: 1
    TreeNode r2 = new TreeNode(4);
    r2.left = new TreeNode(2);
    r2.right = new TreeNode(9);
    r2.left.left = new TreeNode(3);
    r2.left.right = new TreeNode(5);
    r2.right.right = new TreeNode(7);
    System.out.println("yup: tilt: " + findTilt(r2)); //  yup: tilt: 15
    TreeNode r3 = new TreeNode(21);
    r3.left = new TreeNode(7);
    r3.right = new TreeNode(14);
    r3.left.left = new TreeNode(1);
    r3.left.right = new TreeNode(1);
    r3.right.left = new TreeNode(2);
    r3.right.right = new TreeNode(2);
    r3.left.left.left = new TreeNode(3);
    r3.left.left.right = new TreeNode(3);
    System.out.println("yup: tilt: " + findTilt(r3)); //  yup: tilt: 9
  }
}
