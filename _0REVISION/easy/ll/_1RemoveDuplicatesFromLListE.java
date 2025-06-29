package _0REVISION.easy.ll;

//  https://leetcode.com/problems/remove-duplicates-from-sorted-list
public class _1RemoveDuplicatesFromLListE {

  private static class ListNode {

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

  public static ListNode deleteDuplicates(ListNode head) {
    if (head == null) {
      return head;
    }
    ListNode temp = head;
    while (temp != null) {
      while (temp.next != null && temp.val == temp.next.val) {
        temp.next = temp.next.next;
      }
      temp = temp.next;
    }
    return head;
  }

  private static void printLL(ListNode head) {
    ListNode temp = head;
    while (temp != null) {
      System.out.print(temp.val + " ");
      temp = temp.next;
    }
  }

  public static void main(String[] args) {
    ListNode node = new ListNode(1);
    node.next = new ListNode(2);
    node.next.next = new ListNode(2);
    node.next.next.next = new ListNode(3);
    node.next.next.next.next = new ListNode(3);
    node.next.next.next.next.next = new ListNode(4);
    printLL(node);
    deleteDuplicates(node);
    System.out.println("\n after deletion of duplicate nodes: ");
    printLL(node);
  }
}
