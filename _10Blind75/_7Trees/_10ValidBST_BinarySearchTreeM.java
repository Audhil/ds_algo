package _10Blind75._7Trees;

//  https://youtu.be/s6ATEkipzow
public class _10ValidBST_BinarySearchTreeM {

  private static class TreeNode {

    int val;
    TreeNode left, right;

    public TreeNode(int val) {
      this.val = val;
    }
  }

  public static boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }
    return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  private static boolean isValid(TreeNode root, long leftBoundary, long rightBoundary) {
    if (root == null) {
      return true;
    }
    if (!(root.val > leftBoundary && root.val < rightBoundary)) {
      return false;
    }
    return (isValid(root.left, leftBoundary, root.val) && isValid(root.right, root.val,
        rightBoundary));
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);
    System.out.println("yup: is valid binary tree: " + isValidBST(root)); //  true

    TreeNode root2 = new TreeNode(5);
    root2.left = new TreeNode(1);
    root2.right = new TreeNode(4);
    root2.right.left = new TreeNode(3);
    root2.right.right = new TreeNode(6);
    System.out.println("yup: is valid binary tree: root2: " + isValidBST(root2)); //  false
  }
}
