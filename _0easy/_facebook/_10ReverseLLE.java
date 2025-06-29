package _0easy._facebook;

//  https://www.lintcode.com/problem/35/?fromId=29&_from=collection
public class _10ReverseLLE {

  public static class ListNode {

    int val;
    ListNode next;

    public ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public static ListNode reverse(ListNode head) {
    if (head == null) {
      return head;
    }
    ListNode prv = null;
    ListNode curr = head;
    while (curr != null) {
      ListNode temp = curr.next;
      curr.next = prv;
      prv = curr;
      curr = temp;
    }
    return prv;
  }

  private static void printLL(ListNode head) {
    ListNode curr = head;
    while (curr != null) {
      System.out.print(curr.val);
      if (curr.next != null) {
        System.out.print("->");
      }
      curr = curr.next;
    }
  }


  public static void main(String[] args) {
    /*
    * yup: before reversing
      1->2->3->5->7
      yup: after reversing
      7->5->3->2->1
    */
    ListNode head = new ListNode(1,
        new ListNode(2, new ListNode(3, new ListNode(5, new ListNode(7, null)))));
    System.out.println("yup: before reversing");
    printLL(head);
    System.out.println("\nyup: after reversing");
    ListNode rHead = reverse(head);
    printLL(rHead);
  }
}
