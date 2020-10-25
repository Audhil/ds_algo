package ds_algo._1Recursion._2IOMethod;

import java.util.HashMap;

//  https://youtu.be/lfFqW1DTsqM?list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY
public class _2PrintUniqueSubsets {

    private static HashMap<String, String> myMap = new HashMap<>();

    private static void solve(String input, String output) {
        //  bc
        if (input.length() == 0) {
//            System.out.println("sequence: " + output);
            if (!myMap.containsKey(output)) {
                myMap.put(output, output);
            }
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
        * usual o/p is
        *
        sequence:
        sequence: b
        sequence: a
        sequence: ab
        sequence: a
        sequence: ab
        sequence: aa
        sequence: aab
        * */

        String input = "aab";
        String output = "";
        solve(input, output);

        System.out.println("yup: unique subsets: " + myMap.keySet());   // required o/p is yup: unique subsets: [, aa, a, ab, b, aab]
    }
}
