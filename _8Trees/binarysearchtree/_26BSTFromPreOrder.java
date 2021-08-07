package _8Trees.binarysearchtree;

import java.util.Arrays;
import java.util.List;

//  https://www.youtube.com/watch?v=JFamtlrh6PQ&list=PLNxqWc8Uj2LQpbGv6I_HWf0kTj6kMVVwm&index=27
//  notes @ https://photos.google.com/photo/AF1QipPTMiYqwvFcnWxIRUI3joVhw05MSquVLdeEm2cO
public class _26BSTFromPreOrder {

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

    //  tip: always create bst based on given traversal
    public static void main(String[] args) {
        List<Integer> preOrder = Arrays.asList(40, 30, 22, 34, 50, 60, 62, 66);
        TreeNode root = createBST(preOrder);
        System.out.println("preOrder of generated tree is");
        printTree(root);
    }

    //  create bst with pre order
    private static TreeNode createBST(List<Integer> preOrder) {
        return util(preOrder, Integer.MIN_VALUE, Integer.MAX_VALUE, new IntWrapper());
    }

    private static TreeNode util(List<Integer> preOrder,
                                 int minValue,
                                 int maxValue,
                                 IntWrapper indexWrapper) {
        if (indexWrapper.index >= preOrder.size())
            return null;
        int value = preOrder.get(indexWrapper.index++);
        TreeNode root = new TreeNode(value);
        root.left = util(preOrder, minValue, value - 1, indexWrapper);
        root.right = util(preOrder, value + 1, maxValue, indexWrapper);
        return root;
    }

    private static void printTree(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.value + " ");
        printTree(root.left);
        printTree(root.right);
    }
}
