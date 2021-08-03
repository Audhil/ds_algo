package _8Trees.binarysearchtree;

//  https://www.youtube.com/watch?v=7jkGLLmdNpE&list=PLNxqWc8Uj2LQpbGv6I_HWf0kTj6kMVVwm&index=15
public class _13LCAwithBST {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static TreeNode lca(TreeNode root, int a, int b) {
        if (root == null)
            return null;

        if (a < root.value && b < root.value)
            return lca(root.left, a, b);
        if (a > root.value && b > root.value)
            return lca(root.right, a, b);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(40);
        root.right.right = new TreeNode(90);
        root.left.left.left = new TreeNode(5);
        root.left.right.left = new TreeNode(35);
        root.right.right.left = new TreeNode(75);

        TreeNode lcaNode = lca(root, 5, 40);
        if (lcaNode == null) {
            System.out.println("yup: NO LCA found");
            return;
        }
        System.out.println("yup: LCA in BST " + lcaNode.value);
    }
}
