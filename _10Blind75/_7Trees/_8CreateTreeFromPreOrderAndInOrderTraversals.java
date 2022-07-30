package _10Blind75._7Trees;

import java.util.Arrays;

//  explanation: https://youtu.be/ihj4IQGZ2zc
public class _8CreateTreeFromPreOrderAndInOrderTraversals {

  private static class TreeNode {

    TreeNode left, right;
    int data;

    public TreeNode(int data) {
      this.data = data;
    }
  }

  public static TreeNode buildTree(int[] preorder, int[] inorder) {
    if (preorder == null || inorder == null || preorder.length != inorder.length) {
      return null;
    }
    if (preorder.length <= 0) {
      return null;
    }
    TreeNode root = new TreeNode(preorder[0]);
    int mid = indexOf(inorder, preorder[0], 0);
    root.left = buildTree(Arrays.copyOfRange(preorder, 1, mid + 1),
        //  actually, splits array from 1 to mid;
        Arrays.copyOfRange(inorder, 0, mid)); //  actually, splits array from 0 to mid-1;
    root.right = buildTree(Arrays.copyOfRange(preorder, mid + 1, preorder.length),
        //  splits array from mid+1 to len-1
        Arrays.copyOfRange(inorder, mid + 1, inorder.length));  //  splits array from mid+1 to len-1
    return root;
  }


  private static int indexOf(int[] arr, int item, int start) {
    if (start == arr.length) {
      return 0;
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

//    TreeNode root = buildTree(new int[]{1, 2}, new int[]{2, 1});
//    System.out.println("yup: constructed tree inOrder traversal");
//    printInOrder(root); //  2 1

//    TreeNode root = buildTree(new int[]{1, 2}, new int[]{1, 2});
//    System.out.println("yup: constructed tree inOrder traversal");
//    printInOrder(root); //  1 null 2
  }
}
