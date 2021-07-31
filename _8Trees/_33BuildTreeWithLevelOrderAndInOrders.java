package _8Trees;

import java.util.*;

//  BFS + DFS
//  https://www.youtube.com/watch?v=f5nv35xfMuA&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=37
//  notes @ https://photos.google.com/photo/AF1QipPJ46_M_YwlBuXiyXfCI-VasTGP3FYeW6tVke1O
//  StackOverflows - need to check again
public class _33BuildTreeWithLevelOrderAndInOrders {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static List<Integer> findItemsIninOrder(List<Integer> inOrderTraversal, int startIndex, int endIndex) {
        List<Integer> resList = new ArrayList<>();
        for (int i = startIndex; i <= endIndex && i < inOrderTraversal.size(); i++) {
            resList.add(inOrderTraversal.get(i));
        }
        return resList;
    }

    private static List<Integer> findItemsInLevelOrder(List<Integer> levelOrderTraversal,
                                                       List<Integer> inOrderTraversal,
                                                       int startIndex,
                                                       int endIndex) {
        List<Integer> resList = new ArrayList<>();
        for (int i = startIndex; i <= endIndex && i < inOrderTraversal.size(); i++) {
            for (Integer integer : levelOrderTraversal) {
                if (inOrderTraversal.get(i).intValue() == integer.intValue()) {
                    resList.add(integer);
                }
            }
        }
        return resList;
    }

    private static TreeNode buildTreeWithMap(List<Integer> levelOrderTraversal,
                                             List<Integer> inOrderTraversal,
                                             Map<Integer, Integer> inOrderSearchMap) {
        if (inOrderTraversal.size() == 0)
            return null;
        TreeNode root = new TreeNode(levelOrderTraversal.get(0));
        int mid = inOrderSearchMap.get(levelOrderTraversal.get(0));
        //  items in level order
        List<Integer> left = findItemsInLevelOrder(levelOrderTraversal, inOrderTraversal, 0, mid - 1);
        List<Integer> right = findItemsInLevelOrder(levelOrderTraversal, inOrderTraversal, mid + 1, inOrderSearchMap.size() - 1);
        //  items in in order
        List<Integer> itemsLeft = findItemsIninOrder(inOrderTraversal, 0, mid - 1);
        List<Integer> itemsRight = findItemsIninOrder(inOrderTraversal, mid + 1, inOrderSearchMap.size() - 1);
        root.left = buildTreeWithMap(left, itemsLeft, inOrderSearchMap);
        root.right = buildTreeWithMap(right, itemsRight, inOrderSearchMap);
        return root;
    }

    //  with level order traversal
    private static void printTree(TreeNode root) {
        if (root == null)
            return;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tempNode = queue.poll();
            System.out.print(tempNode.value + " ");
            if (tempNode.left != null)
                queue.add(tempNode.left);
            if (tempNode.right != null)
                queue.add(tempNode.right);
        }
    }

    public static void main(String[] args) {
        List<Integer> levelOrderTraversal = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> inOrderTraversal = Arrays.asList(4, 2, 5, 1, 3, 6);
        Map<Integer, Integer> inOrderSearchMap = new HashMap<>();
        for (int i = 0; i < inOrderTraversal.size(); i++)
            inOrderSearchMap.put(inOrderTraversal.get(i), i);
        TreeNode root = buildTreeWithMap(levelOrderTraversal, inOrderTraversal, inOrderSearchMap);
        System.out.println("yup: with LevelOrder traversal resultant tree is: ");
        printTree(root);
    }
}
