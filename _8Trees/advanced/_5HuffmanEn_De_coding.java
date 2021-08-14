package _8Trees.advanced;

/*
*   https://www.youtube.com/watch?v=2-0Gid1TqgI
    https://www.youtube.com/watch?v=fFO3R7-sBfA
    *
    * https://photos.google.com/photo/AF1QipOq-wpbAHHVN5-YwmRE6cjvg0WLg8Grid3H4-hk
    * https://photos.google.com/photo/AF1QipPKWfSX14_Usg9C7v3mv9NRkFDyeuLMEOZ3pKvG
    * https://photos.google.com/photo/AF1QipMH7DaF_ls54KgKaecU19n0ikBWgVz0TG3vfYrZ
    *
*/
public class _5HuffmanEn_De_coding {

    class Node {
        public int frequency; // the frequency of this tree
        public char data;
        public Node left, right;
    }

    //  decoding
    void decode(String s, Node root) {
        if (s == null || root == null)
            return;

        Node tempNode = root;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            tempNode = currChar == '1' ? tempNode.right : tempNode.left;
            if (tempNode.left == null && tempNode.right == null) {
                System.out.print(tempNode.data);
                tempNode = root;
            }
        }
    }
}
