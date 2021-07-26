package _8Trees;

//  https://www.youtube.com/watch?v=BE2MufZzUWw&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=10
public class _6IsBalancedTree {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    static class BoolWrapper {
        boolean isBalanced;

        public BoolWrapper(boolean bool) {
            this.isBalanced = bool;
        }
    }

    private static int heightOfBinaryTree(TreeNode root, BoolWrapper boolWrapper) {
        if (root == null)
            return 0;
        int lH = heightOfBinaryTree(root.left, boolWrapper);
        int rH = heightOfBinaryTree(root.right, boolWrapper);
        if (Math.abs(lH - rH) > 1)
            boolWrapper.isBalanced = false;
        return 1 + Math.max(lH, rH); //  1 + max of left/right sub tree
    }

    private static boolean isBalancedTree(TreeNode root) {
        BoolWrapper boolWrapper = new BoolWrapper(true);
        heightOfBinaryTree(root, boolWrapper);
        return boolWrapper.isBalanced;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(5);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(7);

        System.out.println("yup: is balanced tree: " + isBalancedTree(root));
    }
}
