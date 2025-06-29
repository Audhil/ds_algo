package _10Blind75._6GreedyApproach._2HuffmanEncoding;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//  https://www.youtube.com/watch?v=XxleDeFelGE&list=PLQXZIFwMtjozzDH4ZRtpIl0piBjsRF5Bf&index=4&ab_channel=CodeChef
//  used for : file compression
public class _1HuffmanEncoding {

  private static class HNode {

    char aChar;
    int freq;
    HNode left;
    HNode right;

    public HNode(char value, int freq, HNode left, HNode right) {
      this.freq = freq;
      this.aChar = value;
      this.left = left;
      this.right = right;
    }

    @Override
    public String toString() {
      return "HNode{" +
          "aChar=" + aChar +
          ", freq=" + freq +
          ", left=" + left +
          ", right=" + right +
          '}';
    }
  }

  //  Given a list of character and the frequencies they appear. Construct a Huffman Tree to encode all character.
  //  S->Unique Characters, f->frequency of each character, N->total number of unique characters
  public static List<String> huffmanCodes(String S, int[] f, int N) {
    if (S == null) {
      return null;
    }
    //  1. construct minHeap tree
    //  minHeap
    PriorityQueue<HNode> priorityQueue = new PriorityQueue<>((a, b) -> {
      if (a.freq != b.freq) {
        return a.freq - b.freq; //  min heap
      } else {
        return 1; //  maintain the same order
      }
    });
    for (int i = 0; i < S.toCharArray().length; i++) {
      priorityQueue.add(
          new HNode(S.charAt(i), f[i], null, null)); //  since chars are always leaf nodes
    }
    while (priorityQueue.size() > 1) {
      HNode a = priorityQueue.poll();
      HNode b = priorityQueue.poll();

      if (a != null && b != null) {
        priorityQueue.add(new HNode('_', a.freq + b.freq, a, b));
      }
    }
    //  2. populate List with preOrder traversal
    List<String> list = new ArrayList<>();
    List<String> charList = new ArrayList<>();
    preOrder(list, charList, priorityQueue.remove(), "");
    System.out.println("coded list: ");
    System.out.println(list);
    System.out.println("chars list: ");
    System.out.println(charList);
    return list;
  }

  private static void preOrder(List<String> list, List<String> charList, HNode node, String S) {
    if (node == null) {
      return;
    }
    if (node.left == null && node.right == null) {
      charList.add(String.valueOf(node.aChar));
      list.add(S);
    }
    preOrder(list, charList,node.left, S + "0");
    preOrder(list, charList,node.right, S + "1");
  }

  //  MOHAMMAD FRAZ
  /*
    M = 3; O = 1; H = 1; A = 3; D = 1; F = 1; R = 1; Z = 1;
  * */
  public static void main(String[] args) {
    huffmanCodes("MOHADFRZ",
        new int[]{3, 1, 1, 3, 1, 1, 1, 1}, "MOHADFRZ".length());
  }
}
