package _8Trees.binarysearchtree;

//  https://www.youtube.com/watch?v=AHRRIZWKGPY
//  TC: O(n), SC: O(1)
//  notes @ https://photos.google.com/photo/AF1QipMmhz72lfIu6eiBj1x3FpgMsMyPrBE6A4Z1GF1x
//  https://photos.google.com/photo/AF1QipMwLTqO4z00dqg2xVE1bApApbnH4pXhqGxGYg9C
//  No stack, no recursion
//  not using any space to store in order traversal result
public class _19MorrisTraversal {

    static class TreeNode {
        int value;
        TreeNode left, right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    private static void morrisTraversal(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            //  if no left child - process & move right;
            if (current.left == null) {
                System.out.print(current.value + " ");  //  processing
                current = current.right;
            } else {
                TreeNode prev = current.left;
                //  goto right most & make connection
                while (prev.right != null && prev.right != current) {
                    prev = prev.right;
                }
                //  make connection
                if(prev.right == null){
                    prev.right = current;
                    current = current.left;
                }
                else {
                    System.out.print(current.value+" ");    //  processing
                    prev.right = null;  //  remove link
                    current = current.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(40);
        root.right = new TreeNode(60);
        root.left.left = new TreeNode(30);
        root.left.right = new TreeNode(45);
        root.right.right = new TreeNode(65);
        System.out.println("with morris traversal:");
        morrisTraversal(root);
    }
}
