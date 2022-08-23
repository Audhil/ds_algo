package _3Stack;

//  https://www.youtube.com/watch?v=cVmifRvUadA&t=1s&ab_channel=NikhilLohia
public class _11StackUsingLinkedList {

  //  TC: push : O (1), pop: O (1), top: O (1)
  private static class MyStack {

    private static class Node {

      int data;
      Node next;

      public Node(int data) {
        this.data = data;
      }
    }

    private Node head;

    private void push(int data) {
      if (head == null) {
        head = new Node(data);
      } else {
        Node node = new Node(data);
        node.next = head;
        head = node;
      }
    }

    private int pop() {
      if (head == null) {
        return 0;
      }
      Node node = head;
      head = head.next;
      return node.data;
    }

    private int top() {
      if (head == null) {
        return 0;
      }
      return head.data;
    }

    private boolean isEmpty() {
      return head == null;
    }
  }

  public static void main(String[] args) {
    MyStack stack = new MyStack();
    /*
    * yup: stack.isEmpty(): true
      yup: stack.top(): 1
      yup: stack.top(): 3
      yup: stack.isEmpty(): false
      yup: stack.pop(): 3
      yup: stack.top(): 2
      yup: stack.isEmpty(): false
      yup: stack.pop(): 2
      yup: stack.top(): 1
      yup: stack.isEmpty(): false
      yup: stack.top(): 1
      yup: stack.isEmpty(): false
      yup: stack.pop(): 1
      yup: stack.isEmpty(): true
      yup: stack.pop(): 0
      yup: stack.isEmpty(): true
    * * */
    System.out.println("yup: stack.isEmpty(): " + stack.isEmpty());
    stack.push(1);
    System.out.println("yup: stack.top(): " + stack.top());
    stack.push(2);
    stack.push(3);
    System.out.println("yup: stack.top(): " + stack.top());
    System.out.println("yup: stack.isEmpty(): " + stack.isEmpty());
    System.out.println("yup: stack.pop(): " + stack.pop());
    System.out.println("yup: stack.top(): " + stack.top());
    System.out.println("yup: stack.isEmpty(): " + stack.isEmpty());
    System.out.println("yup: stack.pop(): " + stack.pop());
    System.out.println("yup: stack.top(): " + stack.top());
    System.out.println("yup: stack.isEmpty(): " + stack.isEmpty());
    System.out.println("yup: stack.top(): " + stack.top());
    System.out.println("yup: stack.isEmpty(): " + stack.isEmpty());
    System.out.println("yup: stack.pop(): " + stack.pop());
    System.out.println("yup: stack.isEmpty(): " + stack.isEmpty());
    System.out.println("yup: stack.pop(): " + stack.pop());
    System.out.println("yup: stack.isEmpty(): " + stack.isEmpty());
  }
}
