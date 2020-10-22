package ds_algo._1Recursion;

//  https://youtu.be/Xu5RqPdABRE?list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY
public class _1Print1toN_InductionBased {

    /*
     * 1. easy category
     *   IBH - induction - base condn - hypothesis
     *
     * 2. medium
     *   draw recursion tree - i/p-o/p method
     *
     * 3. hard
     *   choice diagram - remember DP probs
     * */

    private void printSeries(int n) {
        //  base condn
        if (n == 1) {
            System.out.println(n);
            return;
        }

        //  hypothesis
        printSeries(n - 1);

        //  induction
        System.out.println(n);
    }

    public static void main(String[] args) {
        _1Print1toN_InductionBased prob = new _1Print1toN_InductionBased();
        System.out.println("yup: printing 1 to N");
        prob.printSeries(8);
    }
}
