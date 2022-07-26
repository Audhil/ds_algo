package _0REVISION.easy.trees;

import java.util.LinkedList;

//  refer _22InvertABinaryTree.java
public class _5InvertBinaryTree {

  private static class TNode {

    int data;
    TNode left, right;

    public TNode(int data) {
      this.data = data;
    }
  }

  public static void main(String[] args) {
    TNode root = new TNode(1);
    root.left = new TNode(2);
    root.right = new TNode(3);
    root.left.left = new TNode(4);
    root.left.right = new TNode(5);
    root.right.right = new TNode(6);
    System.out.println("print InOrder");
    printInorder(root);
    System.out.println("\nprint PreOrder");
    printPreOrder(root);
    System.out.println("\nprint PostOrder");
    printPostOrder(root);
    System.out.println("\nprint LevelOrder");
    printLevelOrder(root);
    invertBinaryTree(root);
    System.out.println("\nAfter inverting tree: ");
    printLevelOrder(root);
  }

  private static void invertBinaryTree(TNode root) {
    if (root == null) {
      return;
    }
    TNode temp = root.left;
    root.left = root.right;
    root.right = temp;
    invertBinaryTree(root.left);
    invertBinaryTree(root.right);
  }

  private static void printInorder(TNode root) {
    if (root == null) {
      return;
    }
    printInorder(root.left);
    System.out.print(root.data + " ");
    printInorder(root.right);
  }

  private static void printPreOrder(TNode root) {
    if (root == null) {
      return;
    }
    System.out.print(root.data + " ");
    printPreOrder(root.left);
    printPreOrder(root.right);
  }

  private static void printPostOrder(TNode root) {
    if (root == null) {
      return;
    }
    printPreOrder(root.left);
    printPreOrder(root.right);
    System.out.print(root.data + " ");
  }

  private static void printLevelOrder(TNode root) {
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
}
