package _8Trees.binarysearchtree;

//  https://www.youtube.com/watch?v=ffKw8v0LH4I&list=PLNxqWc8Uj2LQpbGv6I_HWf0kTj6kMVVwm&index=23
//  notes @ https://photos.google.com/photo/AF1QipNY9etHFlfWtvlfPv1NmYUeLsqDxsmNZ2ri_kil
public class _21LargestBSTinBinTree {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    static class BST {
        boolean isBST;
        int size, min, max;

        public BST(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    private static int largeBST(TreeNode root) {
        BST bst = largestBSTinBinTree(root);
        return bst.size;
    }

    //  POST ORDER - L R N
    private static BST largestBSTinBinTree(TreeNode root) {
        if (root == null)
            return new BST(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);  //  when node is NULL, it is BST

        BST left = largestBSTinBinTree(root.left);
        BST right = largestBSTinBinTree(root.right);

        //  condition for a BST
        if (left.isBST && right.isBST
                && left.max < root.value && right.min > root.value) {
            return new BST(true, 1 + left.size + right.size,
                    Math.min(left.min, root.value),
                    Math.max(right.max, root.value));
        }

        return new BST(false, Math.max(left.size, right.size), -1, -1);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(6);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(8);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(3);
        root.right.left.left = new TreeNode(8);
        root.right.left.right = new TreeNode(2);
        System.out.println("yup: largeBST in bin tree : " + largeBST(root));
    }
}
