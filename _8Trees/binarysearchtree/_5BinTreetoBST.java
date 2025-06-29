package _8Trees.binarysearchtree;

import java.util.*;

//  https://www.youtube.com/watch?v=iSZOcOe_TE4&list=PLNxqWc8Uj2LQpbGv6I_HWf0kTj6kMVVwm&index=7
//  notes @ https://photos.google.com/photo/AF1QipObxi_XE9pOjwcihQMjSmI3tthdprdlSyTHG_1l
public class _5BinTreetoBST {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static int index = 0;

    private static TreeNode constructTreeWithInOrder(TreeNode root, List<Integer> list) {
        if (root == null)
            return null;

        root.left = constructTreeWithInOrder(root.left, list);
        root.value = list.get(index++);
        root.right = constructTreeWithInOrder(root.right, list);
        return root;
    }

    private static void getInOrderTraversal(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        getInOrderTraversal(root.left, list);
        list.add(root.value);
        getInOrderTraversal(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(25);
        root.left = new TreeNode(30);
        root.right = new TreeNode(32);
        root.left.left = new TreeNode(17);
        root.left.right = new TreeNode(22);
        root.right.right = new TreeNode(28);

        System.out.println("yup: original tree");
        printTree(root);
        List<Integer> inOrderList = new ArrayList<>();
        getInOrderTraversal(root, inOrderList);
        System.out.println("\nyup: original inOrderList: " + inOrderList);
        Collections.sort(inOrderList);
        System.out.println("yup: original sorted inOrderList: " + inOrderList);
        TreeNode resultantRoot = constructTreeWithInOrder(root, inOrderList);
        System.out.println("yup: resultant tree");
        printTree(resultantRoot);
    }

    private static void printTree(TreeNode root) {
        if (root == null)
            return;

        printTree(root.left);
        System.out.print(root.value + " ");
        printTree(root.right);
    }
}
