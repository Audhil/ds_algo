package _0medium;

//  https://www.youtube.com/watch?v=C_LA6SOwVTM
/*
 * Given a singly linked list, group all odd nodes together followed by even nodes.
 * Pls, note here we are talking about the node number and the value in the nodes
 *
 * You should try to do it in place. The program should run O(1) space complexity and O(nodes) time complexity.
 *
 * ex 1.
 * input : 1 -> 2 -> 3 -> 4 -> 5 -> NULL
 * o/p : 1 -> 3 -> 5 -> 2 -> 4 -> NULL
 *
 * ex 2.
 * input : 2 1 3 5 6 4 7 -> NULL
 * o/p : 2 -> 3 -> 6 7 1 5 4 -> NULL
 *
 * Note:
 * 1. The relative order inside both the even and odd groups should remain as it was in the input.
 * 2. The first node is considered odd, the second node even and so on....
 * */
public class OddEvenLinkedList {

    public static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        if (head == null)
            return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void printLL(ListNode head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.print("NULL");
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        printLL(head);
        oddEvenList(head);
        printLL(head);

//        * input : 2 1 3 5 6 4 7 -> NULL
//                * o/p : 2 -> 3 -> 6 7 1 5 4 -> NULL
        ListNode head2 = new ListNode(2, new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(7, null)))))));
        printLL(head2);
        oddEvenList(head2);
        printLL(head2);
    }
}
