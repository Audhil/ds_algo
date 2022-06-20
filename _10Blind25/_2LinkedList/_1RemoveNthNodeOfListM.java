package _10Blind25._2LinkedList;

//  https://leetcode.com/problems/remove-nth-node-from-end-of-list/
//  Given the head of a linked list, remove the nth node from the end of the list and return its head.
public class _1RemoveNthNodeOfListM {

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

//  reverse and solving - not works though
//  public ListNode removeNthFromEnd(ListNode head, int n) {
//    //  1. reverse the list
//    ListNode curr = head;
//    ListNode prev = null;
//    while (curr != null) {
//      ListNode temp = curr.next;
//      curr.next = prev;
//      prev = curr;
//      curr = temp;
//    }
//    //  prev will hold head of reversed list
//    curr = prev;
//    //  2. remove nth node from start
//    int pos = 0;
//    while (curr != null) {
//      //  remove the node
//      if (pos == n) {
//        prev.next = curr.next;
//        curr.next = null;
//        break;
//      }
//      prev = curr;
//      curr = curr.next;
//      pos++;
//    }
//    return head;
//  }

  //  with 2ptr and dummy node technique
  //  https://www.youtube.com/watch?v=XVuQxVej6y8&ab_channel=NeetCode
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummyNode = new ListNode(0, head);
    //  assign left pointer
    ListNode left = dummyNode;
    //  shift & assign right pointer
    ListNode right = head;
    while (n > 0 && right != null) {
      right = right.next;
      n--;
    }
    //  move pointers
    while (right != null) {
      right = right.next;
      left = left.next;
    }
    //  delete the node
    left.next = left.next.next;
    //  return head of the lsit
    return dummyNode.next;
  }
}
