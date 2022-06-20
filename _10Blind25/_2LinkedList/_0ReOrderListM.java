package _10Blind25._2LinkedList;

//  https://www.youtube.com/watch?v=S5bfdUTrKLM&ab_channel=NeetCode
//  https://leetcode.com/problems/reorder-list/
public class _0ReOrderListM {

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

  public void reorderList(ListNode head) {
    //  1. break the list into 2 halves - using slow & fast pointer
    ListNode slow = head, fast = head.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    //  slow.next is beginning of 2nd half list
    ListNode secondHalfHead = slow.next;
    slow.next = null; //  breaking list into 2 halves

    //  2. reverse the 2nd half of the list
    ListNode prev = null;
    while (secondHalfHead != null) {
      ListNode temp = secondHalfHead.next;
      secondHalfHead.next = prev;
      prev = secondHalfHead;
      secondHalfHead = temp;
    }
    //  prev will hold head of 2nd half list
    secondHalfHead = prev;

    //  3. merge both lists
    ListNode firstHalfHead = head;
    while (secondHalfHead != null) {  //  since second list will be smaller in some cases
      ListNode temp1 = firstHalfHead.next;
      ListNode temp2 = secondHalfHead.next;
      firstHalfHead.next = secondHalfHead;
      secondHalfHead.next = temp1;
      firstHalfHead = temp1;
      secondHalfHead = temp2;
    }
  }

  public static void main(String[] args) {
    /*
    * works for
    * Input: head = [1,2,3,4]
      Output: [1,4,2,3]
      *
    * Input: head = [1,2,3,4,5]
    Output: [1,5,2,4,3]
    * */
  }
}
