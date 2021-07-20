package _8Trees;

import java.util.Stack;

//  https://www.youtube.com/watch?v=iJT9JrrFQ44&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=6
public class _2ZigZagTraversal {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static void zigZagTraversal(TreeNode root) {
        if(root == null)
            return;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);

        while (!s1.isEmpty()) {
            while (!s1.isEmpty()) {
                TreeNode temp = s1.pop();
                System.out.print(temp.value + " ");
                if (temp.right != null)
                    s2.push(temp.right);
                if (temp.left != null)
                    s2.push(temp.left);
            }
            while (!s2.isEmpty()) {
                TreeNode temp = s2.pop();
                System.out.print(temp.value + " ");
                if (temp.left != null)
                    s1.push(temp.left);
                if (temp.right != null)
                    s1.push(temp.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        zigZagTraversal(root);
    }
}
