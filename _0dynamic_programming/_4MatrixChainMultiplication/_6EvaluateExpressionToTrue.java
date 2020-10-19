package ds_algo._0dynamic_programming._4MatrixChainMultiplication;

//  https://youtu.be/pGVguAcWX4g?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go
public class _6EvaluateExpressionToTrue {

    //  add brackets to make this expression "true"
    //  https://www.geeksforgeeks.org/boolean-parenthesization-problem-dp-37/

    /*
    * Evaluate Expression To True-Boolean Parenthesization Recursion
        Given a boolean expression with following symbols.
        Symbols
            'T' --- true
            'F' --- false
        And following operators filled between symbols
        Operators
            &   ---boolean AND
            |   --- boolean OR
            ^   --- boolean XOR
        Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.
        Example:
        Input: symbol[]    = {T, F, T}
               operator[]  = {^, &}
        Output: 2
        The given expression is "T ^ F & T", it evaluates true
        in two ways "((T ^ F) & T)" and "(T ^ (F & T))"
    * */

    //    private String expr = "T|F&T^F";  //  5 ways
    private String expr = "T^F&T";  //  2 ways - ((T^F)&T) & (T^(F&T))

    private int solve(String expr, int i, int j, boolean isTrue) {
        //  base condition
        if (i > j)
            return 0;
        if (i == j) {
            if (isTrue) {
                if (expr.charAt(i) == 'T')
                    return 1;
                else
                    return 0;
            } else {
                if (expr.charAt(i) == 'F')
                    return 1;
                else
                    return 0;
            }
        }

        int ans = 0;
        //  loop
        for (int k = i + 1; k <= j - 1; k += 2) {    //  k will start from symbol(not from T or F), and reach upto last
            //  temp ans
            int lF = solve(expr, i, k - 1, false);
            int lT = solve(expr, i, k - 1, true);
            int rF = solve(expr, k + 1, j, false);
            int rT = solve(expr, k + 1, j, true);

            //  final answer
            if (expr.charAt(k) == '&') {
                if (isTrue)
                    ans += lT * rT;
                else
                    ans += lF * rF + lF * rT + lT * rF;
            } else if (expr.charAt(k) == '|') {
                if (isTrue)
                    ans += lT * rT + lF * rT + rF * lT;
                else
                    ans += lF * rF;
            } else if (expr.charAt(k) == '^') {
                if (isTrue)
                    ans += lF * rT + lT * rF;
                else
                    ans += lF * rF + lT * rT;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _6EvaluateExpressionToTrue prob = new _6EvaluateExpressionToTrue();
        System.out.println("yup: no of ways to parenthesis, to make statement as true: " + prob.solve(
                prob.expr,
                0,
                prob.expr.length() - 1,
                true
        ));
    }
}
