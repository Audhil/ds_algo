package _10Blind25._2LinkedList;

//  https://leetcode.com/problems/linked-list-cycle-ii/
public class _5cycleInLL2M {

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

  //  best explanation: https://www.youtube.com/watch?v=q9aTM-6__Ho&ab_channel=NareshGupta
  public ListNode detectCycle(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        slow = head;
        while (slow != fast) {
          slow = slow.next;
          fast = fast.next;
        }
        return slow;
      }
    }
    return null;
  }
}
