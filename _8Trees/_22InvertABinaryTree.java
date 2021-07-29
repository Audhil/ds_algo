package _8Trees;

import java.util.LinkedList;

//  https://www.youtube.com/watch?v=dq7pRKEFnFA&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=26
//  notes @ https://photos.google.com/photo/AF1QipMu8PRvwgmGCLs-vyOey_Sd9rNqxPSMeKhjgHr3
public class _22InvertABinaryTree {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static TreeNode invertABinaryTree(TreeNode root) {
        if (root == null)
            return null;
        invert(root);
        return root;
    }

    private static void invert(TreeNode root) {
        if (root == null)
            return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invert(root.left);
        invert(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        printBinaryTreeWithLevelOrder(root);

        root = invertABinaryTree(root);

        System.out.println("\nyup: after inverting a binary tree: ");
        printBinaryTreeWithLevelOrder(root);
    }

    private static void printBinaryTreeWithLevelOrder(TreeNode root) {
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
}
