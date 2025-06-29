package _8Trees;

//  https://www.youtube.com/watch?v=QadE5vQzBDA&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=33
//  notes @ https://photos.google.com/photo/AF1QipPkwdeBRMo-8auy1krfurYTjKRYrfuxUDijpVmG
public class _29BinaryTreeLeaveToDLLInPlace {

    private static TreeNode head, tail;

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    //  print LL
    private static void printLL(TreeNode head) {
        if (head == null)
            return;

        TreeNode temp = head;
        while (temp != null) {
            System.out.print(temp.value);
            if (temp.right != null)
                System.out.print(" <-> ");
            temp = temp.right;
        }
    }

    //  print tree
    private static void printTreeWithInOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        printTreeWithInOrderTraversal(root.left);
        System.out.print(root.value + " ");
        printTreeWithInOrderTraversal(root.right);
    }

    private static TreeNode binTreeLeavesToLL(TreeNode root) {
        if (root == null)
            return null;

        //  if it is leaf - take & construct LL
        if (root.left == null && root.right == null) {
            if (head == null) {
                head = root;
            } else {
                root.left = tail;
                tail.right = root;
            }
            tail = root;
            return null;    //  remove this leaf from tree
        }
        root.left = binTreeLeavesToLL(root.left);
        root.right = binTreeLeavesToLL(root.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("original tree:");
        printTreeWithInOrderTraversal(root);
        TreeNode rootOfResultantTree = binTreeLeavesToLL(root);
        System.out.println("\nresultant tree:");
        printTreeWithInOrderTraversal(rootOfResultantTree);
        System.out.println("\nresultant LL:");
        printLL(head);

        /*
        * original tree:
            5 2 6 1 3 7
            resultant tree:
            2 1 3
            resultant LL:
            5 <-> 6 <-> 7
        * */
    }
}
