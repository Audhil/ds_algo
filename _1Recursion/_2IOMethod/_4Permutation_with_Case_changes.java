package ds_algo._1Recursion._2IOMethod;

//  https://youtu.be/J2Er5XceU_I?list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY
public class _4Permutation_with_Case_changes {

    private static void solve(String input, String output) {
        //  bc
        if (input.length() == 0) {
            System.out.println("yup: output: " + output);
            return;
        }

        //  hypothesis
        String op1 = output;
        String op2 = output;

        op1 += input.charAt(0);
        op2 += Character.toUpperCase(input.charAt(0));

        input = input.substring(1);

        solve(input, op1);
        solve(input, op2);
    }

    public static void main(String[] args) {
        String input = "abc";
        String output = "";
        solve(input, output);
    }
}
