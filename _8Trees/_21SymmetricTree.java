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

    private static boolean isMirror(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null)
            return false;

        if (root1.value != root2.value)
            return false;

        return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
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
