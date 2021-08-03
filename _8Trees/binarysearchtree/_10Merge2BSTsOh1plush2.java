package _8Trees.binarysearchtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//  https://www.youtube.com/watch?v=g4DwrMNTdvw&list=PLNxqWc8Uj2LQpbGv6I_HWf0kTj6kMVVwm&index=12
public class _10Merge2BSTsOh1plush2 {

    //  merge 2 BSTs with O(h1+h2) space
    //  tip: if encountered with O(h), always think of stack

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    //  loads stack with all nodes to left - to find just most bigger than current node
    private static void util(TreeNode root, Stack<TreeNode> stack) {
        if (root == null)
            return;

        TreeNode temp = root;
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
    }

    private static List<Integer> mergeBST(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return null;
        List<Integer> resList = new ArrayList<>();

        //  load all left nodes
        Stack<TreeNode> s1 = new Stack<>();
        util(root1, s1);
        Stack<TreeNode> s2 = new Stack<>();
        util(root2, s2);

        while (!s1.isEmpty() && !s2.isEmpty()) {
            TreeNode tempNode;
            if (s1.peek().value < s2.peek().value) {
                tempNode = s1.pop();
                util(tempNode.right, s1);   //  go to just most bigger than current node
            } else if (s1.peek().value > s2.peek().value) {
                tempNode = s2.pop();
                util(tempNode.right, s2);   //  go to just most bigger than current node
            }
            //  if equal
            else {
                tempNode = s1.peek();   //  let's take one value
                s1.pop();
                s2.pop();
                util(tempNode.right, s1);
                util(tempNode.right, s2);
            }
            resList.add(tempNode.value);
        }
        return resList;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(30);
        root1.left = new TreeNode(17);
        root1.right = new TreeNode(40);
        root1.left.left = new TreeNode(15);
        root1.left.right = new TreeNode(20);

        TreeNode root2 = new TreeNode(24);
        root2.left = new TreeNode(16);
        root2.right = new TreeNode(29);
        root2.left.right = new TreeNode(18);
        root2.right.right = new TreeNode(30);

        List<Integer> mergedList = mergeBST(root1, root2);
        System.out.println("yup: mergedList: " + mergedList);   //  yup: mergedList: [15, 16, 17, 18, 20, 24, 29, 30, 40]
    }
}
