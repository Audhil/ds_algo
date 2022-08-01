package _10Blind75._9Heap;

//  https://leetcode.com/problems/merge-k-sorted-lists/
public class _1MergeKSortedLinkedLists_H {

  private static class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public static ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) {
      return null;
    }
    if (lists.length == 1) {
      return lists[0];
    }
    //  merge 0th and 1st items
    ListNode head = merge(lists[0], lists[1]);
    //  merge the remaining items
    for (int i = 2; i < lists.length; i++) {
      head = merge(head, lists[i]);
    }
    return head;
  }

  private static ListNode merge(ListNode list1, ListNode list2) {
    ListNode node = new ListNode(0);  //  dummy node
    ListNode temp = node;
    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        temp.next = list1;
        list1 = list1.next;
      } else {
        temp.next = list2;
        list2 = list2.next;
      }
      temp = temp.next;
    }
    if (list1 != null) {
      temp.next = list1;
    }
    if (list2 != null) {
      temp.next = list2;
    }
    return node.next;
  }

  private static void printLL(ListNode head) {
    ListNode temp = head;
    while (temp != null) {
      System.out.print(temp.val);
      if (temp.next != null) {
        System.out.print(" -> ");
      }
      temp = temp.next;
    }
  }

  public static void main(String[] args) {
    ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5, null)));
    ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
    ListNode list3 = new ListNode(2, new ListNode(6, null));
    ListNode head = mergeKLists(new ListNode[]{list1, list2, list3});
    System.out.println("yup: final list: ");
    printLL(head);  //  1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6
  }
}
