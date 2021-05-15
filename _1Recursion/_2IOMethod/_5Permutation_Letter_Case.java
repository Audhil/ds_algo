package ds_algo._1Recursion._2IOMethod;

import java.util.ArrayList;
import java.util.List;

//  https://youtu.be/4eOPYDOiwFo?list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY
//  letters(case insensitive) + digits
public class _5Permutation_Letter_Case {

    //  recursive tree @ https://photos.google.com/photo/AF1QipO9HDiZVBfO8UDNjVzZqn3VLjnpVOVqkxDoJ8Cw

    private static void solve(String input, String output, List<String> list) {
        //  bc
        if (input.length() == 0) {
            System.out.println("yup: output: " + output);
            list.add(output);
            return;
        }

        //  hypothesis
        if (Character.isAlphabetic(input.charAt(0))) {
            String op1 = output;
            String op2 = output;

            op1 += Character.toLowerCase(input.charAt(0));
            op2 += Character.toUpperCase(input.charAt(0));

            input = input.substring(1);

            solve(input, op1, list);
            solve(input, op2, list);
        } else if (Character.isDigit(input.charAt(0))) {
            String op1 = output;

            op1 += input.charAt(0);

            input = input.substring(1);

            solve(input, op1, list);
        }
    }

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        String input = "a1B2";
        String output = "";
        System.out.println("yup: before: " + stringList);
        solve(input, output, stringList);
        System.out.println("yup: after: " + stringList);
    }
}
