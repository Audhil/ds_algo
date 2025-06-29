package _FrazWorkSheet._1Greedy;

public class _1MaxSumNonAdjacentElements {

  //  watch video for full explantion with tree structure
  //  https://www.youtube.com/watch?v=VT4bZV24QNo&ab_channel=Pepcoding
  private static int maxSumNonAdjacentElements(int[] nums) {
    int inc = nums[0];  //  include
    int exc = 0;  //  exclude
    for (int i = 1; i < nums.length; i++) {
      int nInc = exc + nums[i]; //  new include
      int nExc = Math.max(inc, exc);//  new exclude
      inc = nInc;
      exc = nExc;
    }
    return Math.max(inc, exc);
  }

  public static void main(String[] args) {
    System.out.println("yup: maxSumNonAdjacentElements: " + maxSumNonAdjacentElements(
        new int[]{5, 10, 10, 100, 5, 6}));  //  yup: maxSumNonAdjacentElements: 116
  }
}
