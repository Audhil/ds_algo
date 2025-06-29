package _8Trees;

//  https://www.youtube.com/watch?v=b1WpYxnuebQ&ab_channel=NeetCode
public class _40ConstructStringFromBinaryTree {

  private static class TreeNode {

    int val;

    public TreeNode(int val) {
      this.val = val;
    }

    TreeNode left;
    TreeNode right;
  }

  public static String tree2str(TreeNode root) {
    StringBuilder stringBuilder = new StringBuilder();
    preOrder(root, stringBuilder);
    return stringBuilder.substring(1, stringBuilder.length() - 1);  //  chop of the outer "(" ")"
  }

  private static void preOrder(TreeNode root, StringBuilder stringBuilder) {
    if (root == null) {
      return;
    }
    stringBuilder.append("(");
    stringBuilder.append(root.val);
    if (root.left == null && root.right != null) {
      stringBuilder.append("()");
    }
    preOrder(root.left, stringBuilder);
    preOrder(root.right, stringBuilder);
    stringBuilder.append(")");
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    System.out.println("yup: tree2str: " + tree2str(root)); //  yup: tree2str: 1(2(4))(3)

    TreeNode r2 = new TreeNode(1);
    r2.left = new TreeNode(2);
    r2.right = new TreeNode(3);
    r2.left.right = new TreeNode(4);
    System.out.println("yup: tree2str: " + tree2str(r2)); //  yup: tree2str: 1(2()(4))(3)
  }
}
