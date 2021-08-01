package _8Trees;

//  https://www.youtube.com/watch?v=50gLZnIxqHw&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=42
//  notes @ https://photos.google.com/photo/AF1QipPDkgVDKhaf33GzCIaMDaFeTXOJuGy3cXe6ilB1
import java.util.Arrays;
import java.util.List;

public class _37DeSerializeBinTree {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    static class IntWrapper {
        int currIndex;

        public IntWrapper(int currIndex) {
            this.currIndex = currIndex;
        }
    }


    //  print tree with preOrder
    private static void printTree(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.value + " ");
        printTree(root.left);
        printTree(root.right);
    }

    //  deserialize with pre order traversal
    private static TreeNode deSerialize(List<Integer> serializedList, IntWrapper currIndex) {
        if (currIndex.currIndex == serializedList.size())
            return null;

        TreeNode root = null;
        Integer currItem = serializedList.get(currIndex.currIndex);
        currIndex.currIndex++;
        if (currItem != -1) {
            root = new TreeNode(currItem);
            root.left = deSerialize(serializedList, currIndex);
            root.right = deSerialize(serializedList, currIndex);
        }

        return root;
    }

    public static void main(String[] args) {
        List<Integer> serializedList = Arrays.asList(1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1);
        IntWrapper currIndex = new IntWrapper(0);
        TreeNode root = deSerialize(serializedList, currIndex);
        System.out.println("preOrder of resultant tree:");
        printTree(root);    //  1 2 4 5 3 6
    }
}
