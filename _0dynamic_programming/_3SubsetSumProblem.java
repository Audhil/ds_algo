package ds_algo._0dynamic_programming;

//  https://www.youtube.com/watch?v=_gPcYovP7wc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=7&ab_channel=AdityaVerma
public class _3SubsetSumProblem {

    private int[] arr = new int[]{2, 3, 7, 8, 10};
    private int sum = 11;
    //  given array, on adding any `subset` will give `sum` ?

    //  check the video this is similar to knapsack problem

    private boolean isSubSetAvailable() {
        boolean[][] t = new boolean[arr.length + 1][sum + 1];  //  create a 2d array - for top down approach
        for (int i = 0; i < arr.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                //  initialization - refer video for this part
                if (i == 0 && j == 0)
                    t[i][j] = true;
                else if (i == 0)
                    t[i][j] = false;
                else if (j == 0)
                    t[i][j] = true;
                    //  choice diagram
                else if (arr[i - 1] <= j)
                    t[i][j] = t[i - 1][j - arr[i - 1]]  //  is item chosen
                            ||  //  we need to 'OR' instead of Math.max() for boolean values
                            t[i - 1][j];    //  is item not chosen
                else if (arr[i - 1] > j)
                    t[i][j] = t[i - 1][j];  //  surely, item not chosen
            }
        }

        for (int i = 0; i < arr.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                System.out.print(" " + t[i][j] + " ");
            }
            System.out.println();
        }

        return t[arr.length][sum];
    }

    public static void main(String[] args) {
        _3SubsetSumProblem problem = new _3SubsetSumProblem();
        System.out.println("yup subset is present or not! : " + problem.isSubSetAvailable());
    }
}
