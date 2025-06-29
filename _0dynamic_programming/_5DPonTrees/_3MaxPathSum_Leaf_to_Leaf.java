package ds_algo._0dynamic_programming._5DPonTrees;

//  https://youtu.be/ArNyupe-XH0?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go
public class _3MaxPathSum_Leaf_to_Leaf {

    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    private static class Helper {
        int a = Integer.MIN_VALUE;
    }

    int solve(Node root, Helper helper) {
        if (root == null)
            return 0;

        int l = solve(root.left, helper);
        int r = solve(root.right, helper);

        //  passes route to next node
        int tempAns = Math.max(l, r) + root.data;  //  when l, r are non-negative

        if (root.left == null && root.right == null)
            tempAns = Math.max(tempAns, root.data); //  when l,r are negative, I'll give my value alone - But only if it is leaf nodee

        //  passes through this node
        int ans = Math.max(
                tempAns,
                l + r + root.data
        );

        helper.a = Math.max(
                helper.a,
                ans
        );
        return tempAns;
    }

    public static void main(String[] args) {
        //  o/p is 20
        Node root = new Node(-15);
        root.left = new Node(5);
        root.right = new Node(6);
        root.left.left = new Node(-8);
        root.left.right = new Node(1);
        root.right.left = new Node(3);
        root.right.left.right = new Node(0);
        root.right.right = new Node(9);
        root.left.left.left = new Node(2);
        root.left.left.right = new Node(6);
        root.left.left.right.left = new Node(4);
        root.left.left.right.right = new Node(-1);
        root.left.left.right.left.left = new Node(10);


        _3MaxPathSum_Leaf_to_Leaf prob = new _3MaxPathSum_Leaf_to_Leaf();
        Helper helper = new Helper();
        prob.solve(root, helper);
        System.out.println("MaxPathSum : " + helper.a);
    }
}
