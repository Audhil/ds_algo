package _8Trees.binarysearchtree;

public class _12KthLargestElementInBST {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    static class IntWrapper {
        int num;

        public IntWrapper(int num) {
            this.num = num;
        }
    }

    //  1. do inorder traversal(since it is BST) & find kth largest element
    //  RNL - iterate from last item
    private static void findKthLargestElement(TreeNode root, IntWrapper result, IntWrapper kObj) {
        if (root == null)
            return;

        if (kObj.num <= 0)
            return;

        findKthLargestElement(root.right, result, kObj);
        kObj.num--;
        if (kObj.num == 0) {
            result.num = root.value;
            return;
        }
        findKthLargestElement(root.left, result, kObj);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(30);
        root.right = new TreeNode(60);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(35);
        root.right.right = new TreeNode(70);
        root.left.left.left = new TreeNode(10);
        root.left.right.right = new TreeNode(37);
        root.right.right.right = new TreeNode(80);

        IntWrapper res = new IntWrapper(0);
        IntWrapper kObj = new IntWrapper(3);    //  k = 3
        findKthLargestElement(root, res, kObj);
        System.out.println("yup: KthSmallestElement: " + res.num);
    }
}
