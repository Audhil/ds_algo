package _0LinkedList;

//  https://www.geeksforgeeks.org/convert-a-string-to-a-singly-linked-list/
public class _1StringToLL {

  private static class Node {

    char data;
    Node next;

    public Node(char data) {
      this.data = data;
    }
  }

  private static Node stringToSLL(String str) {
    if (str == null || str.isEmpty()) {
      return null;
    }

    Node head = new Node(str.charAt(0));
    Node curr = head;
    for (int i = 1; i < str.length(); i++) {
      curr.next = new Node(str.charAt(i));
      curr = curr.next;
    }
    return head;
  }

  private static void printLL(Node head) {
    Node curr = head;
    while (curr != null) {
      System.out.print(curr.data + " -> ");
      curr = curr.next;
    }
  }

  public static void main(String[] args) {
    Node head = stringToSLL("Jack");
    printLL(head);
  }
}
