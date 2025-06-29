package _8Trees;

import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

//  https://www.youtube.com/watch?v=JMBFm__krXw&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=15
//  notes @ https://photos.google.com/photo/AF1QipNIansgEOImM2VCLh-RQqalCf5ea2RPzYTyzxCO
public class _10TopViewOfBinaryTree {

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

    private static Map<Integer, Integer> topViewOfBinaryTree(TreeNode root) {
        return computeWithVerticalOrderTraversal(root);
    }

    private static Map<Integer, Integer> computeWithVerticalOrderTraversal(TreeNode root) {
        if (root == null)
            return null;

        Map<Integer, Integer> map = new TreeMap<>();    //  using TreeMap = to keep entries in sorted form
        LinkedList<PairOf> queue = new LinkedList<>();
        queue.add(new PairOf(root, 0));

        while (!queue.isEmpty()) {
            //  dequeue
            PairOf pair = queue.poll();
            int hd = pair.hd;
            TreeNode tempNode = pair.node;

            //  process the node
            if (map.get(hd) == null)
                map.put(hd, tempNode.value);
            if (tempNode.left != null)
                queue.add(new PairOf(tempNode.left, hd - 1));
            if (tempNode.right != null)
                queue.add(new PairOf(tempNode.right, hd + 1));
        }
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
        root.right.left.right = new TreeNode(8);
        root.right.left.right.right = new TreeNode(9);

        System.out.println("topView is : ");    //  4 2 1 3 7
        topViewOfBinaryTree(root).forEach((key, value) -> {
            System.out.print(value + " ");
        });
    }
}
