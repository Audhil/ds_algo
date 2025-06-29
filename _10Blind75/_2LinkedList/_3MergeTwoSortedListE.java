package _10Blind75._2LinkedList;

//  https://leetcode.com/problems/merge-two-sorted-lists/submissions/
public class _3MergeTwoSortedListE {

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

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode tempNode = new ListNode(0, list1);
    ListNode currNode = tempNode;
    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        currNode.next = list1;
        list1 = list1.next;
      } else {
        currNode.next = list2;
        list2 = list2.next;
      }
      currNode = currNode.next;
    }
    if (list1 != null) {
      currNode.next = list1;
    }
    if (list2 != null) {
      currNode.next = list2;
    }
    return tempNode.next;
  }

  public ListNode revision(ListNode list1, ListNode list2) {
    ListNode curr = new ListNode(0);
    ListNode temp = curr;
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
    return curr.next;
  }
}
