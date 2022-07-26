package _10Blind75._2LinkedList;

//  https://leetcode.com/problems/linked-list-cycle/
//  explanation: https://www.youtube.com/watch?v=gBTe7lFR3vc&ab_channel=NeetCode
public class _4CycleInLLE {

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

  //  solve by fast & slow pointer technique
  public boolean hasCycle(ListNode head) {
    if (head == null) {
      return false;
    }
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) { //  since fast reaches the end first
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }
}
