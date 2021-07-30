package _8Trees;

//  https://www.youtube.com/watch?v=OGaFSa0-3IE&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=31
//  notes @ https://photos.google.com/photo/AF1QipMLJZOvlcllso9ZYvyIfEyTtzishEg9hRxHnsFA
public class _27NodesOnSamePath {

    //  1. find lca
    //  2. avoid if nodes are returned from left or right
    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    static class BoolWrapper {
        boolean isOnSamePath = true;
    }

    private static TreeNode lca(TreeNode root, int node1, int node2, BoolWrapper boolWrapper) {
        if (root == null)
            return null;

        if (root.value == node1 || root.value == node2)
            return root;

        TreeNode left = lca(root.left, node1, node2, boolWrapper);
        TreeNode right = lca(root.right, node1, node2, boolWrapper);

        if (left != null && right != null) {
            boolWrapper.isOnSamePath = false;
            return root;
        }

        if (left != null)
            return left;

        return right;
    }

    private static void isNodesOnSamePath(TreeNode root, int node1, int node2, BoolWrapper boolWrapper) {
        lca(root, node1, node2, boolWrapper);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(9);
        root.left.right.left = new TreeNode(8);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        //  is node 6 & 7 lies in same path
        BoolWrapper boolWrapper = new BoolWrapper();
        isNodesOnSamePath(root, 3, 9, boolWrapper);
        System.out.println("yup: is on same path: " + boolWrapper.isOnSamePath);
    }
}
