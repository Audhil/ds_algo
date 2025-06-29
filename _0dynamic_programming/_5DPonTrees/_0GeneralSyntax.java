package ds_algo._0dynamic_programming._5DPonTrees;

//  https://youtu.be/d1u2t018Kjg?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go
public class _0GeneralSyntax {

    /*
     *
     * int func(i/p){
     *   base condition
     *
     *   hypothesis - don't question this
     *
     *   induction   - calculate result of a node, with inputs from hypothesis step
     * }
     * */

    //  sample code
    class Node {
        Node left;
        Node right;
    }

    int solve(Node root, int res) {
        //  base condition
        if (root == null)
            return 0;

        //  hypothesis
        int l = solve(root.left, res);
        int r = solve(root.right, res);

        //  induction
        int tempAns = 1 + calcTempAns(Math.max(l, r));
        int relation = 1 + l + r;   //  say
        int ans = Math.max(tempAns, relation);
        res = Math.max(ans, res);
        return tempAns;
    }

    private int calcTempAns(int max) {
        return 0;
    }
}
