package _10Blind75._7Trees;

public class _12KthLargestElementInBST_M {

  private static class TreeNode {

    int data;
    TreeNode left, right;

    public TreeNode(int data) {
      this.data = data;
    }
  }

  private static int kthLargest(TreeNode root, int k) {
    int[] res = {0};
    int[] kArr = {k};
    dfs(root, kArr, res);
    return res[0];
  }

  private static void dfs(TreeNode root, int[] kArr, int[] res) {
    if (root == null) {
      return;
    }
    dfs(root.right, kArr, res);
    kArr[0]--;
    if (kArr[0] == 0) {
      res[0] = root.data;
      return;
    }
    dfs(root.left, kArr, res);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(1);
    root.right = new TreeNode(4);
    root.left.right = new TreeNode(2);
    printTree(root);  //  1 2 3 4
    System.out.println("\nyup: kth largest item: " + kthLargest(root, 1));  //  4
    TreeNode root2 = new TreeNode(5);
    root2.left = new TreeNode(3);
    root2.right = new TreeNode(6);
    root2.left.left = new TreeNode(2);
    root2.left.right = new TreeNode(4);
    root2.left.left.left = new TreeNode(1);
    printTree(root2); //  1 2 3 4 5 6
    System.out.println("\nyup: 2nd kth largest item: " + kthLargest(root2, 5));  //  2
  }

  //  with inOrder
  private static void printTree(TreeNode root) {
    if (root == null) {
      return;
    }
    printTree(root.left);
    System.out.print(root.data + " ");
    printTree(root.right);
  }
}
