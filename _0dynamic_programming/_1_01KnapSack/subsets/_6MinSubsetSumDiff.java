package _0dynamic_programming._1_01KnapSack.subsets;

import java.util.Arrays;

//  https://www.youtube.com/watch?v=-GtpxG6l_Mc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=10&ab_channel=AdityaVerma
public class _6MinSubsetSumDiff {

    /*
    * Sum of subset differences
        Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.
        If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.

        Example:
        Input:  arr[] = {1, 6, 11, 5}
        Output: 1
        Explanation:
        Subset1 = {1, 5, 6}, sum of Subset1 = 12
        Subset2 = {11}, sum of Subset2 = 11
        *
        * s1 - s2 = min
        * or
        * s2 - s1 = min
        * (range - s1) - s1 => since s1 + s2 = range
    * */

    private int[] arr = new int[]{1, 6, 11, 5};

    private boolean[][] subSet(int range) {
        boolean[][] t = new boolean[arr.length + 1][range + 1];
        for (int i = 0; i < arr.length + 1; i++) {
            for (int j = 0; j < range + 1; j++) {
                //  initialization
                if (i == 0 && j == 0)
                    t[i][j] = true;
                else if (i == 0)
                    t[i][j] = false;
                else if (j == 0)
                    t[i][j] = true;

                    //  choice diagram
                else if (arr[i - 1] <= j)
                    t[i][j] = t[i - 1][j - arr[i - 1]]  //  on choosing the item
                            ||
                            t[i - 1][j];    //  on not choosing the item

                    //  we won't choose this item any way
                else if (arr[i - 1] > j)
                    t[i][j] = t[i - 1][j];
            }
        }
        return t;
    }

    private int minSubsetSum() {
        int range = 0;
        for (int i = 0; i < arr.length; i++)
            range += arr[i];
        boolean[][] subSetMatrix = subSet(range);

//        for (int i = 0; i < arr.length + 1; i++) {
//            for (int j = 0; j < range + 1; j++) {
//                System.out.print(" " + subSetMatrix[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println("yup range: " + range);

        //  considering s1 as non-negative, to support (range - 2S1) -> refer video
        int[] subSums = new int[range / 2 + 1];   //  we'll iterate only range/2, add 1 more integer to include the value
        Arrays.fill(subSums, -1);
        //  https://youtu.be/-GtpxG6l_Mc?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&t=2036
        for (int i = 0; i < subSums.length; i++) {
            if (subSetMatrix[arr.length][i])   //  considering last row(i.e., taking all items in array) of 2d-array,
                subSums[i] = i;
        }

        System.out.println("yup: subSums: " + Arrays.toString(subSums));

        int mn = Integer.MAX_VALUE;
        for (int i = 0; i < subSums.length; i++) {
            if (subSums[i] < 0)
                continue;
            mn = Math.min(mn, range - (2 * subSums[i]));
        }
        //  sum up explanation: https://youtu.be/-GtpxG6l_Mc?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&t=2449
        return mn;
    }

    public static void main(String[] args) {
        _6MinSubsetSumDiff prob = new _6MinSubsetSumDiff();
        System.out.println("yup minSubsetSum: " + prob.minSubsetSum());
    }
}
