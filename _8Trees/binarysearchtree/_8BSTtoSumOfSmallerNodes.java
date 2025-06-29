package _8Trees.binarysearchtree;

//  https://www.youtube.com/watch?v=ELEsM9oR8_A&list=PLNxqWc8Uj2LQpbGv6I_HWf0kTj6kMVVwm&index=10
//  notes @ https://photos.google.com/photo/AF1QipOyWm05DBM_n6KlEiX05IrVHVmLQscPDovaw_xx
public class _8BSTtoSumOfSmallerNodes {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    static class IntWrapper{
        int prevSum;
    }

    private static TreeNode constructTreeSumOfSmallerNodes(TreeNode root, IntWrapper prevSum) {
        if (root == null)
            return null;

        root.left = constructTreeSumOfSmallerNodes(root.left, prevSum);
        prevSum.prevSum += root.value;
        root.value = prevSum.prevSum;
        root.right = constructTreeSumOfSmallerNodes(root.right, prevSum);
        return root;
    }

    //  with in-order traversal
    private static void printTree(TreeNode root) {
        if (root == null)
            return;

        printTree(root.left);
        System.out.print(root.value + " ");
        printTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(30);
        root.left = new TreeNode(20);
        root.right = new TreeNode(40);
        root.left.left = new TreeNode(13);
        root.left.right = new TreeNode(24);
        root.right.right = new TreeNode(42);
        System.out.println("yup: given tree:");
        printTree(root);
        TreeNode resultantRoot = constructTreeSumOfSmallerNodes(root, new IntWrapper());
        System.out.println("\nyup: resultant tree:");
        printTree(resultantRoot);
    }
}
