package ds_algo._1Recursion._2IOMethod;

import java.util.ArrayList;
import java.util.List;

//  https://youtu.be/eyCj_u3PoJE?list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY
public class _6GenerateAllBalancedParenthesis {

    //  recursive tree @ https://photos.google.com/photo/AF1QipOl3fACCUB72VnYliJqga4lhCFE9eQgg3zHlAgm
    
    public static void main(String[] args) {
        List<String> balParenthesis = new ArrayList<>();
        int n = 3;
        getBalancedParenthesis(balParenthesis, n);
        System.out.println("yup: balParenthesis: " + balParenthesis);
    }

    private static void getBalancedParenthesis(List<String> list, int n) {
        int openCount = n;
        int closeCount = n;
        String output = "";
        solve(list, openCount, closeCount, output);
    }

    private static void solve(List<String> list, int openCount, int closeCount, String output) {
        //  bc
        if (openCount == 0 && closeCount == 0) {
            list.add(output);
            return;
        }

        if (openCount != 0) {
            String op1 = output;
            op1 += '(';
            solve(list, openCount - 1, closeCount, op1);
        }

        if (closeCount > openCount) {
            String op2 = output;
            op2 += ')';
            solve(list, openCount, closeCount - 1, op2);
        }
    }
}
