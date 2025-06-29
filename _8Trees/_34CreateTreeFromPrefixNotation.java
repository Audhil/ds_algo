package _8Trees;

//  https://www.youtube.com/watch?v=Op0hpYho56Q&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=39
//  notes @ https://photos.google.com/photo/AF1QipOwyE5z3vWOgRbmzB_diOKWB4uMAntm6ZbqQW3M
public class _34CreateTreeFromPrefixNotation {

    static class TreeNode {
        char value;
        TreeNode left, right;

        public TreeNode(char value) {
            this.value = value;
        }
    }

    static class IntWrapper {
        int currIndex;

        public IntWrapper(int currIndex) {
            this.currIndex = currIndex;
        }
    }

    private static void printLL(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.value + " ");
        printLL(root.left);
        printLL(root.right);
    }

    private static TreeNode generateTree(char[] prefix, IntWrapper currIndex) {
        if (currIndex.currIndex == prefix.length)
            return null;

        char currentItem = prefix[currIndex.currIndex];
        currIndex.currIndex++;
        TreeNode root = new TreeNode(currentItem);
        if (currentItem == '+'
                || currentItem == '-'
                || currentItem == '*'
                || currentItem == '/'
                || currentItem == '^') {
            root.left = generateTree(prefix, currIndex);
            root.right = generateTree(prefix, currIndex);
        }
        return root;
    }

    public static void main(String[] args) {
        char[] prefix = "*+34/76".toCharArray();
        IntWrapper currIndex = new IntWrapper(0);
        TreeNode root = generateTree(prefix, currIndex);
        System.out.println("yup: resultant tree:");
        printLL(root);  //  * + 3 4 / 7 6
    }
}
