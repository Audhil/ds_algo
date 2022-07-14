package basicToACE._2recursion_backtracking._1backtracking;

import java.util.Stack;

public class _3DeleteMiddleElementOfStack {

  private static void solve(Stack<Integer> st, int k) {
    if (k == 1) {
      st.pop();
      return;
    }
    int temp = st.pop();
    solve(st, k - 1);
    st.push(temp);
  }

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < 6; i++) {
      stack.push(i);
    }
    int mid = stack.size() / 2 + 1;
    System.out.println("Stack before deletion: " + stack);
    solve(stack, mid);
    System.out.println("Stack after deletion: " + stack);
  }
}
