package _10Blind75._7Trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//  https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
public class _5SerializeAndDeserializeBinaryTreeH {

  private static class TreeNode {

    int data;
    TreeNode left, right;

    public TreeNode(int data) {
      this.data = data;
    }
  }

  private static final String nan = "X";
  private static final String separator = ",";

  //  serializes with preOrder( Root L R ) traversal
  private static class Serializer {

    private StringBuilder stringBuilder;

    private String serialize(TreeNode root) {
      stringBuilder = new StringBuilder("");
      if (root == null) {
        return stringBuilder.toString();
      }
      buildString(root);
      return stringBuilder
          .deleteCharAt(stringBuilder.length() - 1) //  deleting last "," char from the string
          .toString();
    }

    private void buildString(TreeNode root) {
      if (root == null) {
        stringBuilder.append(nan).append(separator);
        return;
      }
      stringBuilder.append(root.data).append(separator);
      buildString(root.left);
      buildString(root.right);
    }
  }

  private static class Deserializer {

    private Queue<String> queue;

    private TreeNode deserialize(String string) {
      if (string.equals("")) {
        return null;
      }
      queue = new LinkedList<>();
      queue.addAll(Arrays.asList(string.split(separator)));
      return buildTree();
    }

    private TreeNode buildTree() {
      String str = queue.poll();
      if (str.equals(nan)) {
        return null;
      }
      TreeNode treeNode = new TreeNode(Integer.parseInt(str));
      treeNode.left = buildTree();
      treeNode.right = buildTree();
      return treeNode;
    }
  }

  private static void printInOrder(TreeNode root) {
    if (root == null) {
      return;
    }
    printInOrder(root.left);
    System.out.print(root.data + " ");
    printInOrder(root.right);
  }

  /*
  output:
  * this is our tree:
    4 2 1 3
    after serialization
    1,2,4,X,X,X,3,X,X
    after Deserialization
    4 2 1 3
    * */
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    System.out.println("this is our tree: ");
    printInOrder(root);
    Serializer serializer = new Serializer();
    String serializedStr = serializer.serialize(root);
    System.out.println("\nafter serialization");
    System.out.println(serializedStr);
    Deserializer deserializer = new Deserializer();
    TreeNode newRoot = deserializer.deserialize(serializedStr);
    System.out.println("after Deserialization");
    printInOrder(newRoot);
  }
}
