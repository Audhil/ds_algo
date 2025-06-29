package _8Trees.binarysearchtree;

import java.util.Stack;

//  https://www.youtube.com/watch?v=EWrSxJ7-Rdc&list=PLNxqWc8Uj2LQpbGv6I_HWf0kTj6kMVVwm&index=21
//  notes @ https://photos.google.com/photo/AF1QipMK785UGzhqt1Ln7UiZME19NaVgl2NBkpmk5vtW
public class _20CheckIsPreOrderTraversalIsBST {

    //  given pre order traversal, check is it a BST?
    public static void main(String[] args) {
        int[] sample1 = {40, 30, 35, 80, 100};
        int[] sample2 = {40, 30, 35, 20, 80, 100};

        System.out.println("yup: is it BST? sample: " + isBST(sample1));
        System.out.println("yup: is it BST? sample2: " + isBST(sample2));

    }

    //  we are finding in O(n)
    private static boolean isBST(int[] arr) {
        if (arr.length == 0)
            return false;

        int parent = -1;
        Stack<Integer> stack = new Stack<>();
        for (int nodeValue : arr) {
            while (!stack.isEmpty() && stack.peek() < nodeValue)
                parent = stack.pop();
            if (nodeValue < parent)
                return false;
            stack.push(nodeValue);
        }
        return true;
    }
}
