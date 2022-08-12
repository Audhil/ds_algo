package _10Blind75._6GreedyApproach;

//  https://www.youtube.com/watch?v=Yan0cv2cLy8&ab_channel=NeetCode
public class _00JumpGameM {

  public static boolean canJump(int[] nums) {
    int goalPost = nums.length - 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      if (i + nums[i] >= goalPost) {
        goalPost = i;
      }
    }
    return goalPost == 0;
  }

  public static void main(String[] args) {
    System.out.println("yup: 2,3,1,1,4: canJump: " + canJump(new int[]{2, 3, 1, 1, 4}));  //  true
    System.out.println("yup: 3,2,1,0,4: canJump: " + canJump(new int[]{3, 2, 1, 0, 4}));  //  false
  }
}
