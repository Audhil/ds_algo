package _10Blind75._0Arrays;

//  https://www.youtube.com/watch?v=UuiTKBwPgAo&ab_channel=NeetCode
//  https://leetcode.com/problems/container-with-most-water/
public class _0ContainerWithMostWaterM {

  //  brute force - O (n^2)
  public static int maxArea(int[] height) {
    if (height == null) {
      return 0;
    }
    int area = 0;
    for (int left = 0; left < height.length; left++) {
      for (int right = left + 1; right < height.length; right++) {
        area = Math.max(area, (Math.min(height[left], height[right])) * (right - left)); // l * b
      }
    }
    return area;
  }

  //  2 pointer approach - O (n)
  public static int maxAreaWith2Pointer(int[] height) {
    if (height == null) {
      return 0;
    }
    int area = 0;
    int left = 0, right = height.length - 1;
    while (left < right) {
      area = Math.max(area, (right - left) * (Math.min(height[left], height[right])));
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }
    return area;
  }


  public static void main(String[] args) {
    System.out.println(
        "yup: maxArea: " + maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); //  yup: maxArea: 49

    System.out.println(
        "yup: maxAreaWith2Pointer: " + maxAreaWith2Pointer(
            new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); //  yup: maxAreaWith2Pointer: 49
  }
}
