package _8Trees;

import java.util.ArrayList;
import java.util.List;

//  https://www.youtube.com/watch?v=5QmxdI1Reso&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=43
public class _38IsSubtreeWithSerialization {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(5);

        List<Integer> serList1 = new ArrayList<>();
        serialize(root, serList1);

        List<Integer> serList2 = new ArrayList<>();
        serialize(root2, serList2);

        System.out.println("yup: is subtree of another?: " + serList1.containsAll(serList2));   //  true
    }

    //  with pre order
    private static void serialize(TreeNode root, List<Integer> serList) {
        if (root == null) {
            serList.add(-1);
            return;
        }

        serList.add(root.value);
        serialize(root.left, serList);
        serialize(root.right, serList);
    }
}
