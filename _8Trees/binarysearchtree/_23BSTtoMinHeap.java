package _8Trees.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

//  https://www.youtube.com/watch?v=KT46fMT3ALc&list=PLNxqWc8Uj2LQpbGv6I_HWf0kTj6kMVVwm&index=25
public class _23BSTtoMinHeap {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    static class IntWrapper {
        int index = 0;
    }

    private static void bstToMinHeap(TreeNode root) {
        if (root == null)
            return;

        List<Integer> inOrderList = new ArrayList<>();
        populateInOrderList(root, inOrderList);
        System.out.println("yup: inOrderList: " + inOrderList);
        bstToMinHeapUtil(root, inOrderList, new IntWrapper());
    }

    //  use inorder result, and do pre order and store the result
    private static void bstToMinHeapUtil(
            TreeNode root,
            List<Integer> inOrderList, IntWrapper intWrapper) {
        if (root == null)
            return;

        root.value = inOrderList.get(intWrapper.index++);
        bstToMinHeapUtil(root.left, inOrderList, intWrapper);
        bstToMinHeapUtil(root.right, inOrderList, intWrapper);
    }

    private static void populateInOrderList(TreeNode root, List<Integer> inOrderList) {
        if (root == null)
            return;

        populateInOrderList(root.left, inOrderList);
        inOrderList.add(root.value);
        populateInOrderList(root.right, inOrderList);
    }

    private static void printTree(TreeNode root) {
        if (root == null)
            return;

        printTree(root.left);
        System.out.print(root.value + " ");
        printTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(60);
        root.left = new TreeNode(50);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(55);
        root.right.left = new TreeNode(65);

        System.out.println("yup: original tree is : ");
        printTree(root);    //  40 50 55 60 65 70
        System.out.println();
        bstToMinHeap(root);
        System.out.println("yup: min heap is: ");
        printTree(root);    //
    }
}
