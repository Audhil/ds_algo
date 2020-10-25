package ds_algo._1Recursion._1IBH;

//  https://youtu.be/5P84A0YCo_Y?list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY
public class _8KthSymbolInGrammer_M {

    private int solve(int N, int K) {
        //  bc
        if (N == 1 && K == 1)
            return 0;

        double length = Math.pow(2, (N - 1));

        if (K > length)
            return Integer.MAX_VALUE;

        int mid = (int) length / 2;

        //  hypothesis
        if (K <= mid)
            return solve(N - 1, K);
        else {
            if (solve(N - 1, K - mid) == 1)
                return 0;
            else
                return 1;
        }
    }

    public static void main(String[] args) {
        _8KthSymbolInGrammer_M prob = new _8KthSymbolInGrammer_M();
        System.out.println(prob.solve(4, 5));
    }
}
