package _0medium;

//  https://www.youtube.com/watch?v=pNTc1bM1z-4
/*
 *
 * Sort a linked list in O(n log n) time using constant space complexity
 *
 * ex1:
 * input: 4 -> 2 -> 1 -> 3
 * output: 1 2 3 4
 *
 * ex2:
 * i/p: -1 5 3 4 0
 * o/p: -1 0 3 4 5
 *
 * tip: sorting in merge sort
 *
 * */
public class SortLinkedListWithMergeSort {

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

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;

        //  splits list into 2
        //  1st half = left side, 2nd half = right side
        //  head will be start of 1st half
        //  temp will be end of 1st half
        //  slow will be start of 2nd half
        //  fast will be end of 2nd half
        while (fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = null;   //  it's end of 1st half

        ListNode left_side = sortList(head);    //  recursive calls to 1st half
        ListNode right_side = sortList(slow);   //  recursive calls to 2nd half

        return merge(left_side, right_side);
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode sorted_temp = new ListNode(0, null);
        ListNode current_node = sorted_temp;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                current_node.next = l1;
                l1 = l1.next;
            } else {
                current_node.next = l2;
                l2 = l2.next;
            }
            current_node = current_node.next;
        }

        if (l1 != null) {
            current_node.next = l1;
        }

        if (l2 != null) {
            current_node.next = l2;
        }
        return sorted_temp.next;
    }

    public static void printLL(ListNode head) {
        if (head == null)
            return;

        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(44, new ListNode(2, new ListNode(555, new ListNode(8, new ListNode(1, new ListNode(9, new ListNode(1100, new ListNode(9, new ListNode(1100, null)))))))));
        printLL(head);
        ListNode sortedList = sortList(head);
        printLL(sortedList);
        printLL(head);
    }
}
