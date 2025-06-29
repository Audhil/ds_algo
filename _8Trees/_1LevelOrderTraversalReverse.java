package _8Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//  https://www.youtube.com/watch?v=kMlhcT9v9sk
//  https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
public class _1LevelOrderTraversalReverse {

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

        class Solution {
            public List<List<Integer>> levelOrderBottom(TreeNode root) {
                List<List<Integer>> list = new ArrayList<>();
                if (root == null)
                    return list;

                List<Integer> tempList = new ArrayList<>();
                LinkedList<TreeNode> queue = new LinkedList<>();
                queue.add(root);
                queue.add(null);

                while (!queue.isEmpty()) {
                    TreeNode tempNode = queue.poll();
                    if (tempNode == null) {
                        list.add(0, tempList);
                        tempList = new ArrayList<>();

                        if (queue.isEmpty()) {
                            return list;
                        }
                        queue.add(null);
                    } else {
                        tempList.add(tempNode.val);
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
}