package _8Trees;

import java.util.*;

//  https://www.youtube.com/watch?v=8ND-GB8hpJI&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=9
//  notes @ https://photos.google.com/photo/AF1QipPvyVt0a5s-ArSFPZSFyfxDlAWFZMrB9gun_grR
//  TC: O(n) & SC: O(n)
public class _4DiagonalTraversalwithPreOrder {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    static class PairOf {
        TreeNode node;
        int hd; //  horizontal distance

        public PairOf(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    private static Map<Integer, List<Integer>> diagonalOrderTraversal(TreeNode root) {
        if (root == null)
            return null;
        LinkedList<PairOf> queue = new LinkedList<>();
        queue.add(new PairOf(root, 0));
        Map<Integer, List<Integer>> map = new HashMap<>();

        while (!queue.isEmpty()) {
            PairOf pair = queue.poll();
            TreeNode tempNode = pair.node;
            int hd = pair.hd;
            //  process the node
            if (map.get(hd) == null) {
                List<Integer> list = new ArrayList<>();
                list.add(tempNode.value);
                map.put(hd, list);
            } else {
                List<Integer> tmpList = map.get(hd);
                tmpList.add(tempNode.value);
                map.put(hd, tmpList);
            }
            if (tempNode.left != null)
                queue.add(new PairOf(tempNode.left, hd + 1));
            if (tempNode.right != null)
                queue.add(new PairOf(tempNode.right, hd));
        }
        return map;
    }

    //  with recursion
    private static void preOrder(TreeNode root, Map<Integer, List<Integer>> map, int hd) {
        if (root == null)
            return;

        //  process the node
        if (map.get(hd) == null) {
            List<Integer> list = new ArrayList<>();
            list.add(root.value);
            map.put(hd, list);
        } else {
            List<Integer> tmpList = map.get(hd);
            tmpList.add(root.value);
            map.put(hd, tmpList);
        }

        //  left
        preOrder(root.left, map, hd + 1);
        //  right
        preOrder(root.right, map, hd);
    }

    private static Map<Integer, List<Integer>> diagonalTraversalWithRecursion(TreeNode root) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        preOrder(root, map, 0);
        return map;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("yup: diagonalOrderTraversal: " + diagonalOrderTraversal(root));
        System.out.println("yup: diagonalTraversalWithRecursion: " + diagonalTraversalWithRecursion(root));
    }
}
