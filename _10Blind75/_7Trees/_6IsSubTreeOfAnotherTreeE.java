package _10Blind75._7Trees;

//  https://leetcode.com/problems/subtree-of-another-tree/

//  refer: _1IsSameTreeE.java
public class _6IsSubTreeOfAnotherTreeE {

  private static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
  //////////////////////
  //  accepted code in leet code

  public static boolean isSubtreee(TreeNode root, TreeNode subRoot) {
    if (root == null) {
      return false;
    }
    if (compare(root, subRoot)) {
      return true;
    }
    return isSubtreee(root.left, subRoot) || isSubtreee(root.right, subRoot);
  }

  public static boolean compare(TreeNode root1, TreeNode root2) {
    if (root1 == null || root2 == null) {
      return root1 == null && root2 == null;
    }
    if (root1.val != root2.val) {
      return false;
    }
    return compare(root1.left, root2.left) && compare(root1.right, root2.right);
  }

  ///////////////
  public static boolean isSameTree(TreeNode s, TreeNode t) {
    if (s == null || t == null) {
      return s == null && t == null;
    }
    if (s.val != t.val) {
      return false;
    }
    return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
  }

  //  https://www.youtube.com/watch?v=E36O5SWp-LE&ab_channel=NeetCode
  public static boolean isSubtree(TreeNode s, TreeNode t) {
    //  since leafs of big tree has "null" children, hence "null" is also a subtree
//    if (t == null) {
//      return true;
//    }
    //  if bigger tree is null, it cannot have subtree
    if (s == null) {
      return false;
    }
    //  is same tree from root
    if (isSameTree(s, t)) {
      return true;
    }
    //  check for subtree in left or right children
    return isSameTree(s.left, t) || isSameTree(s.right, t);
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(4);
    root.right = new TreeNode(5);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(2);
    TreeNode subTree = new TreeNode(4);
    subTree.left = new TreeNode(1);
    subTree.right = new TreeNode(2);
    System.out.println("yup: 1st isSubtree: " + isSubtreee(root, subTree));  //  yup: isSubtree: true
    root.left.right.left = new TreeNode(0);
    System.out.println(
        "yup: 2nd isSubtree: " + isSubtreee(root, subTree));  //  yup: isSubtree: false
  }
}
