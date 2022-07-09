package basicToACE._1dp;

import java.util.Arrays;

//  https://youtu.be/5-lL9QuTpRA?list=PLQXZIFwMtjowKrFlzGcjMqchffJDRsz1E&t=4781
//  important point: https://youtu.be/5-lL9QuTpRA?list=PLQXZIFwMtjowKrFlzGcjMqchffJDRsz1E&t=5181
public class _5AliceAndBobStonesGame {

  //  returns x(stones chosen by me(Alice)) - y(stones chosen by opponent) > 0 -> means, I've won, else opponent;
  private static int stonePileGame(int startIndex, int endIndex, int[] stonePiles) {
    if (startIndex > endIndex) {
      return 0;
    }
    //  I'm choosing startIndex item, and allowing next opponent to play
    int op1 = stonePiles[startIndex] - stonePileGame(startIndex + 1, endIndex, stonePiles);
    //  I'm choosing endIndex item, and allowing next opponent to play
    int op2 = stonePiles[endIndex] - stonePileGame(startIndex, endIndex - 1, stonePiles);
    return Math.max(op1, op2);
  }

  private static int stonePileGameWithDp(int startIndex, int endIndex, int[] stonePiles,
      int[][] dp) {
    if (startIndex > endIndex) {
      return 0;
    }
    if (dp[startIndex][endIndex] != -1) {
      return dp[startIndex][endIndex];
    }
    //  I'm choosing startIndex item, and allowing next opponent to play
    int op1 =
        stonePiles[startIndex] - stonePileGameWithDp(startIndex + 1, endIndex, stonePiles, dp);
    //  I'm choosing endIndex item, and allowing next opponent to play
    int op2 = stonePiles[endIndex] - stonePileGameWithDp(startIndex, endIndex - 1, stonePiles, dp);
    return dp[startIndex][endIndex] = Math.max(op1, op2);
  }


  public static void main(String[] args) {
//    int[] stonePiles = {1, 100, 11, 5};
    int[] stonePiles = {7, 6, 4, 2, 1, 9};
    System.out.println(
        "yup: who won the game? : " + (stonePileGame(0, stonePiles.length - 1, stonePiles) > 0
            ? "Alice" : "Bob"));  //  yup: who won the game? : Alice

    //  with dp
    System.out.println("yup: with DP:");
    int[][] dp = new int[stonePiles.length + 1][stonePiles.length + 1];
    for (int[] ints : dp) {
      Arrays.fill(ints, -1);
    }
    System.out.println(
        "yup: with DP: who won the game? : " + (
            stonePileGameWithDp(0, stonePiles.length - 1, stonePiles, dp) > 0
                ? "Alice" : "Bob"));  //  yup: with DP: who won the game? : Alice
  }
}
