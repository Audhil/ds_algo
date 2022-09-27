package _0LinkedList._FloydAlgo_TortoiseAndHare;

//  https://youtu.be/PvrxZaH_eZ4?t=474
public class _0DetectCycleInLL_StartingNodeOfCycleM {

  //  TC: O (n); SC: O (1)
  private static class Node {

    int data;
    Node next;

    public Node(int data) {
      this.data = data;
    }

    public Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }

    @Override
    public String toString() {
      return "Node{" +
          "data=" + data + "}";
    }
  }

  private static Node isCycleAvailable(Node head) {
    Node tortoise = head;
    Node hare = head;
    boolean isCycleDetected = false;
    while (hare != null && hare.next != null) {
      tortoise = tortoise.next;
      hare = hare.next.next;

      if (hare == tortoise) {
        isCycleDetected = true;
        break;
      }
    }
    if (!isCycleDetected) {
      return null;
    }
    tortoise = head;
    //  find starting point of cycle
    while (tortoise != hare) {
      tortoise = tortoise.next;
      hare = hare.next;
    }
    return tortoise;
  }

  public static void main(String[] args) {
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);
    head.next.next.next.next.next = new Node(6);
    head.next.next.next.next.next.next = head.next.next;  //  cycle
    System.out.println(
        "yup: connected @ : " + isCycleAvailable(head)); //  yup: connected @ : Node{data=3}
  }
}
