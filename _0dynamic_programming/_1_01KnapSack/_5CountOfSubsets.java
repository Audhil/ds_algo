package ds_algo._0dynamic_programming._1_01KnapSack;

//  https://youtu.be/F7wqWbqYn9g?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go
public class _5CountOfSubsets {

    private int[] arr = new int[]{2, 3, 5, 6, 8, 10};
    private int sum = 10;

    //  return count of subsets, who's sum is 10

    private int noOfSubsets() {
        int[][] t = new int[arr.length + 1][sum + 1];
        for (int i = 0; i < arr.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                //  initialization
                if (i == 0 && j == 0)
                    t[i][j] = 1;
                else if (i == 0)
                    t[i][j] = 0;    //  we cannot create any subset of sum - when arr size is 0 - left to right
                else if (j == 0)
                    t[i][j] = 1;    //  we can create 1 subset(empty subset/sum == 0) - top to down
                    //  choice diagram
                else if (arr[i - 1] <= j)    //  we can either choose or ignore the item to make the subset
                    t[i][j] = t[i - 1][j - arr[i - 1]]  //  on chosen
                            +
                            t[i - 1][j]; //  on not chosen
                    //  we won't choose this item anyway, go ahead further
                else if (arr[i - 1] > j)
                    t[i][j] = t[i - 1][j];
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
        _5CountOfSubsets prob = new _5CountOfSubsets();
        System.out.println("yup no Of subsets : " + prob.noOfSubsets());
    }
}
