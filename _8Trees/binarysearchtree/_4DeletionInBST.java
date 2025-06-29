package _8Trees.binarysearchtree;

//  https://www.youtube.com/watch?v=ogieUAkgLYc&list=PLNxqWc8Uj2LQpbGv6I_HWf0kTj6kMVVwm&index=6
//  notes @ https://photos.google.com/photo/AF1QipMtVpHVGqzQmzdFA8lIUc69uhjnuDECBe-FL8hR
public class _4DeletionInBST {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static TreeNode reachMaxInLeftSide(TreeNode left) {
        if (left == null)
            return null;

        while (left.right != null)
            left = left.right;

        return left;
    }

    private static TreeNode delete(TreeNode root, int item) {
        if (root == null)
            return null;

        if (item < root.value)
            root.left = delete(root.left, item);

        if (item > root.value)
            root.right = delete(root.right, item);

        if (item == root.value) {
            //  if no child remove that node
            if (root.left == null && root.right == null)
                return null;

            //  if it has 2 children
            if (root.left != null && root.right != null) {
                //  find maxItem node from left side of the tree
                TreeNode tempNode = reachMaxInLeftSide(root.left);  //  since it'll be maxItem nearer to the root value
                //  replace the data with root
                root.value = tempNode.value;
                //  delete the maxItem node from left side
                root.left = delete(root.left, tempNode.value);
                return root;
            }

            //  if it has 1 child
            //  only 1 left child
            if (root.left != null)
                return root.left;

            //  only 1 right child
            return root.right;
        }
        return root;
    }

    private static void printTree(TreeNode root) {
        if (root == null)
            return;

        printTree(root.left);
        System.out.print(root.value + " ");
        printTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(40);
        root.left.right = new TreeNode(45);
        root.left.right.left = new TreeNode(43);
        root.right = new TreeNode(60);
        root.right.left = new TreeNode(55);
        root.right.left.right = new TreeNode(57);
        root.right.right = new TreeNode(66);

        printTree(root);
        int deletionItem = 60;
        delete(root, deletionItem);
        System.out.println("\nyup: after deletion of " + deletionItem);
        printTree(root);
    }
}
