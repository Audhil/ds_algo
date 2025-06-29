package _8Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//  https://leetcode.com/problems/average-of-levels-in-binary-tree/submissions/
public class _1LevelOrderAvgOfLevels {

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
            List<Double> list = new ArrayList<>();
            if (root == null)
                return list;

            double nodeCount = 0.0;
            double value = 0.0;
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            queue.add(null);

            while (!queue.isEmpty()) {
                TreeNode tempNode = queue.poll();
                if (tempNode == null) {
                    list.add((value / nodeCount));
                    if (queue.isEmpty()) {
                        return list;
                    }
                    queue.add(null);
                    nodeCount = 0.0;
                    value = 0.0;
                } else {
                    value += tempNode.val;
                    nodeCount++;
                    if (tempNode.left != null)
                        queue.add(tempNode.left);
                    if (tempNode.right != null)
                        queue.add(tempNode.right);
                }
            }
            return list;
        }
    }
}
