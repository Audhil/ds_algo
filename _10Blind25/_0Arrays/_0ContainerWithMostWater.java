package _10Blind25._0Arrays;

//  https://www.youtube.com/watch?v=UuiTKBwPgAo&ab_channel=NeetCode
//  https://leetcode.com/problems/container-with-most-water/
public class _0ContainerWithMostWater {

  //  brute force - O (n^2)
  public static int maxArea(int[] height) {
    if (height == null) {
      return 0;
    }
    int area = 0;
    for (int left = 0; left < height.length; left++) {
      for (int right = left + 1; right < height.length; right++) {
        area = Math.max(area, (right - left) * (Math.min(height[left], height[right])));
      }
    }
    return area;
  }

  public static void main(String[] args) {
    System.out.println("yup: maxArea: " + maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
  }
}
