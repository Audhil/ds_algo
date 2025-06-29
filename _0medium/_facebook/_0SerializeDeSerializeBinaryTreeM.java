package _0medium._facebook;

//  https://www.lintcode.com/problem/7/?fromId=29&_from=collection
public class _0SerializeDeSerializeBinaryTreeM {

  private static class TreeNode {

    int value;
    TreeNode left, right;

    public TreeNode(int value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return "TreeNode{" +
          "value=" + value +
          ", left=" + left +
          ", right=" + right +
          '}';
    }
  }

  private static void printTree(TreeNode root) {
    if (root == null) {
      System.out.print("#,");
      return;
    }
    System.out.print(root.value + ",");
    printTree(root.left);
    printTree(root.right);
  }

  public static String serialize(TreeNode root) {
    StringBuilder sbr = new StringBuilder();
    sHelper(root, sbr);
    return sbr.toString();
  }

  private static void sHelper(TreeNode root, StringBuilder sbr) {
    if (root == null) {
      sbr.append("#,");
      return;
    }
    sbr.append(root.value).append(",");
    sHelper(root.left, sbr);
    sHelper(root.right, sbr);
  }

  public static TreeNode deserialize(String data) {
    int[] currIndex = {0};
    String[] dataArr = data.split(",");
    return dHelper(currIndex, dataArr);
  }

  private static TreeNode dHelper(int[] currIndex, String[] dataArr) {
    if (currIndex[0] == dataArr.length) {
      return null;
    }
    TreeNode root = null;
    String str = dataArr[currIndex[0]++];
    if (!str.equals("#")) {
      root = new TreeNode(Integer.parseInt(str));
      root.left = dHelper(currIndex, dataArr);
      root.right = dHelper(currIndex, dataArr);
    }
    return root;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    /*
    * yup: after serialization: 3,9,#,#,20,15,#,#,7,#,#,
      yup: after deSerialization: 3,9,#,#,20,15,#,#,7,#,#,
      * */
    String serialized = serialize(root);
    System.out.println("yup: after serialization: " + serialized);
    TreeNode resRoot = deserialize(serialized);
    System.out.print("yup: after deSerialization: ");
    printTree(resRoot);
  }
}
