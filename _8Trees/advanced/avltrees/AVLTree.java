package _8Trees.advanced.avltrees;

//  https://www.youtube.com/watch?v=a96JFhw5Ee4 - src code
//  https://www.youtube.com/watch?v=vRwi_UcZGjU
public class AVLTree {

    private static class TreeNode {

        int data;
        TreeNode left, right;
        int height;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    private static TreeNode root = null;

    public static void insert(int data) {
        root = insert(root, data);
    }

    private static TreeNode insert(TreeNode root, int data) {
        if (root == null)
            return new TreeNode(data);

        if (root.data == data)
            return root;

        if (root.data < data)
            root.left = insert(root.left, data);
        else
            root.right = insert(root.right, data);

        root.height = Math.max(height(root.left), height(root.right)) + 1;

        return root;
    }

    public static void display() {
        display(root);
    }

    private static void display(TreeNode root) {
        if (root == null)
            return;

        String str = "";
        if (root.left == null)
            str += ".";
        else
            str += root.left.data;

        str += " => " + root.data + " <= ";

        if (root.right == null)
            str += ".";
        else
            str += root.right.data;
        System.out.println(str);

        display(root.left);
        display(root.right);
    }

    private static int bf(TreeNode root) {
        if (root == null)
            return 0;

        return height(root.left) - height(root.right);
    }

    private static int height(TreeNode root) {
        if (root == null)
            return 0;

        return root.height;
    }

    private static TreeNode rightRotate(TreeNode c) {
        TreeNode b = c.left;
        TreeNode t3 = b.right;

        //  rotate
        b.right = c;
        c.left = t3;

        //  update heights
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        b.height = Math.max(height(b.left), height(b.right)) + 1;
        return b;
    }

    public static void main(String[] args) {
        insert(20);
        insert(25);
        insert(30);
        insert(5);
        insert(15);
        insert(27);
        insert(19);
        insert(16);
        display();
    }
}