package _10Blind75._7Trees;

//  https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
//  https://www.youtube.com/watch?v=gs2LMfuOR9k&ab_channel=NeetCode
//  refer for variation: java
public class _13LCAofBST_E {

  private static class TreeNode {

    int val;
    TreeNode left, right;

    public TreeNode(int value) {
      this.val = value;
    }
  }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    TreeNode curr = root;
    while (curr != null) {
      if (curr.val < p.val && curr.val < q.val) {
        curr = curr.right;
      } else if (curr.val > p.val && curr.val > q.val) {
        curr = curr.left;
      } else {
        return curr;
      }
    }
    return curr;
  }
}
