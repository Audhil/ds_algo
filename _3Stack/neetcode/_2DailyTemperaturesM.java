package _3Stack.neetcode;

import java.util.Arrays;
import java.util.Stack;

//  https://leetcode.com/problems/daily-temperatures/description/
public class _2DailyTemperaturesM {

  //  TC: O (n); SC: O (n)
  public static int[] dailyTemperatures(int[] temperatures) {
    int[] ans = new int[temperatures.length];
    Stack<Integer> stack = new Stack<>();
    for (int currDay = 0; currDay < temperatures.length; currDay++) {
      while (!stack.isEmpty() && temperatures[currDay] > temperatures[stack.peek()]) {
        int prevDay = stack.pop();
        ans[prevDay] = currDay - prevDay;
      }
      stack.push(currDay);
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(dailyTemperatures(
            new int[]{73, 74, 75, 71, 69, 72, 76, 73}))); //  [1, 1, 4, 2, 1, 1, 0, 0]
    System.out.println(
        Arrays.toString(dailyTemperatures(new int[]{30, 40, 50, 60})));  //  [1, 1, 1, 0]
    System.out.println(Arrays.toString(dailyTemperatures(new int[]{30, 60, 90})));  //  [1, 1, 0]
  }
}
