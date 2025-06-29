package _8Trees;

//  https://www.youtube.com/watch?v=ikeZzE3PQW0&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=24
//  notes @ https://photos.google.com/photo/AF1QipOBqmFOqNkhLscTCSlWXVtQ5c8ZY8cRJA83TVC5
public class _20CheckForMirrorTrees {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static boolean isMirrorTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null)
            return false;

        if (root1.value != root2.value)
            return false;

        return isMirrorTree(root1.left, root2.right) && isMirrorTree(root1.right, root2.left);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(4);
        root1.right.left.right = new TreeNode(5);

        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.left.right.left = new TreeNode(5);

        System.out.println("yup: is mirror : " + isMirrorTree(root1, root2));
    }
}
