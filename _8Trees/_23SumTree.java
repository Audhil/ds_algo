package _8Trees;

//  https://www.youtube.com/watch?v=-1SIodPrhss&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=27
//  notes @ https://photos.google.com/photo/AF1QipMYR_aF_PJlUbr6XG4Awj4h1lGTok2429WrDzR7
public class _23SumTree {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    static class BoolWrapper {
        boolean isSumTree;

        public BoolWrapper(boolean isSumTree) {
            this.isSumTree = isSumTree;
        }
    }

    private static int checkIsSumTree(TreeNode root, BoolWrapper result) {
        //  if node not exists
        if (root == null)
            return 0;

        //  if it is leaf node
        if (root.left == null && root.right == null)
            return root.value;

        int lSum = checkIsSumTree(root.left, result);
        int rSum = checkIsSumTree(root.right, result);

        result.isSumTree = (root.value != lSum + rSum);

        return root.value + lSum + rSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(22);
        root.left = new TreeNode(6);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(4);

        BoolWrapper result = new BoolWrapper(true);
        System.out.println("yup: Sum tree: " + checkIsSumTree(root, result));
        System.out.println("yup is Sum tree property satisfied: " + result.isSumTree);
    }
}
