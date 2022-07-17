package _0dynamic_programming._1_01KnapSack.subsets;

//  https://youtu.be/ot_XBHyqpFc?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go
public class _7CountOfSubsetsSumWithGivenDiff {
    /*
     *
     * sum(s1) - sum(s2) = diff
     * sum(s1) + sum(s2) = sum(arr)
     *
     * 2 sum(s1) = diff + sum(arr) -> reducing above 2 equations
     * ie., sum(s1) = [diff + sum(arr)]/2;
     *
     * ie., find sum(s1) and find no of subsets whose sum is s1
     * */

    //  find noOfSubsets whose(sum of) diff is 1
    private int[] arr = {1, 1, 2, 3};
    private int diff = 1;

    private int noOfSubsetsSumWithDiff() {
        int sumOfArray = 0;
        for (int i = 0; i < arr.length; i++)
            sumOfArray += arr[i];
        int sum1 = (diff + sumOfArray) / 2;
        return noOfSubsetsWithSum(arr, sum1);   //  refer _5CountOfSubsets.java
    }

    //  refer _5CountOfSubsets.java = problem reduced to noOfSubsets whose tot sum is given sum
    private int noOfSubsetsWithSum(int[] arr, int sum) {
        int[][] t = new int[arr.length + 1][sum + 1];
        for (int i = 0; i < arr.length + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                //  initialization
                if (i == 0 && j == 0)
                    t[i][j] = 1;
                else if (i == 0)
                    t[i][j] = 0;
                else if (j == 0)
                    t[i][j] = 1;

                    //  choice diagram
                else if (arr[i - 1] <= j)   //  we can choose or not choose
                    t[i][j] = t[i - 1][j - arr[i - 1]]  //  on choosing
                            +
                            t[i - 1][j];    //  on not choosing
                else if (arr[i - 1] > j)   //  we won't choose this
                    t[i][j] = t[i - 1][j];
            }
        }
        return t[arr.length][sum];
    }

    public static void main(String[] args) {
        _7CountOfSubsetsSumWithGivenDiff prob = new _7CountOfSubsetsSumWithGivenDiff();
        System.out.println("yup: noOfSubsetsDiff: " + prob.noOfSubsetsSumWithDiff());
    }
}
