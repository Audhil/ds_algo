package _8Trees;

//  https://www.youtube.com/watch?v=gHU-vDGTXHE&list=PLNxqWc8Uj2LRbsOlBiPJZAyZpaUwdDepd&index=40
//  notes @ https://photos.google.com/photo/AF1QipOfogGagOOrhC1oAzoLKqVc8KKTB3bgOlzLjD_p
public class _35CreateTreeFromPostfixNotation {

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

    private static TreeNode generateTree(char[] postfix, IntWrapper currIndex) {
        if (currIndex.currIndex < 0)
            return null;

        char currentItem = postfix[currIndex.currIndex];
        currIndex.currIndex--;
        TreeNode root = new TreeNode(currentItem);
        if (currentItem == '+'
                || currentItem == '-'
                || currentItem == '*'
                || currentItem == '/'
                || currentItem == '^') {
            root.right = generateTree(postfix, currIndex);
            root.left = generateTree(postfix, currIndex);
        }
        return root;
    }

    private static void printLL(TreeNode root) {
        if (root == null)
            return;
        printLL(root.left);
        printLL(root.right);
        System.out.print(root.value + " ");
    }

    public static void main(String[] args) {
        char[] postfix = "ab-c+de/*".toCharArray();
        IntWrapper currIndex = new IntWrapper(postfix.length - 1);
        TreeNode root = generateTree(postfix, currIndex);
        System.out.println("yup: resultant tree:");
        printLL(root);  //  a b - c + d e / *
    }
}
