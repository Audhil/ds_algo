package _10Blind75._7Trees;

import java.util.HashMap;
import java.util.Map;

//  we use pointers, without splitting array
//  https://youtu.be/LgLRTaEMRVc?t=797
public class _9CreateTreeFromPostOrderAndInOrderTraversals {

  private static class TreeNode {

    TreeNode left, right;
    int data;

    public TreeNode(int data) {
      this.data = data;
    }
  }

  public static TreeNode buildTree(int[] postorder, int[] inorder) {
    if (postorder == null || inorder == null || postorder.length != inorder.length) {
      return null;
    }
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    return constructTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, map);
  }

  private static TreeNode constructTree(int[] postorder, int ps, int pe, int[] inorder, int is,
      int ie, Map<Integer, Integer> map) {
    if (ps > pe || is > ie) {
      return null;
    }
    TreeNode root = new TreeNode(postorder[pe]);
    int inRoot = map.get(postorder[pe]);
    int numsLeft = inRoot - is;
    root.left = constructTree(postorder, ps, ps + numsLeft - 1, inorder, is, inRoot - 1, map);
    root.right = constructTree(postorder, ps + numsLeft, pe - 1, inorder, inRoot + 1, ie, map);
    return root;
  }

  private static void printPostOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    printPostOrder(root.left);
    printPostOrder(root.right);
    System.out.print(root.data + " ");
  }

  public static void main(String[] args) {
    int[] inOrder = {40, 20, 50, 10, 60, 30};
    int[] postOrder = {40, 50, 20, 60, 30, 10};
    TreeNode root = buildTree(postOrder, inOrder);
    System.out.println("created tree: in post order: ");
    printPostOrder(root); //  40 50 20 60 30 10
  }
}
