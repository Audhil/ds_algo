package _0REVISION.easy.arrays;

//  https://www.lintcode.com/problem/689/description
/*
 * Given a binary search tree and a number n,
 * find two numbers in the tree that sums up to n.
 *
 * Use O(1) extra space.
 */
public class _4TwoSumsWithBSTSpaceOptimized {

  public static class TreeNode {

    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
      this.val = val;
      this.left = this.right = null;
    }
  }

    /*
    *
    * public static int[] findTarget(TreeNode root, int k) {
        int[] res = new int[2];
        findValue(root, root, k, res);
        return res;
    }

    private static boolean findValue(TreeNode node, TreeNode root, int k, int[] res) {
        if (root == null)
            return false;

        if (find(node, k - root.val) && root.val != (k - root.val)) {
            res[0] = root.val;
            res[1] = k - root.val;
            return true;
        }

        return findValue(node, root.left, k, res) || findValue(node, root.right, k, res);
    }
    * */

  public static boolean findTarget(TreeNode root, int k) {
    return findValue(root, root, k);
  }

  private static boolean findValue(TreeNode node, TreeNode root, int k) {
    if (root == null) {
      return false;
    }

    if (find(node, k - root.val) && root.val != (k - root.val)) {
      return true;
    }

    return findValue(node, root.left, k) || findValue(node, root.right, k);
  }

  private static boolean find(TreeNode root, int target) {
    if (root == null) {
      return false;
    }

    if (root.val == target) {
      return true;
    }

    if (root.val > target) {
      return find(root.left, target);
    }
    return find(root.right, target);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(5);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    int k = 3;
    System.out.println("yup: findTarget: " + findTarget(root, k));
    System.out.println("yup: findTargetRevision: " + findTargetRevision(root, k));
  }


  //  revision
  private static boolean findTargetRevision(TreeNode root, int k) {
    return findValuee(root, root, k);
  }

  private static boolean findValuee(TreeNode node, TreeNode root, int k) {
    if (root == null) {
      return false;
    }
    if (findd(node, k - root.val) && (k - root.val) != root.val) {
      return true;
    }
    return findValuee(root.left, node, k) || findValuee(root.right, node, k);
  }

  private static boolean findd(TreeNode root, int k) {
    if (root == null) {
      return false;
    }

    if (root.val == k) {
      return true;
    }

    if (root.val > k) {
      return findd(root.left, k);
    }
    return findd(root.right, k);
  }
}
