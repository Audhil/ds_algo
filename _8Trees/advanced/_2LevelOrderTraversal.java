package _8Trees.advanced;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//  https://www.youtube.com/watch?v=W8AwZB2-VMI&list=PLNxqWc8Uj2LTupAJUeWvWzRTVT9NX36lY&index=3
//  notes @ https://photos.google.com/photo/AF1QipNwiCAQ6MJYRnXn920GH_uZ3W8K4g8rOLJ8RyiP
public class _2LevelOrderTraversal {

    static class TreeNode {
        int value;
        List<TreeNode> children;

        public TreeNode(int value, List<TreeNode> children) {
            this.value = value;
            this.children = children;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "value=" + value +
                    ", children=" + children +
                    '}';
        }
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return null;

        List<List<Integer>> levelOrderList = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                levelOrderList.add(tempList);
                tempList = new ArrayList<>();
                //  if all levels are traversed - queue will be empty, just return
                if (queue.isEmpty())
                    return levelOrderList;
                //  add null to separate levels
                queue.add(null);
            } else {
                tempList.add(node.value);
                queue.addAll(node.children);
            }
        }
        return levelOrderList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new ArrayList<>());
        for (int i = 2; i <= 5; i++) {
            root.children.add(new TreeNode(i, new ArrayList<>()));
        }
        TreeNode child2 = root.children.get(0);
        for (int i = 6; i <= 7; i++) {
            child2.children.add(new TreeNode(i, new ArrayList<>()));
        }

        TreeNode child3 = root.children.get(1);
        child3.children.add(new TreeNode(12, new ArrayList<>()));
        child3.children.add(new TreeNode(14, new ArrayList<>()));
        child3.children.add(new TreeNode(9, new ArrayList<>()));

        TreeNode child5 = root.children.get(3);
        child5.children.add(new TreeNode(17, new ArrayList<>()));

        TreeNode child14 = child3.children.get(1);
        child14.children.add(new TreeNode(19, new ArrayList<>()));
        System.out.println("Level Order Traversal:");
        List<List<Integer>> lOrder = levelOrder(root);
        for (List<Integer> list : lOrder) {
            list.forEach(integer -> {
                System.out.print(integer + " ");
            });
            System.out.println();
        }
    }
}
