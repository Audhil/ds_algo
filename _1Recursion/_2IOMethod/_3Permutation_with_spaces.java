package ds_algo._1Recursion._2IOMethod;

//  https://youtu.be/1cspuQ6qHW0?list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY
public class _3Permutation_with_spaces {

    //  recursive tree @ https://photos.google.com/photo/AF1QipPnm0CB3xZaHNt2JeuO9cvkEsqBIbrHDQVSPJse

    /*
     * sample
     * i/p
     * abc
     *
     * o/p
     * a_b_c, a_bc, ab_c, abc -> where _ denotes empty space
     * */

    private static void solve(String input, String output) {
        //  bc
        if (input.length() == 0) {
            System.out.println("yup: BC: " + output);
            return;
        }

        String op1 = output;
        String op2 = output;

        //  include with space
        op1 += " " + input.charAt(0);

        //  include without space
        op2 += input.charAt(0);

        input = input.substring(1);

        solve(input, op1);
        solve(input, op2);
    }

    public static void main(String[] args) {
        String iP = "abc";
        String oP = "";
        oP += iP.charAt(0);
        iP = iP.substring(1);

        System.out.println("yup: op: " + oP + ",ip: " + iP);
        solve(iP, oP);
    }
}
