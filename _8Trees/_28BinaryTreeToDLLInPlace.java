package _8Trees;

//  https://www.youtube.com/watch?v=oNGPjTpsop0&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=32
//  ref: https://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
//  notes @ https://photos.google.com/photo/AF1QipNcxrYiYeZQ7EsudvE60fFjAK_vDwrSh49dkGis
//  converting to DLL - Doubly Linked LIst with InOrder traversal
public class _28BinaryTreeToDLLInPlace {

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

    //  with inplace traversal
    private static void binTreeToDLL(TreeNode root) {
        if (root == null)
            return;

        //  left
        binTreeToDLL(root.left);
        //  process the node
        //  if there's no linked list
        if (head == null)
            head = root;
            //  if we've linked list already
        else {
            root.left = tail;
            tail.right = root;
        }
        tail = root;
        //  right
        binTreeToDLL(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(6);
        root.right.left = new TreeNode(4);

        System.out.println("Print original tree: ");
        printTreeWithInOrderTraversal(root);
        binTreeToDLL(root);
        System.out.println("\nPrint LinkedList: ");
        printLL(head);
    }
}
