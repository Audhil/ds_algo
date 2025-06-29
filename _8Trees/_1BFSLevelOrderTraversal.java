package _8Trees;

import java.util.LinkedList;
import java.util.Stack;

//  https://www.youtube.com/watch?v=nWUy8MKrzXE&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=5
//  notes @ https://photos.google.com/photo/AF1QipM0CXTMN_EBYpLskgAG59ZRGLiboVeV-cgom8L_
//  TC: O(n) & SC: O(n) - https://www.youtube.com/watch?v=WB19NdSzXIo&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=5
public class _1BFSLevelOrderTraversal {

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

    //  2) Traversing tree from level 0 to last level from right to left
    private static void r2lT2Btraversal(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            System.out.print(tempNode.value + " ");
            if (tempNode.right != null)
                queue.add(tempNode.right);
            if (tempNode.left != null)
                queue.add(tempNode.left);
        }
    }

    //  3) Traversing tree from last level to level 0 from left to right
    private static void l2rB2Ttraversal(TreeNode root) {
        Stack<Integer> stack = new Stack<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            stack.push(tempNode.value);
            if (tempNode.right != null)
                queue.add(tempNode.right);
            if (tempNode.left != null)
                queue.add(tempNode.left);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    //  4) Traversing tree from last level to level 0 from right to left
    private static void r2lB2Ttraversal(TreeNode root) {
        Stack<Integer> stack = new Stack<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            stack.push(tempNode.value);
            if (tempNode.left != null)
                queue.add(tempNode.left);
            if (tempNode.right != null)
                queue.add(tempNode.right);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
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
        System.out.println("\nr2lT2Btraversal: ");
        r2lT2Btraversal(root);  //  1 3 2 6 5 4
        System.out.println("\nl2rB2Ttraversal: ");
        l2rB2Ttraversal(root);  //  4 5 6 2 3 1
        System.out.println("\nr2lB2Ttraversal: ");
        r2lB2Ttraversal(root);  //  6 5 4 3 2 1
    }
}
