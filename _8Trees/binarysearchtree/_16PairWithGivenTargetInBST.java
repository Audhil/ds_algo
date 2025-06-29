package _8Trees.binarysearchtree;

import java.util.Stack;

//  https://www.youtube.com/watch?v=wkd7e5K7KF8&list=PLNxqWc8Uj2LQpbGv6I_HWf0kTj6kMVVwm&index=18
//  notes @ https://photos.google.com/photo/AF1QipMcVrJ_K-Xuns6ydWAVL3lEyT0gTLXtAaAUplll
public class _16PairWithGivenTargetInBST {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static void loadFromRight(TreeNode root, Stack<TreeNode> stack) {
        TreeNode tempNode = root;
        while (tempNode != null) {
            stack.push(tempNode);
            tempNode = tempNode.right;
        }
    }

    private static void loadFromLeft(TreeNode root, Stack<TreeNode> stack) {
        TreeNode tempNode = root;
        while (tempNode != null) {
            stack.push(tempNode);
            tempNode = tempNode.left;
        }
    }

    private static boolean isPairAvailable(TreeNode root, int target) {
        if (root == null)
            return false;
        Stack<TreeNode> s1 = new Stack<>(); //  stack with smaller items
        Stack<TreeNode> s2 = new Stack<>(); //  stack with bigger items
        loadFromLeft(root, s1);
        loadFromRight(root, s2);

        while (!s1.empty() && !s2.empty() && s1.peek().value < s2.peek().value) {
            TreeNode smallerNode = s1.peek();
            TreeNode biggerNode = s2.peek();
            //  if both nodes are equal - then it is same node, each node in BST is unique
            //  or l side is moved beyond r: remember l > r
            int x = smallerNode.value;
            int y = biggerNode.value;
            if (x > y)
                return false;
            if (x + y == target)
                return true;
            if (x + y < target) {
                s1.pop();
                loadFromLeft(smallerNode.right, s1);   //  load just bigger item than current - it'll be in left most of the right child
            } else if (x + y > target) {
                s2.pop();
                loadFromRight(biggerNode.left, s2);   //  load just smaller item than current - it'll be in right most of the left child
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(70);
        root.left = new TreeNode(50);
        root.right = new TreeNode(80);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(60);
        root.right.right = new TreeNode(90);
        root.left.left.left = new TreeNode(30);
        root.left.right.left = new TreeNode(55);

        int target = 150;
        System.out.println("yup: is pair with given target present: " + isPairAvailable(root, target));
    }
}
