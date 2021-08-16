package _8Trees.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

//  https://leetcode.com/problems/unique-binary-search-trees-ii/submissions/
public class _31UniqueBSTRoots {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    private static List<TreeNode> uniqueBSTs(int n) {
        return util(1, n);
    }

    private static List<TreeNode> util(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end)
            list.add(null);
        else
            for (int i = start; i <= end; i++) {
                List<TreeNode> leftNodes = util(start, i - 1);
                List<TreeNode> rightNodes = util(i + 1, end);

                for (TreeNode leftNode : leftNodes) {
                    for (TreeNode rightNode : rightNodes) {
                        TreeNode tempNode = new TreeNode(i, leftNode, rightNode);
                        list.add(tempNode);
                    }
                }
            }
        return list;
    }

    public static void main(String[] args) {
        List<TreeNode> list = uniqueBSTs(2);
        System.out.println("yup: uniqueBSTs(): " + list);
        System.out.println("yup: uniqueBSTs().size(): " + list.size());
    }
}
