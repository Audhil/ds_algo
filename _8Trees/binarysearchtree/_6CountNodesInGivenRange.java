package _8Trees.binarysearchtree;

//  https://www.youtube.com/watch?v=9deLPrlUwpA&list=PLNxqWc8Uj2LQpbGv6I_HWf0kTj6kMVVwm&index=8
//  notes @ https://photos.google.com/photo/AF1QipPkY_59tY_2DK5d6a9MGk6q0TtModFuHbZWum7Y
public class _6CountNodesInGivenRange {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    static class IntWrapper {
        int count = 0;
    }

    private static void countNodesInRange(TreeNode root, int left, int right, IntWrapper intWrapper) {
        if (root == null)
            return;

        if (root.value >= left && root.value <= right)
            intWrapper.count++;
        if (left < root.value)
            countNodesInRange(root.left, left, right, intWrapper);
        if (right > root.value)
            countNodesInRange(root.right, left, right, intWrapper);
    }

    private static void printTree(TreeNode root) {
        if (root == null)
            return;

        printTree(root.left);
        System.out.print(root.value + " ");
        printTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(20);
        root.right = new TreeNode(50);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(25);
        root.right.left = new TreeNode(45);
        root.right.right = new TreeNode(70);
        root.left.right.left = new TreeNode(22);
        root.right.left.right = new TreeNode(47);
        System.out.println("yup: inOrder traversal:");
        printTree(root);
        IntWrapper countWrapper = new IntWrapper();
        countNodesInRange(root, 20, 30, countWrapper);
        System.out.println("\nyup: no of node: " + countWrapper.count);
    }
}
