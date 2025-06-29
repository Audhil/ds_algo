package _10Blind75._7Trees.dpOnTrees;

//  max no of nodes between 2 nodes
public class _1DiameterOfTree {

  private static class TreeNode {

    int value;
    TreeNode left, right;

    public TreeNode(int value) {
      this.value = value;
    }
  }

  private static int diameterOfTree(TreeNode root, int[] diameter) {
    if (root == null) {
      return 0;
    }
    int l = diameterOfTree(root.left, diameter);
    int r = diameterOfTree(root.right, diameter);
    int temp = 1 + Math.max(l, r);  //  node is ignored, I'm not the answer
    int res = Math.max(temp, 1 + l + r); //  node is not ignored,
    diameter[0] = Math.max(diameter[0], res);
    //  https://youtu.be/d1u2t018Kjg?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&t=692
    return temp;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(100);
    root.left = new TreeNode(33);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(222);
    root.left.right = new TreeNode(44);
    int[] diameter = {0};
    diameterOfTree(root, diameter);
    System.out.println("yup: diameter of tree: " + diameter[0]);  //  yup: diameter of tree: 4
  }
}
