package ds_algo._0dynamic_programming._5DPonTrees;

//  https://youtu.be/Osz-Vwer6rw?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go
public class _2MaxPathSum_AnyNode {

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
        int tempAns = Math.max(
                Math.max(l, r) + root.data,  //  when l, r are non-negative
                root.data   //  if l,r values are negative, I'll give my value alone
        );
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
        //  o/p is 6
//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);

        //  o/p is 42
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        _2MaxPathSum_AnyNode prob = new _2MaxPathSum_AnyNode();
        Helper helper = new Helper();
        prob.solve(root, helper);
        System.out.println("MaxPathSum : " + helper.a);
    }
}
