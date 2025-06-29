package _8Trees.binarysearchtree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//  https://www.youtube.com/watch?v=mtB2E6nVl9w&list=PLNxqWc8Uj2LQpbGv6I_HWf0kTj6kMVVwm&index=31
//  notes @ https://photos.google.com/photo/AF1QipOo_pYOhIfeFOVEp9Pr_8OiPsyIU7yzen-nuakD
public class _29BalancedBSTfromLL {

    static class TreeNode {
        TreeNode left, right;
        int data;
    }

    private static TreeNode constructBST(LinkedList<Integer> linkedList, int n) {
        if (n == 0)
            return null;

        TreeNode root = new TreeNode();
        //  L
        root.left = constructBST(linkedList, n / 2);

        //  N
        root.data = linkedList.poll();

        //  N
        root.right = constructBST(linkedList, (n - 1) / 2);
        return root;
    }

    private static void printTree(TreeNode root) {
        if (root == null)
            return;

        printTree(root.left);
        System.out.print(root.data + " ");
        printTree(root.right);
    }

    public static void main(String[] args) {
        List<Integer> ll = Arrays.asList(1, 5, 9, 12, 15);  //  in order traversal
        LinkedList<Integer> linkedList = new LinkedList<>(ll);
        TreeNode root = constructBST(linkedList, linkedList.size());
        System.out.println("yup: inorder traversal of resultant tree:");
        printTree(root);
    }
}
