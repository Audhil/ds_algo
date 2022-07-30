package _10Blind75._7Trees;

import java.util.Arrays;

public class _8CreateTreeFromPreOrderAndInOrderTraversals {

  private static class TreeNode {

    TreeNode left, right;
    int data;

    public TreeNode(int data) {
      this.data = data;
    }
  }

  public static TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder == null || inorder == null) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[0]);
    int mid = indexOf(inorder, preorder[0], 0);
    if (mid > 0) {
      root.left = buildTree(Arrays.copyOfRange(preorder, 1, mid + 1),
          Arrays.copyOfRange(inorder, 0, mid));
      root.right = buildTree(Arrays.copyOfRange(preorder, mid + 1, preorder.length),
          Arrays.copyOfRange(inorder, mid + 1, inorder.length));
    }
    return root;
  }


  private static int indexOf(int[] arr, int item, int start) {
    if (start == arr.length) {
      return -1;
    }
    if (arr[start] == item) {
      return start;
    }
    return indexOf(arr, item, start + 1);
  }

  private static void printInOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    printInOrder(root.left);
    System.out.print(root.data + " ");
    printInOrder(root.right);
  }

  public static void main(String[] args) {
    TreeNode root = buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    System.out.println("yup: constructed tree inOrder traversal");
    printInOrder(root); //  9 3 15 20 7
  }
}
