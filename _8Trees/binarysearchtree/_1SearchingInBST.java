package _8Trees.binarysearchtree;

//  https://www.youtube.com/watch?v=6UrdJAcebsY&list=PLNxqWc8Uj2LQpbGv6I_HWf0kTj6kMVVwm&index=3
public class _1SearchingInBST {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static void printTree(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.value + " ");
        printTree(root.left);
        printTree(root.right);
    }

    private static boolean search(TreeNode root, int value) {
        if (root == null)
            return false;

        if (root.value == value)
            return true;

        if (value < root.value)
            return search(root.left, value);
        else
            return search(root.right, value);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(80);
        root.right = new TreeNode(120);
        root.left.left = new TreeNode(60);
        root.left.right = new TreeNode(90);
        root.right.left = new TreeNode(110);
        root.right.right = new TreeNode(130);
        root.right.left.right = new TreeNode(115);

        printTree(root);

        System.out.println("\nyup: found value : " + search(root, 110));
    }
}
