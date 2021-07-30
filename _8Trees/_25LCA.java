package _8Trees;

//  Lowest Common Ancestor - meeting point(node) between given node a, node b
//  https://www.youtube.com/watch?v=cZ0OhoxwaJ8&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=29
//  https://photos.google.com/photo/AF1QipN2xEnagWsB2LGW5HE-iYBS4aVv8eXT4iRmz3Vi
public class _25LCA {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static TreeNode lca(TreeNode root, int a, int b) {
        if (root == null)
            return null;

        if (root.value == a || root.value == b)
            return root;

        TreeNode left = lca(root.left, a, b);
        TreeNode right = lca(root.right, a, b);

        if (left != null && right != null)
            return root;

        if (left != null)
            return left;

        return right;   //  either it'll be value or null
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        /*
         * LCA between
         * 2, 3 -> 1
         * 2, 5 -> 2
         * 5, 6 -> 1
         * */
        System.out.println("LCA : " + lca(root, 5, 6).value);
    }
}
