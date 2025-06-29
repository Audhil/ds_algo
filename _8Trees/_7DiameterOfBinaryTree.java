package _8Trees;

//  https://www.youtube.com/watch?v=SpIBLZ85lNM&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=11
//  notes @ https://photos.google.com/photo/AF1QipPHITGnbeILcazy4CrJ89EkovaeBORyPYPvd_Z7
public class _7DiameterOfBinaryTree {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    static class IntWrapper {
        int diameter;

        public IntWrapper(int diameter) {
            this.diameter = diameter;
        }
    }

    //  diameter = distance b/w any 2 nodes
    private static int diameterOfTree(TreeNode root) {
        IntWrapper intWrapper = new IntWrapper(0);
        heightOfBinaryTree(root, intWrapper);
        return intWrapper.diameter;
    }

    private static int heightOfBinaryTree(TreeNode root, IntWrapper intWrapper) {
        if (root == null)
            return 0;

        int lH = heightOfBinaryTree(root.left, intWrapper);
        int rH = heightOfBinaryTree(root.right, intWrapper);

        if ((1 + lH + rH) > intWrapper.diameter)
            intWrapper.diameter = 1 + lH + rH;

        return 1 + Math.max(lH, rH);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("yup: diameter of tree: " + diameterOfTree(root));
    }
}
