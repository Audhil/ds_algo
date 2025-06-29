package _0REVISION.easy.arrays;

import java.util.*;

//  https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
public class _2TwoSumsWithBST {

    public class TreeNode {
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

    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;

        List<Integer> inOrderTraversal = new ArrayList<>();
        inOrder(root, inOrderTraversal);    //  since in order traversal of BST is always sorted

        int i = 0, j = inOrderTraversal.size() - 1;
        while (i < j) {
            if (inOrderTraversal.get(i) + inOrderTraversal.get(j) > k)
                j--;
            else if (inOrderTraversal.get(i) + inOrderTraversal.get(j) < k)
                i++;
            else
                return true;
        }
        return false;
    }

    private void inOrder(TreeNode root, List<Integer> inOrderTraversal) {
        if (root == null)
            return;

        inOrder(root.left, inOrderTraversal);
        inOrderTraversal.add(root.val);
        inOrder(root.right, inOrderTraversal);
    }
}
