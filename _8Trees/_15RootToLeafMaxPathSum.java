package _8Trees;

//  https://www.youtube.com/watch?v=ilw7gqbaSAM&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=19
public class _15RootToLeafMaxPathSum {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    static class IntWrapper {
        int maxSum;

        public IntWrapper(int maxSum) {
            this.maxSum = maxSum;
        }
    }

    private static int maxPathSumInRootToLeaf(TreeNode root) {
        if (root == null)
            return 0;

        int currSum = 0;
        IntWrapper intWrapper = new IntWrapper(0);
        findSumInAllPaths(root, currSum, intWrapper);
        return intWrapper.maxSum;
    }

    private static void findSumInAllPaths(TreeNode root, int currSum, IntWrapper intWrapper) {
        if (root == null)
            return;

        currSum += root.value;

        if (root.left == null && root.right == null)
            intWrapper.maxSum = Math.max(currSum, intWrapper.maxSum);

        findSumInAllPaths(root.left, currSum, intWrapper);
        findSumInAllPaths(root.right, currSum, intWrapper);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(6);
        System.out.println("yup: maxPathSumInRootToLeaf: " + maxPathSumInRootToLeaf(root));
    }
}
