package _0dynamic_programming._neetcode.__1dDP;

//  https://youtu.be/_i4Yxeh5ceQ?t=1344
public class _1ClimbingStairsMinCost_FINAL_WAY_E {

  //  TC: O (n) we achieved through dp, it not it'll be O (2^n) -> since height of the binary tree in n - https://youtu.be/_i4Yxeh5ceQ?t=1640

  //  src code: https://youtu.be/_i4Yxeh5ceQ?t=2062
  //  important point: top is referred as out of bound index of given arr. ie., n+1.. is considered as top
  public static int minCostClimbingStairs(Integer[] costArr) {
    //  doing the algo in-place
    int n = costArr.length; //  num of steps; index starting from 0,1,2,,,4
    //  since we are not changing last step's value - https://youtu.be/_i4Yxeh5ceQ?t=2109
    for (int i = n - 2; i >= 0; i--) {
      if (i + 2 >= n) {
        costArr[i] = Math.min(
            costArr[i] + costArr[i + 1],
            costArr[i] + 0);  //  since we reached top and it is out of bound hence adding 0
      } else {
        costArr[i] = Math.min(
            costArr[i] + costArr[i + 1],
            costArr[i] + costArr[i + 2]);  //  1 step or 2 step
      }
    }
    return Math.min(
        costArr[0],
        costArr[1]); //  we can start either from one jump to 1st or 2 jumps to 2nd step from ground
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: min cost of climibing stairs: " + minCostClimbingStairs(
            new Integer[]{10, 15, 20}));  //  yup: min cost of climibing stairs: 15
  }
}
