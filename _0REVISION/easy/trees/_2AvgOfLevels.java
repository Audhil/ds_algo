package _0REVISION.easy.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//  https://leetcode.com/problems/average-of-levels-in-binary-tree/
public class _2AvgOfLevels {

  /**
   * Definition for a binary tree node.
   */

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  class Solution {

    public List<Double> averageOfLevels(TreeNode root) {
      List<Double> resList = new ArrayList<>();
      if (root == null) {
        return resList;
      }
      double nodeValue = 0.0;
      double nodeCount = 0.0;

      LinkedList<TreeNode> queue = new LinkedList<>();
      queue.add(root);
      queue.add(null);

      while (!queue.isEmpty()) {
        TreeNode temp = queue.poll();
        if (temp == null) {
          resList.add(nodeValue / nodeCount);
          if (queue.isEmpty()) {
            return resList;
          }
          queue.add(null);
          nodeValue = 0.0;
          nodeCount = 0.0;
        } else {
          nodeValue += temp.val;
          nodeCount += 1;
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
  }
}
