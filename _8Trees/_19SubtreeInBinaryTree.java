package _8Trees;

import java.util.LinkedList;

//  https://www.youtube.com/watch?v=6OZtYBO3Y7A&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=23
//  notes @ https://photos.google.com/photo/AF1QipPOFF9Km1eaAL2HdWAnncnDI5WAxLuBgosSdnEF
public class _19SubtreeInBinaryTree {

    /*
     * 1. do level order traversal & find the node
     * 2. if found, check isIdentical?
     * 3. return true if both are identical
     * 4. return false if level order traversal is completed
     * */

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static boolean isIdenticalTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null)
            return false;

        if (root1.value != root2.value)
            return false;

        return isIdenticalTrees(root1.left, root2.left) && isIdenticalTrees(root1.right, root2.right);
    }

    private static boolean isSubtreeInBinaryTree(TreeNode root1, TreeNode root2) {
        //  1. reach the node with Level order traversal
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root1);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            if (tempNode.value == root2.value) {
                //  2. is identical true
                if (isIdenticalTrees(tempNode, root2))
                    return true;
            }
            if (tempNode.left != null)
                queue.add(tempNode.left);
            if (tempNode.right != null)
                queue.add(tempNode.right);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(3);
        root1.left.left.left = new TreeNode(4);
        root1.left.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(5);

        System.out.println("yup: isSubtreeInBinaryTree: " + isSubtreeInBinaryTree(root1, root2));
    }
}
