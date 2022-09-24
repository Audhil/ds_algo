package _0LinkedList;

import java.util.HashSet;
import java.util.Set;

//  https://practice.geeksforgeeks.org/problems/87f12e5c728d69a5322634776b54c75897d14daa/1
//  https://youtu.be/GSpg2DTOqYw
public class _3CountTripletsInLL {

  //  TC: O (n^2)
  private static class Node {

    int data;
    Node next;

    public Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }
  }

  private static int countTriplets(Node head, int x) {
    if (head == null) {
      return 0;
    }
    Set<Integer> set = new HashSet<>();
    int ans = 0;
    for (Node ptr2 = head; ptr2.next != null; ptr2 = ptr2.next) {
      for (Node ptr3 = ptr2.next; ptr3 != null; ptr3 = ptr3.next) {
        int b = ptr2.data;
        int c = ptr3.data;
        int a = x - b - c;  //  a+b+c = x
        if (set.contains(a)) {
          ans++;
        }
      }
      set.add(ptr2.data);
    }
    return ans;
  }

  public static void main(String[] args) {
    Node head = new Node(1,
        new Node(2, new Node(4, new Node(5, new Node(6, new Node(8, new Node(9, null)))))));
    System.out.println("yup: no of triplets: " + countTriplets(head, 17));
    System.out.println("yup: 2nd no of triplets: " + countTriplets(head, 15));
  }
}
