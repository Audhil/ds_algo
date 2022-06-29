package _10Blind25._6GreedyApproach._6TopQuestions;

import java.util.Arrays;

//  https://www.youtube.com/watch?v=lZJGbS12mWo&list=PLQXZIFwMtjozzDH4ZRtpIl0piBjsRF5Bf&index=8&t=1s&ab_channel=CodeChef
//  https://www.codechef.com/problems/MAXDIFF
public class _0MaxDiff {

  private static int maxDiffOf2Groups(int[] wts, int k) {
    if (wts == null) {
      return 0;
    }
    Arrays.sort(wts);
    int n = wts.length;
    int kid_Sum = 0, chef_Sum = 0;
    //  first group
    for (int i = 0; i < k; i++) {
      kid_Sum += wts[i];
    }
    //  second group - (n - k)
    for (int i = k; i < n; i++) {
      chef_Sum += wts[i];
    }
    return Math.abs(kid_Sum - chef_Sum);
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: maxDiffOf2Groups: " + maxDiffOf2Groups(new int[]{1, 1, 1, 1, 1, 1, 1, 1}, 3));

    System.out.println(
        "yup: maxDiffOf2Groups: " + maxDiffOf2Groups(new int[]{8, 4, 5, 2, 10}, 2));
  }
}
