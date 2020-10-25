package ds_algo._1Recursion._2IOMethod;

//  https://youtu.be/Yg5a2FxU4Fo?list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY
public class _1PrintSubsets_Powersets_Subsequences {

    private static void solve(String input, String output) {
        //  bc
        if (input.length() == 0) {
            System.out.println("sequence: " + output);
            return;
        }

        //  i/o
        String op1 = output;
        String op2 = output;

        op2 += input.charAt(0);
        input = input.substring(1);

        solve(input, op1);
        solve(input, op2);
    }

    public static void main(String[] args) {
        /*
        * o/p is
        *
        *   sequence:
            sequence: c
            sequence: b
            sequence: bc
            sequence: a
            sequence: ac
            sequence: ab
            sequence: abc
        * */
        String input = "abc";
        String output = "";
        solve(input, output);
    }
}
