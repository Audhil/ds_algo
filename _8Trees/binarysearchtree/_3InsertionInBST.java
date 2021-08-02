package _8Trees.binarysearchtree;

//  https://www.youtube.com/watch?v=xI0l7gun1rw&list=PLNxqWc8Uj2LQpbGv6I_HWf0kTj6kMVVwm&index=5
//  notes @ https://photos.google.com/photo/AF1QipN6kKg3NauzlC7Q8GLEWFgy__qi32w1KYhgDKTc
public class _3InsertionInBST {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static TreeNode insert(TreeNode root, int item) {
        if (root == null)
            return new TreeNode(item);
        if (item == root.value)
            return root;
        if (item < root.value)
            root.left = insert(root.left, item);
        else
            root.right = insert(root.right, item);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(30);
        root.left = new TreeNode(25);
        root.right = new TreeNode(35);
        root.left.left = new TreeNode(22);
        root.left.right = new TreeNode(27);
        root.right.left = new TreeNode(33);
        root.right.right = new TreeNode(37);

        TreeNode updatedRoot = insert(root, 36);
        printTree(updatedRoot);
    }

    private static void printTree(TreeNode updatedRoot) {
        if (updatedRoot == null)
            return;
        printTree(updatedRoot.left);
        System.out.print(updatedRoot.value + " ");
        printTree(updatedRoot.right);
    }
}
