package _8Trees;

import java.util.LinkedList;

//  https://www.youtube.com/watch?v=jUoGxk0e71Q&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=12
//  notes @ https://photos.google.com/photo/AF1QipMoqNu9cZtrAgwiLw098vZsCb7K2hpsIei5nZGc
public class _8LeftViewOfBinaryTree {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static void leftView(TreeNode root) {
        if (root == null)
            return;
        boolean isFirst = true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp != null) {
                if (isFirst) {
                    System.out.print(temp.value + " ");
                    isFirst = false;
                }
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
            } else {
                if (!queue.isEmpty()) {
                    queue.add(null);
                    isFirst = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        leftView(root); //  o/p - 1 2 5 7
    }
}
