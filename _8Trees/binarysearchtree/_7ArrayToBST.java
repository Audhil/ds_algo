package _8Trees.binarysearchtree;

//  https://www.youtube.com/watch?v=zsBve4Esf50&list=PLNxqWc8Uj2LQpbGv6I_HWf0kTj6kMVVwm&index=9
//  notes @ https://photos.google.com/photo/AF1QipPIi1Og2cyOUwJldMcj2EPSeRjDpYTUkrgq96XO
public class _7ArrayToBST {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    //  with in-order traversal
    private static void printTree(TreeNode root) {
        if (root == null)
            return;

        printTree(root.left);
        System.out.print(root.value + " ");
        printTree(root.right);
    }

    private static TreeNode constructTree(int[] nodeArray, int l, int r) {
        if (r < l)
            return null;

        int mid = l + (r - l) / 2;  //  equivalent to (l + r)/2, to avoid number overflow
        TreeNode root = new TreeNode(nodeArray[mid]);
        root.left = constructTree(nodeArray, l, mid - 1);
        root.right = constructTree(nodeArray, mid + 1, r);
        return root;
    }

    public static void main(String[] args) {
        //  sorted array = in order traversal of BST
        int[] nodeArray = {10, 12, 15, 20, 24, 28};
        int l = 0, r = nodeArray.length - 1;
        TreeNode resultantTree = constructTree(nodeArray, l, r);
        System.out.println("resultant Tree is : ");
        printTree(resultantTree);   //  10 12 15 20 24 28
    }
}
