package ds_algo._1Recursion._1IBH;

import java.util.Stack;

//  https://youtu.be/oCcUNRMl7dA?list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY
public class _6DeleteMiddleElementOfStack {

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
//        stack.push(5);
//        stack.push(1);
//        stack.push(0);
//        stack.push(2);
    for (int i = 0; i < 6; i++) {
      stack.push(i);
    }

    if (stack.isEmpty()) {
      System.out.println("yup: stack is Empty!");
      return;
    }

    System.out.println("yup stack before deleting: " + stack + "; stack.size: " + stack.size());

    int midItemPos = stack.size() / 2 + 1;
    System.out.println("yup: midItemPos: " + midItemPos);
    solve(stack, midItemPos);

    System.out.println("yup stack after deleting: " + stack + "; stack.size: " + stack.size());
  }

  private static void solve(Stack<Integer> stack, int k) {
    //  bc
    if (k == 1) {
      stack.pop();
      return;
    }

    int temp = stack.pop();
    //  hypothesis
    solve(stack, k - 1);

    //  induction
    stack.push(temp);
  }
}
