package _8Trees.advanced.huffmanendecoding;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//  data compression
//  https://www.youtube.com/watch?v=zSsTG3Flo-I
//  https://www.youtube.com/watch?v=oNPyYF_Cz5I
public class Huffman {

    //  we are taking ASCII chars count
    private static final int ALPHABET_SIZE = 256;

    private static class Node implements Comparable<Node> {
        final int freq;
        final char aChar;
        final Node left, right;

        public Node(int freq, char aChar, Node left, Node right) {
            this.freq = freq;
            this.aChar = aChar;
            this.left = left;
            this.right = right;
        }

        boolean isLeaf() {
            return left == null && right == null;
        }


        @Override
        public int compareTo(Node that) {
            int freqCompare = Integer.compare(this.freq, that.freq);
            return freqCompare != 0 ? freqCompare : Integer.compare(this.aChar, that.aChar);
        }
    }

    private static class HuffmanEncodeResult {
        final Node root;
        final String encodedData;

        public HuffmanEncodeResult(String encodedData, Node root) {
            this.encodedData = encodedData;
            this.root = root;
        }
    }

    private static String deCompress(HuffmanEncodeResult huffmanEncodeResult) {
        if (huffmanEncodeResult == null || huffmanEncodeResult.root == null || huffmanEncodeResult.encodedData == null)
            return null;

        StringBuilder sBuilder = new StringBuilder();
        Node tempNode = huffmanEncodeResult.root;
        for (char aChar : huffmanEncodeResult.encodedData.toCharArray()) {
            tempNode = aChar == '0' ? tempNode.left : tempNode.right;
            if (tempNode.isLeaf()) {
                sBuilder.append(tempNode.aChar);
                tempNode = huffmanEncodeResult.root;
            }
        }
        return sBuilder.toString();
    }

    private static HuffmanEncodeResult compress(String msg) {
        int[] freqTable = buildFreqTable(msg);
        Node root = buildHuffmanTree(freqTable);
        Map<Character, String> lookUpTable = buildLookUpTable(root);
        System.out.println("yup: lookUpTable: " + lookUpTable);
        return new HuffmanEncodeResult(generateEncodedData(msg, lookUpTable), root);
    }

    private static String generateEncodedData(String msg, Map<Character, String> lookUpTable) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : msg.toCharArray()) {
            stringBuilder.append(lookUpTable.get(aChar));
        }
        return stringBuilder.toString();
    }

    private static Map<Character, String> buildLookUpTable(Node root) {
        Map<Character, String> lookUpTable = new HashMap<>();
        buildLookUpTableImpl(root, "", lookUpTable);
        return lookUpTable;
    }

    private static void buildLookUpTableImpl(Node node, String s, Map<Character, String> lookUpTable) {
        if (!node.isLeaf()) {
            buildLookUpTableImpl(node.left, s + '0', lookUpTable);  //  append '0' for left side child
            buildLookUpTableImpl(node.right, s + '1', lookUpTable);  //  append '1' for right side child
        } else
            lookUpTable.put(node.aChar, s);
    }

    //  print tree - inorder traversal
    private static void printTree(Node root) {
        if (root == null)
            return;

        printTree(root.left);
        System.out.print(root.aChar + " ");
        printTree(root.right);
    }

    //  build huffman tree
    private static Node buildHuffmanTree(int[] freqTable) {
        final PriorityQueue<Node> queue = new PriorityQueue<>();
        for (char i = 0; i < freqTable.length; i++) {
            if (freqTable[i] > 0)
                queue.add(new Node(freqTable[i], i, null, null));
        }
        if (queue.size() == 1)
            queue.add(new Node(1, '\0', null, null));

        while (queue.size() > 1) {
            Node left = queue.poll();
            Node right = queue.poll();
            Node parent = new Node(left.freq + right.freq, '\0', left, right);
            queue.add(parent);
        }
        return queue.poll();    //  last node will be root of the tree
    }

    //  build freq table
    private static int[] buildFreqTable(String msg) {
        int[] fTable = new int[ALPHABET_SIZE];
        for (char charr : msg.toCharArray())
            fTable[charr]++;
        return fTable;
    }

    public static void main(String[] args) {
        HuffmanEncodeResult result = compress("audhil");
        System.out.println("encodedData: " + result.encodedData);
        System.out.println("decodedData: " + deCompress(result));
        /*
        *   yup: lookUpTable: {a=100, d=101, u=111, h=00, i=01, l=110}
            encodedData: 1001111010001110
            decodedData: audhil
*        */
    }
}
