package _8Trees;

import java.util.ArrayList;
import java.util.List;

//  https://www.youtube.com/watch?v=MqOoC_w4TcY&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=20
//  notes @ https://photos.google.com/photo/AF1QipMp-UbFuLXE_lbbfOUjjx_sVXwpigGpiyeZiiYx
public class _16KthNodeFromRoot {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static void findKthNodeFromRoot(TreeNode root, int k, List<Integer> nodeList) {
        if (root == null)
            return;

        if (k == 0)
            nodeList.add(root.value);

        findKthNodeFromRoot(root.left, k - 1, nodeList);
        findKthNodeFromRoot(root.right, k - 1, nodeList);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        int k = 4;
        List<Integer> nodes = new ArrayList<>();
        findKthNodeFromRoot(root, k, nodes);
        //  k = 0; nodes: [1]
        //  k = 1; nodes: [2,3]
        //  k = 2; nodes: [4,5,7]
        //  k = 3; nodes: [6,8]
        //  k = 4; nodes: []
        System.out.println("yup: nodes at k: " + k + " distance are : " + nodes);
    }
}