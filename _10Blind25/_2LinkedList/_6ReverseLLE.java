package _10Blind25._2LinkedList;

//  https://leetcode.com/problems/reverse-linked-list/submissions/
public class _6ReverseLLE {

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

  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode curr = head;
    ListNode prev = null;

    while (curr != null) {
      ListNode temp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = temp;
    }
    return prev;
  }
}
