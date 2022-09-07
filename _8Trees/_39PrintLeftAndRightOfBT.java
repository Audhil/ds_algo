package _8Trees;

//  https://www.youtube.com/watch?v=thkuu_FWFD8

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _39PrintLeftAndRightOfBT {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    int maxLevel = 0;

    /*
     *           1
     *
     *       2       3
     *                   6
     *
     * viewing dir ->
     * o/p = 1 2 6
     * */
//    private void printLeftVisibleNodes(Node root, int level) {
//        if (root == null)
//            return;
//
//        if (maxLevel < level) {
//            System.out.print(root.data + " ");
//            maxLevel = level;
//        }
//        printLeftVisibleNodes(root.left, level + 1);
//        printLeftVisibleNodes(root.right, level + 1);
//    }



    /*  printing whole(left+right) visible nodes of the tree */
    private void printLeftVisibleNodess(Node root, int level, List<Integer> list) {
        if (root == null)
            return;
        if (maxLevel < level) {
            list.add(root.data);
            maxLevel = level;
        }
        printLeftVisibleNodess(root.left, level + 1, list);
    }

    private void printRightVisibleNodess(Node root, int level, List<Integer> list) {
        if (root == null)
            return;
        if (maxLevel < level) {
            list.add(root.data);
            maxLevel = level;
        }
        printRightVisibleNodess(root.right, level + 1, list);
    }

//    public static void main(String[] args) {
//        PrintLeftAndRightOfBT pBt = new PrintLeftAndRightOfBT();
//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.right.right = new Node(6);
//        pBt.printLeftVisibleNodes(root, 1);
//    }

    /*  printing whole(left+right) visible nodes of the tree */
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(7);
        root.right.right = new Node(8);
        _39PrintLeftAndRightOfBT pBt = new _39PrintLeftAndRightOfBT();
        List<Integer> list = new ArrayList<>();
        pBt.maxLevel = 0;
        pBt.printLeftVisibleNodess(root.left, 1, list);
        pBt.maxLevel = 0;
        Collections.reverse(list);
        pBt.printRightVisibleNodess(root, 1, list);
        System.out.println(list);
    }
}
