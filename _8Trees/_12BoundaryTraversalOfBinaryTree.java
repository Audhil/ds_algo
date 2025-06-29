package _8Trees;

import java.util.ArrayList;
import java.util.List;

//  https://www.youtube.com/watch?v=Csk6QEFyrtQ&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=16
//  src code: https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
//  notes @ https://photos.google.com/photo/AF1QipOLHHRTeFuIxy3RbrOB4pVVXUp1jghKMJx9WQqw
public class _12BoundaryTraversalOfBinaryTree {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static List<Integer> boundaryTraversal(TreeNode root) {
        if (root == null)
            return null;
        List<Integer> boundaryList = new ArrayList<>();
        boundaryList.add(root.value);
        if (root.left == null && root.right == null)
            return boundaryList;
        leftBoundary(root.left, boundaryList);
        leafNodesByInOrderTraversal(root, boundaryList);
        rightBoundary(root.right, boundaryList);
        return boundaryList;
    }

    private static void leafNodesByInOrderTraversal(TreeNode root, List<Integer> boundaryList) {
        if (root == null)
            return;

        leafNodesByInOrderTraversal(root.left, boundaryList);
        //  add only leaf nodes
        if (root.left == null && root.right == null)
            boundaryList.add(root.value);
        leafNodesByInOrderTraversal(root.right, boundaryList);
    }

    private static void leftBoundary(TreeNode root, List<Integer> boundaryList) {
        if (root == null)
            return;

        //  move to left, move to right
        if (root.left != null) {
            boundaryList.add(root.value);   //  add node's value only if it is NOT a leaf node
            leftBoundary(root.left, boundaryList);
        } else if (root.right != null) {
            boundaryList.add(root.value);   //  add node's value only if it is NOT a leaf node
            leftBoundary(root.right, boundaryList);
        }
    }

    private static void rightBoundary(TreeNode root, List<Integer> boundaryList) {
        if (root == null)
            return;

        //  to get right boundary from bottom to top, we need to go to deep
        //  move to right, move to left
        if (root.right != null) {
            rightBoundary(root.right, boundaryList);
            boundaryList.add(root.value);   //  add node's value only if it is NOT a leaf node
        } else if (root.left != null) {
            rightBoundary(root.left, boundaryList);
            boundaryList.add(root.value);   //  add node's value only if it is NOT a leaf node
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(4);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(7);
        root.right.right.left.left = new TreeNode(9);

        System.out.println("yup: boundary traversal : " + boundaryTraversal(root)); //  yup: boundary traversal : [1, 2, 3, 4, 8, 9, 7, 6, 5]
    }
}