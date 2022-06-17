package _10Blind25;

public class _1InPlaceReversalOfLinkedListE {

  private static class NodeIs {

    int data;
    NodeIs next;

    public NodeIs(int data, NodeIs next) {
      this.data = data;
      this.next = next;
    }
  }

  private static NodeIs inPlaceReversalOfLL(NodeIs head) {
    if (head == null) {
      return null;
    }
    NodeIs curr = head;
    NodeIs prev = null;

    while (curr != null) {
      NodeIs temp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = temp;
    }
    return prev;
  }

  private static void printLL(NodeIs node) {
    NodeIs temp = node;
    while (temp != null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    NodeIs head = new NodeIs(1, new NodeIs(2, new NodeIs(3, new NodeIs(4, null))));
    printLL(head);
    NodeIs revHead = inPlaceReversalOfLL(head);
    System.out.println("after reversal: ");
    printLL(revHead);
  }
}
