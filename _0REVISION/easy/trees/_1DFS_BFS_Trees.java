package _0REVISION.easy.trees;

import java.util.LinkedList;
import java.util.Stack;

public class _1DFS_BFS_Trees {

  private static class TNode {

    int data;
    TNode left, right;

    public TNode(int data) {
      this.data = data;
    }
  }

  //  insert node to a binary tree - sample code
  private static TNode insert(int data, TNode root) {
    if (root == null) {
      return new TNode(data);
    }
    if (root.data <= data) {
      root.left = insert(data, root.left);
    } else {
      root.right = insert(data, root.right);
    }
    return root;
  }

  //  DFS
  //  inOrder
  private static void inOrder(TNode root) {
    if (root == null) {
      return;
    }
    inOrder(root.left);
    System.out.print(root.data + " ");
    inOrder(root.right);
  }

  //  preOrder
  private static void preOrder(TNode root) {
    if (root == null) {
      return;
    }
    System.out.print(root.data + " ");
    preOrder(root.left);
    preOrder(root.right);
  }

  //  postOrder
  private static void postOrder(TNode root) {
    if (root == null) {
      return;
    }
    postOrder(root.left);
    postOrder(root.right);
    System.out.print(root.data + " ");
  }

  //  BFS (level order traversal)
  //  l2r_t2b
  private static void l2r_t2b(TNode root) {
    if (root == null) {
      return;
    }
    LinkedList<TNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TNode temp = queue.poll();
      System.out.print(temp.data + " ");
      if (temp.left != null) {
        queue.add(temp.left);
      }
      if (temp.right != null) {
        queue.add(temp.right);
      }
    }
  }

  //  l2r_b2t
  private static void l2r_b2t(TNode root) {
    if (root == null) {
      return;
    }
    Stack<TNode> stack = new Stack<>();
    LinkedList<TNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TNode temp = queue.poll();
      stack.push(temp);
      if (temp.right != null) {
        queue.add(temp.right);
      }
      if (temp.left != null) {
        queue.add(temp.left);
      }
    }

    while (!stack.isEmpty()) {
      System.out.println(stack.pop().data);
    }
  }

  //  r2l_t2b
  private static void r2l_t2b(TNode root) {
    if (root == null) {
      return;
    }
    LinkedList<TNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TNode temp = queue.poll();
      System.out.print(temp.data + " ");
      if (temp.right != null) {
        queue.add(temp.right);
      }
      if (temp.left != null) {
        queue.add(temp.left);
      }
    }
  }

  //  r2l_b2t
  private static void r2l_b2t(TNode root) {
    if (root == null) {
      return;
    }
    Stack<TNode> stack = new Stack<>();
    LinkedList<TNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TNode temp = queue.poll();
      stack.push(temp);
      if (temp.left != null) {
        queue.add(temp.left);
      }
      if (temp.right != null) {
        queue.add(temp.right);
      }
    }

    while (!stack.isEmpty()) {
      System.out.println(stack.pop().data);
    }
  }
}
