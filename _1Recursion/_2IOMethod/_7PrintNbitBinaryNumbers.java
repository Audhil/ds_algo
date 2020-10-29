package ds_algo._1Recursion._2IOMethod;

import java.util.ArrayList;
import java.util.List;

//  https://youtu.be/U81n0UYtk98?list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY
public class _7PrintNbitBinaryNumbers {

    //  recursion tree @ https://photos.google.com/photo/AF1QipPVQndUOIj-5flTBStlWKQHPqGcfZocdM87j8zp

    public static void main(String[] args) {
        List<String> nosList = new ArrayList<>();
        int n = 3;  //  N bits
        int onesCount = 1;
        int zeroesCount = 0;
        String output = "1";
        solve(n - 1,    //  since we already took '1' in output and onesCount = 1
                onesCount,
                zeroesCount,
                output,
                nosList);
        System.out.println("yup: nosList: " + nosList);
    }

    private static void solve(int n,
                              int onesCount,
                              int zeroesCount,
                              String output,
                              List<String> nosList) {
        //  bc
        if (n == 0) {
            System.out.println("yup: no is: " + output);
            nosList.add(output);
            return;
        }

        //  hypothesis
        //  choice of choosing '1'
        String op1 = output;
        op1 += '1';
        solve(n - 1, onesCount + 1, zeroesCount, op1, nosList);

        //  choice of choosing '0'
        if (onesCount > zeroesCount) {
            String op2 = output;
            op2 += '0';
            solve(n - 1, onesCount, zeroesCount + 1, op2, nosList);
        }
    }
}
