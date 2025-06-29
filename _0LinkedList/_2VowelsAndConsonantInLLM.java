package _0LinkedList;

//  https://www.geeksforgeeks.org/arrange-consonants-vowels-nodes-linked-list/
public class _2VowelsAndConsonantInLLM {

  private static class Node {

    char data;
    Node next;

    public Node(char data, Node next) {
      this.data = data;
      this.next = next;
    }
  }

  // utility function to print linked list
  private static void printlist(Node head) {
    if (head == null) {
      System.out.println("Empty List");
      return;
    }
    while (head != null) {
      System.out.print(head.data + " ");
      if (head.next != null) {
        System.out.print("-> ");
      }
      head = head.next;
    }
    System.out.println();
  }

  // utility function for checking vowel
  private static boolean isVowel(char x) {
    return (x == 'a' || x == 'e' || x == 'i' ||
        x == 'o' || x == 'u');
  }

  private static Node arrange(Node head) {
    if (head == null) {
      return null;
    }
    Node newHead = head;
    Node latestVowelHead;
    Node curr = head;
    if (isVowel(head.data)) {
      latestVowelHead = head;
    } else {
      while (curr.next != null && !isVowel(curr.next.data)) {
        curr = curr.next;
      }
      // This is an edge case where there are only consonants in the list.
      if (curr.next == null) {
        return head;
      }
      latestVowelHead = newHead = curr.next;
      //  delete the place changed vowels node
      curr.next = curr.next.next;
      latestVowelHead.next = head;
    }

    while (curr != null && curr.next != null) {
      if (isVowel(curr.next.data)) {
        if (curr == latestVowelHead) {
          latestVowelHead = curr = curr.next;
        } else {
          Node temp = latestVowelHead.next;
          latestVowelHead.next = curr.next;
          latestVowelHead = latestVowelHead.next;
          curr.next = curr.next.next;
          latestVowelHead.next = temp;
        }
      } else {
        curr = curr.next;
      }
    }
    return newHead;
  }

  public static void main(String[] args) {
    Node head = new Node('a', new Node('b', new Node('c',
        new Node('e', new Node('d', new Node('o', new Node('x', new Node('i', null))))))));
    printlist(arrange(head)); //  a -> e -> o -> i -> b -> c -> d -> x
  }
}
