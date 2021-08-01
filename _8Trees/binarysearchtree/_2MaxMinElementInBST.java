package _8Trees.binarysearchtree;

//  https://www.youtube.com/watch?v=hOHOP8F7j6k&list=PLNxqWc8Uj2LQpbGv6I_HWf0kTj6kMVVwm&index=4
public class _2MaxMinElementInBST {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    //  max item will be at right most end of the tree
    private static TreeNode maxNode(TreeNode root) {
        if (root == null)
            return null;
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    //  min item will be at left most end of the tree
    private static TreeNode minNode(TreeNode root) {
        if (root == null)
            return null;
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(70);
        root.left = new TreeNode(60);
        root.right = new TreeNode(80);
        root.left.left = new TreeNode(55);
        root.left.right = new TreeNode(65);
        root.right.left = new TreeNode(75);
        root.right.right = new TreeNode(85);

        TreeNode minNode = minNode(root);
        System.out.println("yup: min value : " + minNode.value);

        TreeNode maxNode = maxNode(root);
        System.out.println("yup: max value : " + maxNode.value);
    }
}
