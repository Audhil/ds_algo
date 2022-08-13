package _10Blind75._6GreedyApproach._jumpGames;

//  https://www.youtube.com/watch?v=dJ7sWiOoK7g&ab_channel=NeetCode
//  https://leetcode.com/problems/jump-game-ii/submissions/
public class _02MinNoOfJumps_II_M {

  //  TC: O(n)
  public static int jump(int[] nums) {
    int l = 0, r = 0; //  'l' will hold the smallest position to reach after a jump, 'r' will hold the largest/farthest position to reach after a jump
    int res = 0, farthest;
    //  until right ptr reaches the last index of the array
    while (r < nums.length - 1) {
      farthest = 0;
      for (int i = l; i < r + 1; i++) {
        farthest = Math.max(farthest,
            i + nums[i]); //  i + nums[i] - will give max position we can reach
      }
      l = r + 1;
      r = farthest;
      res++;
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println("yup: min num of jumps to reach: " + jump(new int[]{2, 3, 1, 1, 4}));  //  2
    System.out.println("yup: min num of jumps to reach: " + jump(new int[]{2, 3, 0, 1, 4}));  //  2
  }
}
