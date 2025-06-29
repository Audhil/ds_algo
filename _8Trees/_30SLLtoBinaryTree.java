package _8Trees;

import java.util.ArrayList;
import java.util.List;

//  https://www.youtube.com/watch?v=EKCITexIVLM&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=34
public class _30SLLtoBinaryTree {

    //  convert SLL - complete binary tree(all levels are filled)
    /*
        it is complete binary tree
    *           1
    *         /   \
    *       2      3
    *      /
    *     4
    * */

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    private static void printLL(ListNode head) {
        if (head == null)
            return;

        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.value);
            if (temp.next != null)
                System.out.print(" -> ");
            temp = temp.next;
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

    private static TreeNode sLLtoBinaryTree(ListNode head) {
        if (head == null)
            return null;
        List<TreeNode> tempList = new ArrayList<>();
        ListNode tempHead = head;
        while (tempHead != null) {
            tempList.add(new TreeNode(tempHead.value));
            tempHead = tempHead.next;
        }
        //  convert List nodes to Binary tree
        //  2*i + 1 = Left child, 
        //  2*i + 2 = Right child
        //  N nodes, will have at least N/2 parent nodes
        int size = tempList.size();
        for (int i = 0; i < size / 2; i++) {
            if ((2 * i + 1) < size)
                tempList.get(i).left = tempList.get(2 * i + 1);
            if ((2 * i + 2) < size)
                tempList.get(i).right = tempList.get(2 * i + 2);
        }
        return tempList.get(0);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.println("Given LL:");
        printLL(head);
        System.out.println("\nInOrder traversal of Resultant Tree:");
        TreeNode root = sLLtoBinaryTree(head);
        printTreeWithInOrderTraversal(root);
    }
}
