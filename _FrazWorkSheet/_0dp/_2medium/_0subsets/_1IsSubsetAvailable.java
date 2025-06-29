package _FrazWorkSheet._0dp._2medium._0subsets;

//  refer_3SubsetSumProblem.java problem
//  refer this too if needed: https://www.youtube.com/watch?v=_gPcYovP7wc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=9&ab_channel=AdityaVerma
public class _1IsSubsetAvailable {

  private static boolean isSubSetAvailable(int[] arr, int sum) {
    boolean[][] dp = new boolean[arr.length + 1][sum + 1];
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[i].length; j++) {
        //  base condition
        if (i == 0 && j == 0) {
          dp[i][j] = true;
        } else if (i == 0) {
          dp[i][j] = false;
        } else if (j == 0) {
          dp[i][j] = true;
        }
        //  choice diagram
        else if (arr[i - 1] <= j) {
          dp[i][j] = dp[i - 1][j - arr[i - 1]]  //  choosing the item
              || dp[i - 1][j];  //  not choosing the item
        } else {
          dp[i][j] = dp[i - 1][j];  //  we can't choose the item
        }
      }
    }
    return dp[arr.length][sum];
  }

  public static void main(String[] args) {
    int[] arr = new int[]{2, 3, 7, 10};
    int sum = 11;
    //  yup subset of sum 11, is available?: false
    System.out.println(
        "yup subset of sum " + sum + ", is available?: " + isSubSetAvailable(arr, sum));
  }
}
