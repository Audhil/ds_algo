package _8Trees;

import java.util.LinkedList;

//  https://www.youtube.com/watch?v=ait6N1Dihls&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=28
public class _24TransformToSumTree {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static int convertToSumTree(TreeNode root) {
        if (root == null)
            return 0;
        int lSum = convertToSumTree(root.left);
        int rSum = convertToSumTree(root.right);
        int total = root.value + lSum + rSum;
        root.value = lSum + rSum;
        return total;
    }

    private static void printTreeWithLevelOrderTraversal(TreeNode root) {
        if (root == null)
            return;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            System.out.print(tempNode.value + " ");
            if (tempNode.left != null)
                queue.add(tempNode.left);
            if (tempNode.right != null)
                queue.add(tempNode.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        printTreeWithLevelOrderTraversal(root);
        System.out.println("\nyup: convertToSumTree: " + convertToSumTree(root));
        printTreeWithLevelOrderTraversal(root);
    }
}
