package _0easy;

//  https://leetcode.com/problems/merge-two-sorted-lists/
/*
* Merge two sorted linked lists and return it as a sorted list.
* The list should be made by splicing together the nodes of the first two lists.
*
* Example 1:
* Input: l1 = [1#,2#,4#], l2 = [1,3,4]
Output: [1,1#,2#,3,4#,4]
Example 2:

Input: l1 = [], l2 = []
Output: []
Example 3:

Input: l1 = [], l2 = [0]
Output: [0]


Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both l1 and l2 are sorted in non-decreasing order.
*
* https://www.youtube.com/watch?v=KVf1Uuqfv8E
* */
public class MergeTwoSortedList {
    public static class ListNode {
        int val;
        ListNode next;

        private ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null)
            return null;
        ListNode tempNode = new ListNode(0);
        ListNode currNode = tempNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                currNode.next = l1;
                l1 = l1.next;
            } else {
                currNode.next = l2;
                l2 = l2.next;
            }
            currNode = currNode.next;
        }
        if (l1 != null)
            currNode.next = l1;
        if (l2 != null)
            currNode.next = l2;
        return tempNode.next;
    }

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(77, new ListNode(88, new ListNode(90, new ListNode(100)))))));
//        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));

        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        ListNode ddd = mergeTwoLists(l1, l2);

        while (ddd != null) {
            System.out.println("yup: " + ddd.val);
            ddd = ddd.next;
        }
    }
}
