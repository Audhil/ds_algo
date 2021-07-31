package _8Trees;

import java.util.Arrays;
import java.util.List;

//  https://www.youtube.com/watch?v=5F9NoBFPlCw&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=36
//  TC: O(n^2)
//  we can reach TC: O(n) - when we reduce searchMid functionality with generating map of inOrderTraversal
//  notes @ https://photos.google.com/photo/AF1QipMAQov-xv0UalepQpQ_fj5aD2jxa6Tg-0LbDEpR
public class _31BuildTreeWithPreAndInOrders {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    static class IntWrapper {
        int start = 0;
    }

    //  with pre order traversal
    private static void printTree(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.value + " ");
        printTree(root.left);
        printTree(root.right);
    }

    private static TreeNode buildTree(List<Integer> preOrderTraversal,
                                      List<Integer> inOrderTraversal,
                                      IntWrapper startIndexWrapper,
                                      int inOrderStartIndex,
                                      int inOrderEndIndex) {
        if(startIndexWrapper.start == preOrderTraversal.size())
            return null;
        if (inOrderStartIndex > inOrderEndIndex)
            return null;
        TreeNode root = new TreeNode(preOrderTraversal.get(startIndexWrapper.start));
        int mid = searchMid(preOrderTraversal.get(startIndexWrapper.start), inOrderTraversal, inOrderStartIndex, inOrderEndIndex);
        startIndexWrapper.start++;
        root.left = buildTree(preOrderTraversal, inOrderTraversal, startIndexWrapper, inOrderStartIndex, mid - 1);
        root.right = buildTree(preOrderTraversal, inOrderTraversal, startIndexWrapper, mid + 1, inOrderEndIndex);
        return root;
    }

    private static int searchMid(
            int item,
            List<Integer> inOrderTraversal,
            int inOrderStartIndex,
            int inOrderEndIndex) {
        for (int i = inOrderStartIndex; i < inOrderEndIndex; i++) {
            if (inOrderTraversal.get(i) == item)
                return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        List<Integer> preOrderTraversal = Arrays.asList(1, 2, 4, 5, 3, 7);
        List<Integer> inOrderTraversal = Arrays.asList(4, 2, 5, 1, 3, 7);
        IntWrapper startIndexWrapper = new IntWrapper();
        int inOrderStartIndex = 0;
        int inOrderEndIndex = inOrderTraversal.size();
        TreeNode root = buildTree(preOrderTraversal, inOrderTraversal, startIndexWrapper, inOrderStartIndex, inOrderEndIndex);
        System.out.println("yup: with preorder traversal resultant tree is: ");
        printTree(root);  //  1 2 4 5 3 7
    }
}
