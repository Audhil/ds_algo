package _10Blind75._2LinkedList;

//  https://leetcode.com/problems/merge-k-sorted-lists/
public class _2MergeKsortedListsH {

  public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  /**
   * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode()
   * {} ListNode(int val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val;
   * this.next = next; } }
   */
  class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
      if (lists == null || lists.length == 0) {
        return null;
      }
      if (lists.length == 1) {
        return lists[0];
      }
      ListNode head = merge2Lists(lists[0], lists[1]);
      for (int i = 2; i < lists.length; i++) {
        head = merge2Lists(head, lists[i]);
      }
      return head;
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2) {
      ListNode node = new ListNode(0);
      ListNode temp = node;
      while (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
          temp.next = l1;
          l1 = l1.next;
        } else {
          temp.next = l2;
          l2 = l2.next;
        }
        temp = temp.next;
      }
      if (l1 != null) {
        temp.next = l1;
      }
      if (l2 != null) {
        temp.next = l2;
      }
      return node.next;
    }
  }
}
