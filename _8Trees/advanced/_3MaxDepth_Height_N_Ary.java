package _8Trees.advanced;

import java.util.ArrayList;
import java.util.List;

//  https://www.youtube.com/watch?v=xdIjxF8zrVo&list=PLNxqWc8Uj2LTupAJUeWvWzRTVT9NX36lY&index=4
//  notes @ https://photos.google.com/photo/AF1QipNaxHcWizxS5O6VVmVi7lCheKmbukHNOvumHxik
public class _3MaxDepth_Height_N_Ary {

    //  tip: max depth = 1 + max height;

    static class TreeNode {
        int value;
        List<TreeNode> children;

        public TreeNode(int value, List<TreeNode> children) {
            this.value = value;
            this.children = children;
        }
    }

    private static int height(TreeNode root) {
        if (root == null)
            return 0;

        int maxHeight = 0;
        for (TreeNode child : root.children) {
            maxHeight = Math.max(maxHeight, height(child));
        }
        return 1 + maxHeight;   //  depth
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new ArrayList<>());
        root.children.add(new TreeNode(5, new ArrayList<>()));
        root.children.add(new TreeNode(10, new ArrayList<>()));
        root.children.add(new TreeNode(15, new ArrayList<>()));
        root.children.add(new TreeNode(20, new ArrayList<>()));

        root.children.get(0).children.add(new TreeNode(12, new ArrayList<>()));

        root.children.get(1).children.add(new TreeNode(13, new ArrayList<>()));
        root.children.get(1).children.add(new TreeNode(14, new ArrayList<>()));

        root.children.get(3).children.add(new TreeNode(20, new ArrayList<>()));

        root.children.get(1).children.get(0).children.add(new TreeNode(19, new ArrayList<>()));
        root.children.get(1).children.get(1).children.add(new TreeNode(24, new ArrayList<>()));

        root.children.get(1).children.get(0).children.get(0).children.add(new TreeNode(21, new ArrayList<>()));

        System.out.println("max depth of " + height(root));
    }
}
