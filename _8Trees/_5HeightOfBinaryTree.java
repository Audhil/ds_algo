package _8Trees;

//  https://www.youtube.com/watch?v=5q42f32rvLs&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=9
//  notes @ https://photos.google.com/photo/AF1QipNob5Gc38OeFvOaKO3XUzA2DsAEshe54V_VFWot
public class _5HeightOfBinaryTree {

    //  height of sub tree -> no of nodes from root to longest leaf node
    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static int heightOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(heightOfBinaryTree(root.left), heightOfBinaryTree(root.right)); //  1 + max of left/right sub tree
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.left.right.right.left = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.right.right = new TreeNode(9);
        System.out.println("height of Binary Tree : " + heightOfBinaryTree(root));
    }
}
