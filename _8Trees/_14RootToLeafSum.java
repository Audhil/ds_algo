package _8Trees;

//  https://www.youtube.com/watch?v=d72IorYkMyw&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=19
public class _14RootToLeafSum {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    static class BoolWrapper {
        boolean isSumDetected;

        public BoolWrapper(boolean bool) {
            this.isSumDetected = bool;
        }
    }

    private static boolean isSumDetectedInRootToLeaf(TreeNode root, int givenSum) {
        if (root == null)
            return false;

        BoolWrapper boolWrapper = new BoolWrapper(false);
        int currSum = 0;
        findSumInAllPaths(root, currSum, givenSum, boolWrapper);
        return boolWrapper.isSumDetected;
    }

    private static void findSumInAllPaths(TreeNode root, int currSum, int givenSum, BoolWrapper boolWrapper) {
        if (root == null)
            return;

        currSum += root.value;

        if (root.left == null && root.right == null) {
            if (currSum == givenSum)
                boolWrapper.isSumDetected = true;
        }

        findSumInAllPaths(root.left, currSum, givenSum, boolWrapper);
        findSumInAllPaths(root.right, currSum, givenSum, boolWrapper);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(6);

        System.out.println("yup: sum detected: " + isSumDetectedInRootToLeaf(root, 1));
    }
}
