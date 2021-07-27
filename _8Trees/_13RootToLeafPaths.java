package _8Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

//  https://www.youtube.com/watch?v=HQqoIl2RPLw&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=17
//  notes @ https://photos.google.com/photo/AF1QipMC-ciYLJ_ul_djf63y6UXZLdc4wrgDbinejEjx
//  ref: https://www.techiedelight.com/print-all-paths-from-root-to-leaf-nodes-binary-tree/
public class _13RootToLeafPaths {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static List<List<Integer>> rootToLeafPaths(TreeNode root) {
        if (root == null)
            return null;

        List<List<Integer>> paths = new ArrayList<>();
        Deque<Integer> currPath = new ArrayDeque<>();
        findAllPaths(root, currPath, paths);
        return paths;
    }

    private static void findAllPaths(TreeNode root, Deque<Integer> currPath, List<List<Integer>> paths) {
        if (root == null)
            return;

        currPath.addLast(root.value);

        if (root.left == null && root.right == null)
            paths.add(new ArrayList<>(currPath));

        findAllPaths(root.left, currPath, paths);
        findAllPaths(root.right, currPath, paths);

        //  back tracking
        currPath.removeLast();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println("yup: all paths: " + rootToLeafPaths(root)); //  yup: all paths: [[1, 2, 4], [1, 2, 5], [1, 3, 7]]
    }
}
