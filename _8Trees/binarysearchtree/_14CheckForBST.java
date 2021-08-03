package _8Trees.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

//  https://www.youtube.com/watch?v=0AZnGVgXKtY&list=PLNxqWc8Uj2LQpbGv6I_HWf0kTj6kMVVwm&index=16
public class _14CheckForBST {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    //  method 1: O(n^2) time complexity, whereas for skew tree it is O(n) (surprisingly)
    //  go to left, and take right up to leaf for smaller(greatest of smaller) than the node, for each node
    //  go to right, and take left up to leaf for greater(smallest of greater) than the node, for each node
    private static boolean helperFunc(TreeNode root) {
        //  check greatest of smaller
        TreeNode temp = root.left;
        while (temp != null) {
            if (temp.value > root.value)
                return false;
            temp = temp.right;
        }

        //  check smallest of grater
        temp = root.right;
        while (temp != null) {
            if (temp.value < root.value)
                return false;
            temp = temp.left;
        }
        return true;
    }

    private static boolean isBST(TreeNode root) {
        if (root == null)
            return false;

        return helperFunc(root) && helperFunc(root.left) && helperFunc(root.right);
    }

    //  method 2: O(n) time complexity - find inorder traversal(it'll be ascending order for BST), compare prev with current item
    private static void helperFunc2(TreeNode root, List<Integer> inOrderTraversal) {
        if (root == null)
            return;

        helperFunc2(root.left, inOrderTraversal);
        inOrderTraversal.add(root.value);
        helperFunc2(root.right, inOrderTraversal);
    }

    private static boolean isBST2(TreeNode root) {
        if (root == null)
            return false;

        List<Integer> inOrderTraversal = new ArrayList<>();
        helperFunc2(root, inOrderTraversal);
        int prev = -1;
        for (Integer item : inOrderTraversal) {
            if (prev > item)
                return false;
            prev = item;
        }
        return true;
    }

    //  method 3: https://photos.google.com/photo/AF1QipOaRRquZjYDREOvwfgnt6dX5ZQYy_MLKOX7i3OI
    private static boolean isBST3(TreeNode root) {
        if (root == null)
            return false;
        int l = Integer.MIN_VALUE, r = Integer.MAX_VALUE;
        return helperFunc3(root, l, r);
    }

    private static boolean helperFunc3(TreeNode root, int l, int r) {
        if (root == null)
            return true;

        if (root.value < l || root.value > r)
            return false;

        if (l > r)
            return false;

        return helperFunc3(root.left, l, root.value - 1) && helperFunc3(root.right, root.value + 1, r);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(40);
        root.right = new TreeNode(60);
        root.left.left = new TreeNode(30);
        root.left.right = new TreeNode(45);
        root.right.right = new TreeNode(65);
        root.right.right.left = new TreeNode(63);
//        uncomment for adding wrong node, prevent making it as BST
//        root.left.right.right = new TreeNode(51);
        System.out.println("yup 1st approach, is it BST? : " + isBST(root));
        System.out.println("yup 2nd approach, is it BST? : " + isBST2(root));
        System.out.println("yup 3rd approach, is it BST? : " + isBST3(root));
    }
}
