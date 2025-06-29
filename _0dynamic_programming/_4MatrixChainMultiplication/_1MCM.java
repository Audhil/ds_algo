package ds_algo._0dynamic_programming._4MatrixChainMultiplication;

//  https://www.youtube.com/watch?v=kMK148J9qEE&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=34&ab_channel=AdityaVerma
public class _1MCM {

    /*
     * points to note
     * 1. take i from index 1 to support -> a(i) = a(i-1) * a(i), and take j at last index
     * 2. take k from,
     *   a)  from k=i to k=j-1, break func(i to k) & func(k+1 to j)
     *   b)  from k=i+1 to k=j, break func(i to k-1) & func(k to j)
     * */

    //  find min cost for following matrix multiplication
    private int[] arr = {40, 20, 30, 10, 30};
    //  we have arr.length() - 1 matrices

    /*
     * steps to follow
     * 1. find i, j
     * 2. put base condition
     * 3. find k
     * 4. find tempAns
     * 5. return final answer
     * */

    private int solve(int[] arr, int i, int j) {
        //  base condition
        if (i >= j)
            return 0;

        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int tempAns = solve(arr, i, k)  //  cost of matrix (A * B)
                    + solve(arr, k + 1, j)  //  cost of matrix (B * C)
                    + arr[i - 1] * arr[k] * arr[j]; //  cost of matrix (A * B) * (B * C)
            if (tempAns < min)
                min = tempAns;
        }
        return min;
    }

    public static void main(String[] args) {
        _1MCM prob = new _1MCM();
        int i = 1;  //  to avoid arr[i-1] = arr[0-1] = arr[-1] which is invalid index
        int j = prob.arr.length - 1;
        System.out.println("yup: min cost of Matrix multiplication is : " + prob.solve(prob.arr, i, j));
    }
}
