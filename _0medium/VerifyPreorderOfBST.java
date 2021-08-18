package _0medium;

import java.util.Stack;

//  https://www.lintcode.com/problem/1307/
//  https://www.youtube.com/watch?v=EWrSxJ7-Rdc&list=PLNxqWc8Uj2LQpbGv6I_HWf0kTj6kMVVwm&index=21
//  notes @ https://photos.google.com/photo/AF1QipMK785UGzhqt1Ln7UiZME19NaVgl2NBkpmk5vtW
//  check _20CheckIsPreOrderTraversalIsBST too
public class VerifyPreorderOfBST {

    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null)
            return false;

        int parent = -1;
        Stack<Integer> stack = new Stack<>();
        for (int value : preorder) {
            while (!stack.isEmpty() && stack.peek() < value) {
                parent = stack.pop();
            }
            if (value < parent)
                return false;
            stack.push(value);
        }
        return true;
    }
}
