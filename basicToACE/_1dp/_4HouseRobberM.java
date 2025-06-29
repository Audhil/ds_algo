package basicToACE._1dp;

import java.util.Arrays;

//  https://youtu.be/5-lL9QuTpRA?list=PLQXZIFwMtjowKrFlzGcjMqchffJDRsz1E&t=789
public class _4HouseRobberM {

  //  TC: O (2^n) - exponential - since we are doing recursion calls to i+1 and i+2;
  private static int maxRobbedAmount(int currHouse, int[] housesWithMoney) {
    if (currHouse >= housesWithMoney.length) {
      return 0;
    }
    //  I'll rob
    int chori = housesWithMoney[currHouse] + maxRobbedAmount(currHouse + 2, housesWithMoney);
    //  I'll not rob
    int notChori = maxRobbedAmount(currHouse + 1,
        housesWithMoney); //  0 + maxRobbedAmount(currHouse + 1, housesWithMoney);
    return Math.max(chori, notChori);
  }

  //  with dp
  //  TC: O (n), SC: O (n) - - TOP DOWN approach
  private static int maxRobbedAmountWithDp(int currHouse, int[] housesWithMoney, int[] dp) {
    if (currHouse >= housesWithMoney.length) {
      return 0;
    }
    if (dp[currHouse] != -1) {
      return dp[currHouse];
    }
    //  I'll rob
    int chori =
        housesWithMoney[currHouse] + maxRobbedAmountWithDp(currHouse + 2, housesWithMoney, dp);
    //  I'll not rob
    int notChori = maxRobbedAmountWithDp(currHouse + 1,
        housesWithMoney, dp);
    return dp[currHouse] = Math.max(chori, notChori);
  }

  //  iterative approach - BOTTOM UP approach
  //  https://youtu.be/5-lL9QuTpRA?list=PLQXZIFwMtjowKrFlzGcjMqchffJDRsz1E&t=3432
  private static int maxRobbedAmtWithIterativeApproach(int[] housesWithMoney) {
    int n = housesWithMoney.length;
    int[] dp = new int[n + 2];
    //  base condition  - refer if (currHouse >= housesWithMoney.length){}
    dp[n] = 0;
    dp[n + 1] = 0;
    for (int i = n - 1; i >= 0; i--) {
      dp[i] = Math.max(housesWithMoney[i] + dp[i + 2],
          dp[i + 1] //  0 + dp[i + 1]
      );
    }
    return dp[0];
  }

  public static void main(String[] args) {
    int[] houses = {11, 12, 3, 5};
    System.out.println(
        "yup: max robbed amount: " + maxRobbedAmount(0, houses));  //  yup: max robbed amount: 17
//    int[] houses = {11, 12, 3, 5, 13};
//    System.out.println("yup: max robbed amount: " + maxRobbedAmount(0, houses));  //  yup: max robbed amount: 27
    int[] dp = new int[houses.length + 1];
    Arrays.fill(dp, -1);
    System.out.println(
        "yup: max robbed with dp: amount: " + maxRobbedAmountWithDp(0, houses,
            dp));  //  yup: max robbed with dp: amount: 17
    System.out.println(
        "yup: maxRobbedAmtWithIterativeApproach: " + maxRobbedAmtWithIterativeApproach(
            houses));  //  yup: maxRobbedAmtWithIterativeApproach: 17
  }
}
