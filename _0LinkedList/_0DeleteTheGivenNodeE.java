package _0LinkedList;

//  https://www.interviewcake.com/question/python/delete-node?utm_source=weekly_email&utm_source=drip&utm_campaign=weekly_email&utm_campaign=Interview%20Cake%20Weekly%20Problem%20%23413:%20Delete%20Node&utm_medium=email&utm_medium=email
public class _0DeleteTheGivenNodeE {

  private static class LNode {

    int data;
    LNode next;

    public LNode(int data, LNode next) {
      this.data = data;
      this.next = next;
    }
  }

  private static void deleteNode(LNode nodeToDelete) {
    LNode nxt = nodeToDelete.next;
    if (nxt == null) {
      throw new RuntimeException("we cannot delete the last node, with this method.");
    }
    //  overwriting the values in nodeToDelete
    nodeToDelete.data = nxt.data;
    nodeToDelete.next = nxt.next;
  }

  private static void printLL(LNode head) {
    LNode temp = head;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
  }

  public static void main(String[] args) {
    LNode one = new LNode(1, null);
    LNode two = new LNode(2, null);
    LNode three = new LNode(3, null);
    LNode four = new LNode(4, null);
    one.next = two;
    two.next = three;
    three.next = four;
    LNode head = one;
//    LNode head = new LNode(1, new LNode(2, new LNode(3, null)));
    System.out.println("yup: LL is: ");
    printLL(head);  //  1 2 3 4
    deleteNode(two);
    System.out.println("\n after deleting: ");
    printLL(head);  //  1 3 4
  }
}
