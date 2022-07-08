package basicToACE._2recursion_backtracking._0recursion;

//  https://www.youtube.com/watch?v=exyxf_ihbhI&list=PLQXZIFwMtjowKrFlzGcjMqchffJDRsz1E&index=7&ab_channel=CodeChef
public class _1Basic_Recursion_2 {

  //  explanation: https://youtu.be/exyxf_ihbhI?list=PLQXZIFwMtjowKrFlzGcjMqchffJDRsz1E&t=2088
  //  alice and bob playing
  //  number written on board -> n
  //  choose any number x, 0<x<n & n % x = 0
  //  write next number (n -x)
  //  tip whoever faces n == 1, will lose, since we cannot choose x below 1
  //  writing the following code as alice starts the game and final ans =0 (means bob won), 1(means alice won)
  private static int aliceBobPlaying(int n) {
    if (n == 1) {
      return 0; //  bob is winning
    }
    //  choosing numbers of choice
    for (int x = 1; x < n; x++) {
      if (n % x == 0) { //  given in question
        //  aliceBobPlaying(n - x), it means, alice is writing the number on board, bob comes to play
        if (aliceBobPlaying(n - x) == 0) {
          return 1; //  alice is winning
        }
      }
    }
    return 0; //  after trying all options, still alice is not winning, hence bob is the winner
  }

  public static void main(String[] args) {
    System.out.println("yup: who is winning: " + aliceBobPlaying(3)); //  yup: who is winning: 0 - (Alice)
  }
}
