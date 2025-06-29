package _8Trees.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

//  https://www.youtube.com/watch?v=pCn1Q__CnKs&list=PLNxqWc8Uj2LQpbGv6I_HWf0kTj6kMVVwm&index=11
public class _9Merge2BSTs {
    //  step 1: find inOrder traversal of 2 trees
    //  step 2: merge both inOrder traversal List
    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static List<Integer> mergeBST(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null)
            return null;

        List<Integer> list1 = new ArrayList<>();
        inOrderTraversal(root1, list1);

        List<Integer> list2 = new ArrayList<>();
        inOrderTraversal(root2, list2);
        System.out.println("yup: list1: " + list1);
        System.out.println("yup: list2: " + list2);
        return merge(list1, list2);
    }

    private static List<Integer> merge(List<Integer> list1, List<Integer> list2) {
        if (list1 == null || list2 == null)
            return null;

        List<Integer> mergeList = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                mergeList.add(list1.get(i++));
            } else if (list1.get(i) > list2.get(j)) {
                mergeList.add(list2.get(j++));
            } else {
                mergeList.add(list1.get(i++));
//                mergeList.add(list2.get(j++));    //  ignore this item, since each item in BST is unique
                j++;
            }
        }
        while (i < list1.size())
            mergeList.add(list1.get(i++));

        while (j < list2.size())
            mergeList.add(list2.get(j++));
        return mergeList;
    }

    private static void inOrderTraversal(TreeNode root, List<Integer> integers) {
        if (root == null)
            return;

        inOrderTraversal(root.left, integers);
        integers.add(root.value);
        inOrderTraversal(root.right, integers);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(24);
        root1.left = new TreeNode(16);
        root1.right = new TreeNode(30);
        root1.left.left = new TreeNode(10);
        root1.left.right = new TreeNode(18);
        root1.right.right = new TreeNode(34);

        TreeNode root2 = new TreeNode(20);
        root2.left = new TreeNode(18);
        root2.right = new TreeNode(25);
        root2.left.left = new TreeNode(14);
        root2.right.left = new TreeNode(23);

        List<Integer> mergedList = mergeBST(root1, root2);
        System.out.println("yup: mergedList: " + mergedList);
    }
}
