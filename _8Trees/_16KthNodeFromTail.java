package _8Trees;

//  https://www.interviewcake.com/question/python/kth-to-last-node-in-singly-linked-list?utm_source=weekly_email&utm_source=drip&utm_campaign=weekly_email&utm_campaign=Interview%20Cake%20Weekly%20Problem%20%23415:%20Kth%20to%20Last%20Node%20in%20a%20Singly-Linked%20List&utm_medium=email&utm_medium=email
public class _16KthNodeFromTail {

  private static class Node {

    int data;
    Node next;

    public Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }

    @Override
    public String toString() {
      return "Node{" +
          "data=" + data +
          ", next=" + next +
          '}';
    }
  }

  public static void main(String[] args) {
    Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, null))))));
    int k = 1;
    Node node = findKthNodeFromTail(head, k);
    System.out.println("yup: findKthNodeFromTail kth node from last: "
        + node); //  yup: findKthNodeFromTail kth node from last: Node{data=5, next=Node{data=6, next=null}}
    node = findKthNodeFromTailOptimized(head, k);
    System.out.println("yup: findKthNodeFromTailOptimized kth node from last: "
        + node); //  yup: findKthNodeFromTailOptimized kth node from last: Node{data=5, next=Node{data=6, next=null}}
  }

  //  TC: O (n) + O (n)
  private static Node findKthNodeFromTail(Node head, int k) {
    if (k < 1) {
      return null;
    }
    //  tot length of LL
    int n = 0;
    Node temp = head;
    while (temp.next != null) {
      n++;
      temp = temp.next;
    }
    if (k > n) {
      return null;
    }
    int n_minus_k = n - k;
    temp = head;
    while (n_minus_k-- > 0) {
      temp = temp.next;
    }
    return temp;
  }

  //  TC : O (n)
  //  2 ptr approach - stick method
  private static Node findKthNodeFromTailOptimized(Node head, int k) {
    if (k < 1) {
      return null;
    }
    Node left = head;
    Node right = head;
    while (k-- > 0 && right != null) {
      right = right.next;
    }
    if (right == null) {
      return null;
    }
    //  left & right ptrs are 'k' distance from each other
    while (right.next != null) {
      left = left.next;
      right = right.next;
    }
    //  finally 'left' will point to kth node, 'right' will point to last node of the LL
    return left;
  }
}
