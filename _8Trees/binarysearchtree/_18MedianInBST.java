package _8Trees.binarysearchtree;

//  https://www.youtube.com/watch?v=CVXPIRMjO-w&list=PLNxqWc8Uj2LQpbGv6I_HWf0kTj6kMVVwm&index=20
//  find median with Morris traversal - TC: O(n) & SC: O(1)
//  src code: https://www.geeksforgeeks.org/find-median-bst-time-o1-space/
public class _18MedianInBST {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        int count = 0;
        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                count++;    //  processing the node
                current = current.right;
            } else {
                TreeNode prev = current.left;
                while (prev.right != null && prev.right != current) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = current;
                    current = current.left;
                } else {
                    count++;    //  processing the node
                    prev.right = null;
                    current = current.right;
                }
            }
        }
        return count;
    }

    private static int findMedian(TreeNode root) {
        if (root == null)
            return 0;

        int count = countNodes(root);   //  with morris traversal

        int currCount = 0;
        TreeNode current = root, prev = new TreeNode(0);
        while (current != null) {
            if (current.left == null) {
                currCount++;

                //  if count is odd
                if (count % 2 != 0 && currCount == (count + 1) / 2) {
                    return prev.value;
                }
                //  if count is even
                else if (count % 2 == 0 && currCount == (count / 2) + 1) {
                    return (prev.value + current.value) / 2;
                }
                prev = current;
                current = current.right;
            } else {
                TreeNode pre = current.left;
                while (pre.right != null && pre.right != current) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    currCount++;

                    pre.right = null;
                    prev = pre;

                    //  if count is odd
                    if (count % 2 != 0 && currCount == (count + 1) / 2) {
                        return current.value;
                    }
                    //  if count is even
                    else if (count % 2 == 0 && currCount == (count / 2) + 1) {
                        return (prev.value + current.value) / 2;
                    }

                    prev = current;
                    current = current.right;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(40);
        root.right = new TreeNode(60);
        root.left.left = new TreeNode(30);
        root.left.right = new TreeNode(45);
        root.right.left = new TreeNode(55);
        root.right.right = new TreeNode(65);
        root.left.right.right = new TreeNode(47);
        System.out.println("yup: median of BST: " + findMedian(root));  //  yup: median of BST: 48
    }
}
