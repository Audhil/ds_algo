package _8Trees.binarysearchtree;

//  https://www.youtube.com/watch?v=G5iLdUn2p0g&list=PLNxqWc8Uj2LQpbGv6I_HWf0kTj6kMVVwm&index=19
//  notes @ https://photos.google.com/photo/AF1QipPXLSJgxKfkJMX5hJ0137xcww1tIAcrzdeTnXhA
public class _17ClosestElementInBST {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static int closest(TreeNode root, int target) {
        if (root == null)
            return Integer.MAX_VALUE;
        if (root.value == target)
            return 0;
        if (root.value < target)
            return Math.min(Math.abs(target - root.value), closest(root.right, target));
        return Math.min(Math.abs(root.value - target), closest(root.left, target));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(70);
        root.left = new TreeNode(60);
        root.right = new TreeNode(80);
        root.left.left = new TreeNode(50);
        root.left.right = new TreeNode(65);
        root.right.right = new TreeNode(90);
        root.left.left.left = new TreeNode(45);
        root.left.right.right = new TreeNode(67);

        int target = 42;
        System.out.println("yup: closest distance: " + closest(root, target));
    }
}
