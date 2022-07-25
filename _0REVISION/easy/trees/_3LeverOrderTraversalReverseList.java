package _0REVISION.easy.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _3LeverOrderTraversalReverseList {

  private static class TreeNode {

    int data;
    TreeNode left, right;

    public TreeNode(int data) {
      this.data = data;
    }
  }

  public static List<List<Integer>> levelOrderBottom(TreeNode root) {
    List<List<Integer>> resList = new ArrayList<>();
    List<Integer> tempList = new ArrayList<>();
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    queue.add(null);
    while (!queue.isEmpty()) {
      TreeNode temp = queue.poll();
      if (temp == null) {
        resList.add(0, tempList);
        if (queue.isEmpty()) {
          return resList;
        }
        tempList = new ArrayList<>();
        queue.add(null);
      } else {
        tempList.add(temp.data);
        if (temp.left != null) {
          queue.add(temp.left);
        }
        if (temp.right != null) {
          queue.add(temp.right);
        }
      }
    }
    return resList;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(17);
    System.out.println("yup: levelOrderBottom: " + levelOrderBottom(root));
  }
}
