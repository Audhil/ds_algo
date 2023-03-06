package _3Stack.neetcode;

import java.util.Stack;

//  https://youtu.be/iu0082c4HDE
public class _1ReversePolishNotationM {

  public static int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    for (String token : tokens) {
      if (token.equals("+")) {
        stack.push(stack.pop() + stack.pop());
      } else if (token.equals("-")) {
        //  order matters
        int b = stack.pop();
        int a = stack.pop();
        stack.push(a - b);
      } else if (token.equals("*")) {
        stack.push(stack.pop() * stack.pop());
      } else if (token.equals("/")) {
        int b = stack.pop();
        int a = stack.pop();
        stack.push(a / b);
      }
      //  it is number
      else {
        stack.push(Integer.valueOf(token));
      }
    }
    return stack.peek();
  }

  public static void main(String[] args) {
    System.out.println("yup: evalRPN: " + evalRPN(new String[]{"2", "1", "+", "3", "*"}));  //  yup: evalRPN: 9
    System.out.println("yup: evalRPN: " + evalRPN(new String[]{"4", "13", "5", "/", "+"})); //  yup: evalRPN: 6
    System.out.println("yup: evalRPN: " + evalRPN(
        new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));  //  yup: evalRPN: 22
  }
}
