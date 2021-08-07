package _8Trees.binarysearchtree;

import java.util.Arrays;
import java.util.List;

//  https://www.youtube.com/watch?v=G_xq6U8h7iQ&list=PLNxqWc8Uj2LQpbGv6I_HWf0kTj6kMVVwm&index=28
//  notes @ https://photos.google.com/photo/AF1QipNj_gfCg3EBbnjMzZWl5upn9BiL2TfzhHiulG1t
public class _27BSTFromPostOrder {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    static class IntWrapper {
        int index = 0;

        public IntWrapper(int index) {
            this.index = index;
        }
    }

    //  tip: always create bst based on given traversal
    public static void main(String[] args) {
        List<Integer> postOrder = Arrays.asList(66, 62, 60, 50, 34, 22, 30, 40);
        TreeNode root = createBST(postOrder);
        System.out.println("postOrder of generated tree is");
        printTree(root);    //  66 62 60 50 34 22 30 40
    }

    //  create bst with pre order
    private static TreeNode createBST(List<Integer> postOrder) {
        return util(postOrder, Integer.MIN_VALUE, Integer.MAX_VALUE, new IntWrapper(postOrder.size() - 1));
    }

    private static TreeNode util(List<Integer> postOrder,
                                 int minValue,
                                 int maxValue,
                                 IntWrapper indexWrapper) {
        if (indexWrapper.index < 0)
            return null;
        //  N
        int value = postOrder.get(indexWrapper.index--);
        TreeNode root = new TreeNode(value);
        //  R
        root.right = util(postOrder, value + 1, maxValue, indexWrapper);
        //  L
        root.left = util(postOrder, minValue, value - 1, indexWrapper);
        return root;
    }

    private static void printTree(TreeNode root) {
        if (root == null)
            return;

        printTree(root.left);
        printTree(root.right);
        System.out.print(root.value + " ");
    }
}
