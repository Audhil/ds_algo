package _10Blind75._7Trees;


//  https://leetcode.com/problems/binary-tree-maximum-path-sum/
public class _3MaximumPathSumH_Striver {

  private static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }
  }

  //  https://www.youtube.com/watch?v=WszrfSwMz58&ab_channel=takeUforward
  public static int maxPathSum(TreeNode root) {
    int[] maxSum = {0};
    maxSum[0] = Integer.MIN_VALUE;
    pathSum(root, maxSum);
    return maxSum[0];
  }

  //  similar to _2DiameterOfTree_Striver.java
  private static int pathSum(TreeNode root, int[] maxSum) {
    if (root == null) {
      return 0;
    }

    int lSum = Math.max(0, pathSum(root.left, maxSum));  //  ignoring the -ve values from nodes
    int rSum = Math.max(0, pathSum(root.right, maxSum));  //  ignoring the -ve values from nodes
    maxSum[0] = Math.max(maxSum[0], root.val + lSum + rSum);
    return root.val + Math.max(lSum, rSum);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(7);
    root.right.right = new TreeNode(6);
    System.out.println("yup: root: maxPathSum: " + maxPathSum(root)); //  yup: maxPathSum: 28
    TreeNode r2 = new TreeNode(-10);
    r2.left = new TreeNode(9);
    r2.right = new TreeNode(20);
    r2.right.left = new TreeNode(15);
    r2.right.right = new TreeNode(7);
    System.out.println("yup: r2: maxPathSum: " + maxPathSum(r2)); //  yup: r2: maxPathSum: 42
    TreeNode r3 = new TreeNode(-1);
    System.out.println("yup: r3: maxPathSum: " + maxPathSum(r3)); //  yup: r3: maxPathSum: -1
  }
}
