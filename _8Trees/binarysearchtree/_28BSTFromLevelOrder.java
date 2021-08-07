package _8Trees.binarysearchtree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//  https://www.youtube.com/watch?v=wx1WNSa-zlc&list=PLNxqWc8Uj2LQpbGv6I_HWf0kTj6kMVVwm&index=30
//  notes @ https://photos.google.com/photo/AF1QipPoGmfkd59KkZvJc1zVFMPLilEUrMmKjfZLa4TU
//  TC: O(n^2); SC: O(n^2)
public class _28BSTFromLevelOrder {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static TreeNode constructBST(List<Integer> levelOrder) {
        if (levelOrder.size() == 0)
            return null;
        TreeNode root = new TreeNode(levelOrder.get(0));    //  first element is value of the node
        List<Integer> l = new ArrayList<>();
        List<Integer> r = new ArrayList<>();
        for (int i = 1; i < levelOrder.size(); i++) {
            if (levelOrder.get(i) < root.value)
                l.add(levelOrder.get(i));
            else
                r.add(levelOrder.get(i));
        }
        root.left = constructBST(l);
        root.right = constructBST(r);
        return root;
    }

    //  level order traversal
    private static void printTree(TreeNode root) {
        if (root == null)
            return;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.value + " ");
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }
    }

    public static void main(String[] args) {
        List<Integer> levelOrder = Arrays.asList(50, 45, 57, 42, 55, 56);
        TreeNode resultantRoot = constructBST(levelOrder);
        printTree(resultantRoot);
    }
}
