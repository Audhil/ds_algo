package _8Trees.binarysearchtree;

//  https://www.youtube.com/watch?v=h8Z3oTdLRJI&list=PLNxqWc8Uj2LQpbGv6I_HWf0kTj6kMVVwm&index=24
//  notes @ https://photos.google.com/photo/AF1QipP-KICQ4uqHwIYnw_RzbECaAi9gnZyV_mFyk9Cx
public class _22BSTtoGreaterSumTree {

    //  node value + greater items => for eg., if 50 is node value, 50 + 60+55+65;
    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    static class IntWrapper {
        int sum;
    }

    //  R N L
    private static TreeNode bstToGreaterSumTree(TreeNode root, IntWrapper wrapper) {
        if (root == null)
            return null;

        //  right
        root.right = bstToGreaterSumTree(root.right, wrapper);

        //  node
        wrapper.sum += root.value;
        root.value = wrapper.sum;

        //  left
        root.left = bstToGreaterSumTree(root.left, wrapper);

        return root;
    }

    private static void printTree(TreeNode root) {
        if (root == null)
            return;

        printTree(root.left);
        System.out.print(root.value + " ");
        printTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(40);
        root.right = new TreeNode(60);
        root.left.left = new TreeNode(30);
        root.left.right = new TreeNode(45);
        root.right.left = new TreeNode(55);
        root.right.right = new TreeNode(65);

        System.out.println("yup: original tree is : ");
        printTree(root);    //  op: 30 40 45 50 55 60 65
        System.out.println("\nyup: greater sum tree is: ");
        IntWrapper intWrapper = new IntWrapper();
        TreeNode updatedRoot = bstToGreaterSumTree(root, intWrapper);
        printTree(updatedRoot); //  op: 345 315 275 230 180 125 65
    }
}
