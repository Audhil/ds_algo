package ds_algo._0dynamic_programming._4MatrixChainMultiplication;

import java.util.HashMap;

//  https://youtu.be/bzXM1Zond9U?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go
public class _7EvaluateExpressionToTrue_Memoization {

    //    private String expr = "T|F&T^F";  //  5 ways
    private String expr = "T^F&T";  //  2 ways - ((T^F)&T) & (T^(F&T))
    private HashMap<String, Integer> mapIs = new HashMap<>();   //  using map, instead of 3D array for convenience

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

        String key = i + "_" + j + "_" + isTrue;
        if (mapIs.get(key) != null)
            return mapIs.get(key);

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
        mapIs.put(key, ans);
        return ans;
    }

    public static void main(String[] args) {
        _7EvaluateExpressionToTrue_Memoization prob = new _7EvaluateExpressionToTrue_Memoization();
        prob.mapIs.clear();
        System.out.println("yup: with memoization no of ways to parenthesis, to make statement as true: " + prob.solve(
                prob.expr,
                0,
                prob.expr.length() - 1,
                true
        ));
    }
}
