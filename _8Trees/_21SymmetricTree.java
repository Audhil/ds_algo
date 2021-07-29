package _8Trees;

//  https://www.youtube.com/watch?v=0lWSVAnKvWY&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=25
//  notes @ https://photos.google.com/photo/AF1QipPds6FiPbrzWy5BH9Gzy-VD_n9Ym9Gf05o5EnES
public class _21SymmetricTree {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;

        if (left == null || right == null)
            return false;

        if (left.value != right.value)
            return false;

        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    private static boolean isSymmetricTree(TreeNode root) {
        if (root == null)
            return true;
        return isMirror(root.left, root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(5);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        root.right.left.right = new TreeNode(51);

        System.out.println("yup: is symmetric tree : " + isSymmetricTree(root));
    }
}
