package ds_algo._1Recursion;

//  https://youtu.be/aqLTbtWh40E?list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY
public class _3HeightOfTree {

    static class Node {
        Node left;
        Node right;
    }

    private int heightOfTree(Node root) {
        //  base condition
        if (root == null)
            return 0;

        //  hypothesis
        int lheight = heightOfTree(root.left);
        int rheight = heightOfTree(root.right);

        //  induction
        return 1 + Math.max(lheight, rheight);
    }

    public static void main(String[] args) {
        Node root = new Node();
        root.left = new Node();
        root.right = new Node();
        root.left.left = new Node();
        root.left.right = new Node();

        _3HeightOfTree prob = new _3HeightOfTree();
        System.out.println("yup: height of tree: " + prob.heightOfTree(root));
    }
}
