package _3Stack.neetcode;

import java.util.Stack;
import javafx.util.Pair;

//  https://leetcode.com/problems/largest-rectangle-in-histogram/description/
//  https://youtu.be/zx5Sw9130L0 - NeetCode
public class _4LargestAreaOfRectange_Histogram_H {

  public static int largestRectangleArea(int[] heights) {
    Stack<Pair<Integer, Integer>> stack = new Stack<>();
    int n = heights.length;
    int maxArea = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      int currHeight = heights[i];
      int startIndex = i;
      while (!stack.isEmpty() && stack.peek().getValue() > currHeight) {
        Pair<Integer, Integer> pair = stack.pop();
        int index = pair.getKey();
        int height = pair.getValue();
        maxArea = Math.max(maxArea, height * (i - index));
        startIndex = index;
      }
      stack.push(new Pair<>(startIndex, currHeight));
    }
    //  check stack for heights, that's available till the end of histogram
    while (!stack.isEmpty()) {
      Pair<Integer, Integer> pair = stack.pop();
      maxArea = Math.max(maxArea, pair.getValue() * (n - pair.getKey()));
    }
    return maxArea;
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: largest area of rectange: " + largestRectangleArea(
            new int[]{2, 1, 5, 6, 2, 3})); //  yup: largest area of rectange: 10
    System.out.println(
        "yup: largest area of rectange: " + largestRectangleArea(
            new int[]{6, 2, 5, 4, 5, 1, 6}));  //  yup: largest area of rectange: 12
  }
}
