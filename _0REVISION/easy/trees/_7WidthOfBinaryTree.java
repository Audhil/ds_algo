package _0REVISION.easy.trees;

import java.util.LinkedList;

//  https://www.youtube.com/watch?v=ZbybYvcVLks&ab_channel=takeUforward
public class _7WidthOfBinaryTree {

  private static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }
  }

  private static class Pair {

    TreeNode node;
    int num;

    public Pair(TreeNode _node, int _num) {
      this.node = _node;
      this.num = _num;
    }
  }

  private static int widthOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int ans = 0;
    LinkedList<Pair> queue = new LinkedList<>();
    queue.add(new Pair(root, 0));
    while (!queue.isEmpty()) {
      int size = queue.size();
      int mmin = queue.peek().num;
      int firstIndex = 0, lastIndex = 0;
      //  to avoid integer overflow, make indices as 1,2,3,4,5, .... in all levels
      for (int i = 0; i < size; i++) {
        Pair pair = queue.poll();
        TreeNode node = pair.node;
        int cur_id = pair.num - mmin;
        if (i == 0) {
          firstIndex = cur_id;
        }
        if (i == size - 1) {
          lastIndex = cur_id;
        }
        if (node.left != null) {
          queue.add(new Pair(node.left, 2 * cur_id + 1));  //  left child
        }
        if (node.right != null) {
          queue.add(new Pair(node.right, 2 * cur_id + 2));  //  right child
        }
      }
      ans = Math.max(ans, lastIndex - firstIndex + 1);
    }
    return ans;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.left.right.right = new TreeNode(6);
    root.left.right.left = new TreeNode(7);
    root.left.right.left.right = new TreeNode(71);
    System.out.println(
        "yup width of binary tree: " + widthOfBinaryTree(root)); //  yup width of binary tree: 2
    TreeNode root2 = new TreeNode(1);
    root2.left = new TreeNode(2);
    root2.left.left = new TreeNode(3);
    root2.right = new TreeNode(4);
    root2.right.right = new TreeNode(5);
    System.out.println(
        "yup width of binary root2: " + widthOfBinaryTree(root2)); //  yup width of binary tree: 2
  }
}
