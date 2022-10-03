package _00Arrays;

//  https://youtu.be/TFdclijv4Mg
public class _13MergeArrayElementsWithMinCostM {

  private static int revision(int[] arr) {
    int n = arr.length;
    //  1. prefix arr
    int[] prefixArr = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      prefixArr[i] = prefixArr[i - 1] + arr[i - 1];
    }
    //  2. fill dp arr in diagonally
    int[][] dp = new int[n][n];
    for (int diff = 1; diff < n; diff++) {
      int i = 0;
      int j = i + diff;
      for (; j < n; j++, i++) {
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
          dp[i][j] = Math.min(dp[i][j],
              prefixArr[j + 1] + dp[i][k] + dp[k + 1][j]);
        }
      }
    }
    return dp[0][n - 1];
  }

  //  TC: O (n^3)
  private static int minCostToMergeElements(int[] arr) {
    int n = arr.length;
    //  1. make prefix sum arr - for ease of querying sum
    int[] prefixSumArr = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      prefixSumArr[i] = prefixSumArr[i - 1] + arr[i - 1];
    }
    //  2. make and fill dp array diagonally
    int[][] dp = new int[n][n];
    for (int diff = 1; diff < n; diff++) {
      int i = 0;
      int j = i + diff;
      for (; j < n; j++, i++) {
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
          System.out.println(
              "yup: dp(i:" + i + ", j:" + j + "), dp(i:" + i + ", k:" + k + "), dp(k++:" + (k + 1)
                  + ", j: " + j + ")");
          dp[i][j] = Math.min(dp[i][j],
              (prefixSumArr[j + 1]) + dp[i][k] + dp[k
                  + 1][j]); //  prefixSumArr[j + 1] - prefixSumArr[i] -> also works
        }
        System.out.println();
      }
    }
    return dp[0][n - 1];
  }

  /*
  * yup: dp(i:0, j:1), dp(i:0, k:0), dp(k++:1, j: 1)

    yup: dp(i:1, j:2), dp(i:1, k:1), dp(k++:2, j: 2)

    yup: dp(i:2, j:3), dp(i:2, k:2), dp(k++:3, j: 3)

    yup: dp(i:0, j:2), dp(i:0, k:0), dp(k++:1, j: 2)
    yup: dp(i:0, j:2), dp(i:0, k:1), dp(k++:2, j: 2)

    yup: dp(i:1, j:3), dp(i:1, k:1), dp(k++:2, j: 3)
    yup: dp(i:1, j:3), dp(i:1, k:2), dp(k++:3, j: 3)

    yup: dp(i:0, j:3), dp(i:0, k:0), dp(k++:1, j: 3)
    yup: dp(i:0, j:3), dp(i:0, k:1), dp(k++:2, j: 3)
    yup: dp(i:0, j:3), dp(i:0, k:2), dp(k++:3, j: 3)
    * */
  public static void main(String[] args) {
    System.out.println(
        "yup: min cost to merge arrays: " + minCostToMergeElements(
            new int[]{1, 2, 3, 4})); //  yup: min cost to merge arrays: 19

    System.out.println(
        "yup: min cost to merge arrays: " + revision(
            new int[]{1, 2, 3, 4})); //  yup: min cost to merge arrays: 19
  }
}
