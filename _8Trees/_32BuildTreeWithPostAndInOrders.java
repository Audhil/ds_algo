package _8Trees;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//  DFS + DFS
//  https://www.youtube.com/watch?v=GL4QIvpT0XQ&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=36
//  notes @ https://photos.google.com/photo/AF1QipOc2qop17As_NzG8P0JMXP-EzC32imt13on8R2a
public class _32BuildTreeWithPostAndInOrders {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    static class IntWrapper {
        int start = 0;
    }

    //  with POST order
    private static void printTree(TreeNode root) {
        if (root == null)
            return;
        printTree(root.left);
        printTree(root.right);
        System.out.print(root.value + " ");
    }

    //  we are reducing search time from O(n) to O(1) with map
    private static TreeNode buildTreeWithMap(List<Integer> postOrderTraversal,
                                             List<Integer> inOrderTraversal,
                                             IntWrapper startIndexWrapper,
                                             int inOrderStartIndex,
                                             int inOrderEndIndex,
                                             Map<Integer, Integer> inOrderSearchMap) {
        if (startIndexWrapper.start < 0)
            return null;
        if (inOrderStartIndex > inOrderEndIndex)
            return null;
        //  following "Node R L" order
        TreeNode root = new TreeNode(postOrderTraversal.get(startIndexWrapper.start));
        int mid = inOrderSearchMap.get(postOrderTraversal.get(startIndexWrapper.start));
        startIndexWrapper.start--;
        root.right = buildTreeWithMap(postOrderTraversal, inOrderTraversal, startIndexWrapper, inOrderStartIndex, mid - 1);
        root.left = buildTreeWithMap(postOrderTraversal, inOrderTraversal, startIndexWrapper, mid + 1, inOrderEndIndex);
        return root;
    }

    private static TreeNode buildTreeWithMap(List<Integer> postOrderTraversal,
                                             List<Integer> inOrderTraversal,
                                             IntWrapper startIndexWrapper,
                                             int inOrderStartIndex,
                                             int inOrderEndIndex) {
        if (startIndexWrapper.start < 0)
            return null;
        if (inOrderStartIndex > inOrderEndIndex)
            return null;
        //  following "Node R L" order
        TreeNode root = new TreeNode(postOrderTraversal.get(startIndexWrapper.start));
        int mid = search(postOrderTraversal.get(startIndexWrapper.start), inOrderTraversal, inOrderStartIndex, inOrderEndIndex);
        startIndexWrapper.start--;
        root.right = buildTreeWithMap(postOrderTraversal, inOrderTraversal, startIndexWrapper, inOrderStartIndex, mid - 1);
        root.left = buildTreeWithMap(postOrderTraversal, inOrderTraversal, startIndexWrapper, mid + 1, inOrderEndIndex);
        return root;
    }

    private static int search(int item, List<Integer> inOrderTraversal, int inOrderStartIndex, int inOrderEndIndex) {
        for (int i = inOrderStartIndex; i < inOrderEndIndex; i++) {
            if (inOrderTraversal.get(i) == item)
                return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        List<Integer> postOrderTraversal = Arrays.asList(6, 2, 4, 5, 3, 1);
        List<Integer> inOrderTraversal = Arrays.asList(6, 2, 1, 4, 3, 5);
        Map<Integer, Integer> inOrderSearchMap = new HashMap<>();
        for (int i = 0; i < inOrderTraversal.size(); i++)
            inOrderSearchMap.put(inOrderTraversal.get(i), i);
        IntWrapper startIndexWrapper = new IntWrapper();
        startIndexWrapper.start = postOrderTraversal.size() - 1;
        int inOrderStartIndex = 0;
        int inOrderEndIndex = inOrderTraversal.size();
//        TreeNode root = buildTree(postOrderTraversal, inOrderTraversal, startIndexWrapper, inOrderStartIndex, inOrderEndIndex);
        TreeNode root = buildTreeWithMap(postOrderTraversal, inOrderTraversal, startIndexWrapper, inOrderStartIndex, inOrderEndIndex, inOrderSearchMap);
        System.out.println("yup: with postOrder traversal resultant tree is: ");
        printTree(root);  //  6 2 4 5 3 1
    }
}
