package _0easy;

//  https://leetcode.com/problems/plus-one-linked-list/
//  https://www.programcreek.com/2014/08/leetcode-plus-one-linked-list-java/
/*
* Given a non-negative number represented as a singly linked list of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
Example:

Input:
1->2->3

Output:
1->2->4
*/
public class PlusOneLinkedList {

    static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }
    }

    public static ListNode plusOne(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode reverseLL = reverseLL(head);
        if (reverseLL.data < 9) {
            reverseLL.data += 1;
            return reverseLL(reverseLL);
        } else {
            ListNode tempp = reverseLL;
            while (tempp != null) {
                if (tempp.data + 1 <= 9) {
                    tempp.data += 1;
                    break;
                } else {
                    tempp.data = 0;
                    if (tempp.next == null) {
                        tempp.next = new ListNode(1, null);
                        break;
                    }
                    tempp = tempp.next;
                }
            }
            return reverseLL(reverseLL);
        }
    }

    public static ListNode reverseLL(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode p1 = head;
        ListNode p2 = p1.next;

        while (p2 != null) {
            ListNode tempNode = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = tempNode;
        }
        head.next = null;
        return p1;
    }

    public static void printLL(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.println("yup: it is : " + temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, null)));
//        printLL(head);
//        ListNode rev = reverseLL(head);
//        printLL(rev);
//        ListNode pOneNode = plusOne(head);
//        printLL(pOneNode);

//        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(9, null)));
//        ListNode pOneNode2 = plusOne(head2);
//        printLL(pOneNode2);

        ListNode head2 = new ListNode(1, new ListNode(9, new ListNode(9, null)));
        ListNode pOneNode2 = plusOne(head2);
        printLL(pOneNode2);
    }
}
