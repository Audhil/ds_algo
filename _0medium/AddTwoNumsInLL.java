package _0medium;

//  https://leetcode.com/problems/add-two-numbers/
/*
*
* You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.



Example 1:


Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]


Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.
* */
public class AddTwoNumsInLL {

    public static class ListNode {
        int data;
        ListNode next;

        public ListNode(int data, ListNode next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l1.next == null)
            return l1;
        if (l2 == null || l2.next == null)
            return l1;

//        printLL(l1);
//        printLL(l2);

        ListNode p = reverseLL(l1);
        ListNode q = reverseLL(l2);

//        System.out.println("after reversal: ");
//        printLL(p);
//        printLL(q);

        int sum, carry = 0;
        ListNode ans = new ListNode(0, null);
        ListNode cur = ans;

        while (p != null || q != null) {
            int x = p != null ? p.data : 0;
            int y = q != null ? q.data : 0;
            sum = carry + x + y;
            cur.next = new ListNode(sum % 10, null);
            carry = sum / 10;
            if (p != null)
                p = p.next;
            if (q != null)
                q = q.next;
            cur = cur.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry, null);
        }
        return ans.next;
    }

    private static ListNode reverseLL(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode temp = head, prev = null;

        while (temp != null) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }

    private static void printLL(ListNode head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.print("NULL");
        System.out.println();
    }

    public static void main(String[] args) {
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
//        printLL(head);
//        ListNode rev = reverseLL(head);
//        printLL(rev);
//        ListNode head2 = new ListNode(3, new ListNode(1, new ListNode(1, new ListNode(4, new ListNode(1, null)))));
//        printLL(head2);
//        ListNode rev2 = reverseLL(head2);
//        printLL(rev2);
//        ListNode res1 = addTwoNumbers(head, head2);
//        printLL(reverseLL(res1));

//        ListNode head3 = new ListNode(1, new ListNode(2, new ListNode(9, null)));
//        ListNode res = addTwoNumbers(head, head3);
//        printLL(reverseLL(res));

        ListNode head4 = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3, null))));
        ListNode head5 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        ListNode res = addTwoNumbers(head4, head5);
        printLL(reverseLL(res));
    }
}
