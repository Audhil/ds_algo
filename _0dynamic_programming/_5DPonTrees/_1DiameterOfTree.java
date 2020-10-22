package ds_algo._0dynamic_programming._5DPonTrees;

//  https://youtu.be/zmPj_Ee3B8c?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go
public class _1DiameterOfTree {

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

    private int solve(Node root, Helper helper) {
        //  base condition
        if (root == null)
            return 0;

        //  hypothesis
        int left = solve(root.left, helper);
        int right = solve(root.right, helper);

        //  induction
        int temp = Math.max(left, right) + 1;   //  passes to next node, since diameter doesn't calculated with this node
        int ans = Math.max(temp, 1 + left + right); //  if diameter is calculated through this node
        helper.a = Math.max(helper.a, ans);

        return temp;
    }

    public static void main(String[] args) {
        Node root = new Node(100);
        root.left = new Node(33);
        root.right = new Node(1);
        root.left.left = new Node(222);
        root.left.right = new Node(44);

        _1DiameterOfTree prob = new _1DiameterOfTree();
        Helper helper = new Helper();
        prob.solve(root, helper);
        System.out.println("yup diameter is: " + helper.a);
    }
}
