package _10Blind75._0Arrays;

//  https://leetcode.com/problems/trapping-rain-water/
public class _1TrappingRainWaterH {

  //  based on  https://www.youtube.com/watch?v=FbGG2qpNp4U&ab_channel=AdityaVerma
  public static int trap(int[] height) {
    if (height == null) {
      return 0;
    }

    int[] mxL = new int[height.length];
    mxL[0] = height[0];
    int[] mxR = new int[height.length];
    mxR[height.length - 1] = height[height.length - 1];

    for (int i = 1; i < height.length; i++) {
      mxL[i] = Math.max(mxL[i - 1], height[i]);
    }
    for (int i = height.length - 2; i >= 0; i--) {
      mxR[i] = Math.max(height[i], mxR[i + 1]);
    }

    //  water occupied above each building
    int[] waterArray = new int[height.length];
    for (int i = 0; i < height.length; i++) {
      waterArray[i] = Math.min(mxL[i], mxR[i]) - height[i];
    }
    int sum = 0;
    for (int i = 0; i < waterArray.length; i++) {
      sum += waterArray[i];
    }
    return sum;
  }

  public static int revision(int[] height) {
    int n = height.length;
    int[] mxL = new int[n];
    mxL[0] = height[0];
    int[] mxR = new int[n];
    mxR[n - 1] = height[n - 1];
    //  find mxL
    for (int i = 1; i < n; i++) {
      mxL[i] = Math.max(mxL[i - 1], height[i]);
    }
    //  find mxR
    for (int i = n - 2; i >= 0; i--) {
      mxR[i] = Math.max(mxR[i + 1], height[i]);
    }
    //  water trapped - reusing given array, don't bother
    for (int i = 0; i < n; i++) {
      height[i] = Math.min(mxL[i], mxR[i]) - height[i];
    }
    //  sum
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += height[i];
    }
    return sum;
  }

  public static void main(String[] args) {
    System.out.println("yup: water trap: " + trap(new int[]{3, 0, 0, 2, 0, 4}));
  }
}
