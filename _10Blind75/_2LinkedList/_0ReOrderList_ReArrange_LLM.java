package _10Blind75._2LinkedList;

//  https://www.youtube.com/watch?v=S5bfdUTrKLM&ab_channel=NeetCode
//  https://leetcode.com/problems/reorder-list/
public class _0ReOrderList_ReArrange_LLM {

  public static class ListNode {

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

  //  TC: O (n)
  public static void reorderList(ListNode head) {
    //  1. break the list into 2 halves - using slow & fast pointer
    //  finding the breaking point
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

  public static void revision(ListNode head) {
    if (head == null) {
      return;
    }
    //  1. break the list into 2 halves
    ListNode slow = head;
    ListNode fast = head.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    //  slow.next is the head of 2nd list
    ListNode secondHead = slow.next;
    slow.next = null;

    //  2. reverse the 2nd list
    ListNode prev = null;
    while (secondHead != null) {
      ListNode temp = secondHead.next;
      secondHead.next = prev;
      prev = secondHead;
      secondHead = temp;
    }
    secondHead = prev;
    //  3. merge the list together
    ListNode firstHead = head;
    while (secondHead != null) {
      ListNode temp1 = firstHead.next;
      ListNode temp2 = secondHead.next;
      firstHead.next = secondHead;
      secondHead.next = temp1;
      firstHead = temp1;
      secondHead = temp2;
    }
  }

  public static void revision2(ListNode head) {
    if (head == null) {
      return;
    }
    //  1. divide LL in to 2 halves
    ListNode slow = head, fast = head.next;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    //  slow.next is start of 2nd half
    ListNode secondHead = slow.next;
    slow.next = null;

    //  2. reverse 2nd half LL
    ListNode prev = null;
    while (secondHead != null) {
      ListNode temp = secondHead.next;
      secondHead.next = prev;
      prev = secondHead;
      secondHead = temp;
    }
    //  prev will become head of second LL
    secondHead = prev;

    //  3. merge list together
    ListNode firstHead = head;
    while (secondHead != null) {
      ListNode temp1 = firstHead.next;
      ListNode temp2 = secondHead.next;
      firstHead.next = secondHead;
      secondHead.next = temp1;
      firstHead = temp1;
      secondHead = temp2;
    }
  }

  private static void printLL(ListNode head) {
    ListNode curr = head;
    while (curr != null) {
      System.out.print(curr.val + " -> ");
      curr = curr.next;
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
//    ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
    ListNode head = new ListNode(1,
        new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//    1 -> 2 -> 3 -> 4 ->
//    1 -> 2 -> 3 -> 4 -> 5 ->
    printLL(head);
    System.out.println("\nafter reordering: ");
//    reorderList(head);
    revision2(head);
//    1 -> 4 -> 2 -> 3 ->
//    1 -> 5 -> 2 -> 4 -> 3 ->
    printLL(head);
  }
}
