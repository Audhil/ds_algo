package _8Trees.advanced.avltrees;

//  https://www.youtube.com/watch?v=a96JFhw5Ee4 - src code
//  https://www.youtube.com/watch?v=vRwi_UcZGjU
//  src code = https://github.com/coding-blocks-archives/JavaWebinars/tree/master/src/AVLTree
//  notes @ https://photos.google.com/photo/AF1QipM83ooPku4URBzQ9RhZfVnLqe-as6UEGDj3P7lp
//  https://photos.google.com/photo/AF1QipPlNAR1_5PaPPEmryqQp_8kHdBO_8wiWSqtWhwT
//  https://photos.google.com/photo/AF1QipOwPrQ0lRmuJeBxyprQsR6VT2fICI_jBDIAWskM
public class AVLTree {

    private static class TreeNode {

        int data;
        TreeNode left, right;
        int height;

        public TreeNode(int data) {
            this.data = data;
            this.height = 1;
        }
    }

    private static TreeNode root = null;

    public static void insert(int data) {
        root = insert(root, data);
    }

    private static TreeNode insert(TreeNode root, int data) {
        if (root == null)
            return new TreeNode(data);

//        if (root.data == data)
//            return root;

        if (root.data < data)
            root.left = insert(root.left, data);
        else if (root.data > data)
            root.right = insert(root.right, data);

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        int bf = bf(root);

        //  Left heavy - LL
        if (bf > 1 && data < root.left.data)
            return rightRotate(root);

        //  right heavy - RR
        if (bf < -1 && data > root.right.data)
            return leftRotate(root);

        //  LR
        if (bf > 1 && data > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        //  RL
        if (bf < -1 && data < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

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

    private static TreeNode leftRotate(TreeNode c) {
//        if (c.right == null)
//            return null;
        TreeNode b = c.right;
        TreeNode t2 = b.left;

        //  rotate
        b.left = c;
        c.right = t2;

        //  update heights
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        b.height = Math.max(height(b.left), height(b.right)) + 1;
        return b;
    }

    private static TreeNode rightRotate(TreeNode c) {
//        if (c.left == null)
//            return null;
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
        insert(10);
        insert(5);
        insert(15);
        insert(27);
        insert(19);
        insert(16);
        display();
    }
}