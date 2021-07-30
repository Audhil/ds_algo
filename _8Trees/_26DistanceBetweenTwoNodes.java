package _8Trees;

//  https://www.youtube.com/watch?v=BQfbNYvVIrE&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=30
public class _26DistanceBetweenTwoNodes {

    /*
     * dist b/w a, b = dist(lca, a) + dist(lca, b)
     * */

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

        return right;
    }

    private static int distance(TreeNode node, int nodeValue, int dist) {
        if (node == null)
            return 0;
        if (node.value == nodeValue)
            return dist;
        return distance(node.left, nodeValue, dist + 1) + distance(node.right, nodeValue, dist + 1);
    }

    private static int distanceBetweenNodes(TreeNode root, int a, int b) {
        if (root == null)
            return -1;

        TreeNode lca = lca(root, a, b);
        if (lca == null)
            return -1;

        return distance(lca, a, 0) + distance(lca, b, 0);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(8);
        root.left.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(7);

        System.out.println("yup: distanceBetweenNodes : " + distanceBetweenNodes(root, 6, 5));
    }
}
