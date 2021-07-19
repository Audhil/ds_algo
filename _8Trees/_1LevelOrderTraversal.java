package _8Trees;

import java.util.LinkedList;

//  https://www.youtube.com/watch?v=nWUy8MKrzXE&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=5
public class _1LevelOrderTraversal {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    //  1) Traversing tree from level 0 to last level from left to right
    private static void l2rT2Btraversal(TreeNode root) {
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
        root.right.right = new TreeNode(6);

        System.out.println("l2rT2Btraversal: ");
        l2rT2Btraversal(root);  //  1 2 3 4 5 6
    }
}
