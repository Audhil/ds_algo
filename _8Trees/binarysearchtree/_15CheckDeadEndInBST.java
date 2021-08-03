package _8Trees.binarysearchtree;

//  DEAD end = LEAF node where insertion not possible
//  https://www.youtube.com/watch?v=HOP6fucDVTM&list=PLNxqWc8Uj2LQpbGv6I_HWf0kTj6kMVVwm&index=17
//  notes @ https://photos.google.com/photo/AF1QipN1COzt_hduuFq6hcVwQCOMgwTQf0kk0N9wvTR5
public class _15CheckDeadEndInBST {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    static class DeadEndNodeWrapper {
        TreeNode node;
    }

    static class BoolWrapper {
        boolean isDeadEndAvailable = false;
    }

    private static void isDeadEndAvailable(TreeNode root, int l, int r, BoolWrapper resultWrapper, DeadEndNodeWrapper deadEndNode) {
        if (root == null)
            return;
        if (resultWrapper.isDeadEndAvailable)
            return;

        if (root.left == null && root.right == null) {
            if (l == r) {
                resultWrapper.isDeadEndAvailable = true;
                deadEndNode.node = root;
            }
            return;
        }

        isDeadEndAvailable(root.left, l, root.value - 1, resultWrapper, deadEndNode);
        isDeadEndAvailable(root.right, root.value + 1, r, resultWrapper, deadEndNode);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(25);
        root.left = new TreeNode(18);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(17);
        root.left.right = new TreeNode(20);
        root.right.right = new TreeNode(35);
        root.left.right.left = new TreeNode(19);

        int l = Integer.MIN_VALUE, r = Integer.MAX_VALUE;
        BoolWrapper result = new BoolWrapper();
        DeadEndNodeWrapper deadEndNode = new DeadEndNodeWrapper();
        isDeadEndAvailable(root, l, r, result, deadEndNode);
        System.out.println("yup: deadEnd of BST: " + result.isDeadEndAvailable);
        System.out.println("yup: deadEnd of BST: " + deadEndNode.node.value);
    }
}
