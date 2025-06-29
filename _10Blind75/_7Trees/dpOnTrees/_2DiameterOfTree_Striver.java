package _10Blind75._7Trees.dpOnTrees;

//  https://www.youtube.com/watch?v=Rezetez59Nk&ab_channel=takeUforward
public class _2DiameterOfTree_Striver {

  private static class TreeNode {

    int value;
    TreeNode left, right;

    public TreeNode(int value) {
      this.value = value;
    }
  }

  //  BRUte force approach - O(n^2) - every time we are calculating left & right heights
  private static void diameter(TreeNode root, int[] maxDiameter) {
    if (root == null) {
      return;
    }
    int lh = findLeftHeight(root.left);
    int rh = findRightHeight(root.left);
    maxDiameter[0] = Math.max(maxDiameter[0], lh + rh);
    diameter(root.left, maxDiameter);
    diameter(root.right, maxDiameter);
  }

  private static int findLeftHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + findLeftHeight(root.left);
  }

  private static int findRightHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + findRightHeight(root.left);
  }

  //  TC: O (n)
  //  https://youtu.be/Rezetez59Nk?t=776 - using variation in height of tree code refer: _6HeightOfBinaryTree.java
  //  why to calculate lh & rh everytime, we can use it on the go
  private static int calcDiameter(TreeNode root, int[] maxi) {
    if (root == null) {
      return 0;
    }
    int lh = calcDiameter(root.left, maxi);
    int rh = calcDiameter(root.right, maxi);
    maxi[0] = Math.max(maxi[0], 1 + lh + rh);
    return 1 + Math.max(lh, rh);
  }


  public static void main(String[] args) {
    TreeNode root = new TreeNode(100);
    root.left = new TreeNode(33);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(222);
    root.left.right = new TreeNode(44);
    int[] diameter = {0};
    diameter(root, diameter);
    System.out.println("yup: diameter of tree: " + diameter[0]);  //  yup: diameter of tree: 4

    int[] diameter2 = {0};
    calcDiameter(root, diameter2);
    System.out.println("yup: diameter2 of tree: " + diameter2[0]);  //  yup: diameter2 of tree: 4
  }
}
