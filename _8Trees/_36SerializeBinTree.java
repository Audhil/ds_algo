package _8Trees;

import java.util.ArrayList;
import java.util.List;

//  https://www.youtube.com/watch?v=Se7y4Nl0cCM&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=41
//  notes @ https://photos.google.com/photo/AF1QipPIOcnvldJOl5Z6sHQspxjFxBTcbA-AAKEvmni9
public class _36SerializeBinTree {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    //  serializing with preOrder + marker(-1)
    private static void serialize(TreeNode root,
                                  List<Integer> serializedList) {
        if (root == null) {
            serializedList.add(-1);
            return;
        }
        serializedList.add(root.value);
        serialize(root.left, serializedList);
        serialize(root.right, serializedList);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        List<Integer> serializedList = new ArrayList<>();
        serialize(root, serializedList);
        serializedList.forEach(integer -> System.out.print(integer + " "));
    }
}
