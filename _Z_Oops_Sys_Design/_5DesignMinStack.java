package _Z_Oops_Sys_Design;

import java.util.Stack;

//  similar : _10MinElementInStackWithOof1.java
//  https://youtu.be/qkLl7nAwDPo - NeetCode
//  https://youtu.be/ZvaRHYYI0-4?list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd - Aditya verma
public class _5DesignMinStack {

  private static class MinStack {

    private Long minElement = Long.MAX_VALUE;
    private Stack<Long> stack;

    public MinStack() {
      stack = new Stack<>();
    }

    public void push(int value) {
      Long val = Long.valueOf(value);
      if (stack.isEmpty()) {
        stack.push(val);
        minElement = val;
      } else {
        if (val < minElement) {
          stack.push((2 * val) - minElement);   //  storing corrupted value -> 2 * x - minElement
          minElement = val;
        } else {
          stack.push(val);
        }
      }
    }

    public void pop() {
      if (stack.isEmpty()) {
        return;
      }
      Long val = stack.pop();
      if (val < minElement) {  //  flag
        minElement =
            (2 * minElement) - val; //  retrieving from corrupted value -> 2 * minElement - y
      }
    }

    public int top() {
      if (stack.isEmpty()) {
        return -1;
      }
      if (stack.peek() < minElement) {
        return minElement.intValue();
      }
      return stack.peek().intValue();
    }

    public int getMin() {
      if (stack.isEmpty()) {
        return -1;
      }
      return minElement.intValue();
    }
  }

}
