package _8Trees.advanced;

import java.util.ArrayList;
import java.util.List;

//  https://www.youtube.com/watch?v=-fOTdKKGpqg&list=PLNxqWc8Uj2LTupAJUeWvWzRTVT9NX36lY&index=2
//  notes @ https://photos.google.com/photo/AF1QipOKNbqYOYwmGOUEVXkRekOSIrEIkY5kmXWcuLu5
public class _1_N_ary_tree {

    static class TreeNode {
        int value;
        List<TreeNode> children;

        public TreeNode(int value, List<TreeNode> children) {
            this.value = value;
            this.children = children;
        }
    }

    private static void postOrder(TreeNode root) {
        if (root == null)
            return;

        for (TreeNode child : root.children)
            postOrder(child);
        System.out.print(root.value + " ");
    }

    private static void preOrder(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.value + " ");
        for (TreeNode child : root.children)
            preOrder(child);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new ArrayList<>());
        for (int i = 2; i < 10; i++) {
            root.children.add(new TreeNode(i, new ArrayList<>()));
        }
        System.out.println("yup: preOrder");
        preOrder(root);
        System.out.println("\nyup: postOrder");
        postOrder(root);
    }
}
