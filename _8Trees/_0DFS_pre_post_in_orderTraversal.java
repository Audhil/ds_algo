package _8Trees;

//  https://www.youtube.com/watch?v=VErhxEsQ4LM&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=3
//  notes @ https://photos.google.com/photo/AF1QipMxsANtViULScejrMdGRVBbabrTXbQzG2HKsAjV
public class _0DFS_pre_post_in_orderTraversal {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    //  pre order -> Ro L R
    private static void preOrder(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //  post order -> L R Ro
    private static void postOrder(TreeNode root) {
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " ");
    }

    //  in order -> L Ro R
    private static void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.value + " ");
        inOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(2);

        System.out.println("preOrder: ");
        preOrder(root);                     //  1 3 6 4 7 8 2
        System.out.println("\npostOrder: ");
        postOrder(root);                    //  6 4 3 8 2 7 1
        System.out.println("\ninOrder: ");
        inOrder(root);                      //  6 3 4 1 8 7 2
    }
}
