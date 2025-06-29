package _FrazWorkSheet._1Greedy;

//  https://leetcode.com/problems/delete-and-earn/
public class _2DeleteAndEarnM {

  //  explanation: https://youtu.be/qVfjmkL1naw
  public static int deleteAndEarn(int[] nums) {
    int inc = 0;
    int exc = 0;
    int[] count = new int[10000 + 1]; //  given in prob
    for (Integer num : nums) {
      count[num]++;
    }
    for (int i = 0; i < count.length; i++) {
      int nInc = exc + (count[i] * i);
      int nExc = Math.max(inc, exc);
      inc = nInc;
      exc = nExc;
    }
    return Math.max(inc, exc);
  }

  public static void main(String[] args) {
    System.out.println("yup: deleteAndEarn: " + deleteAndEarn(new int[]{3, 2, 4, 2, 3, 3}));  //  yup: deleteAndEarn: 9
  }
}
