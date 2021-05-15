package _3Stack;

import java.util.Stack;

//  https://youtu.be/asf9P2Rcopo?list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd
public class _9MinElementInStackWithExtraSpace {
    private int[] arr = {18, 19, 29, 15, 16};

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> sStack = new Stack<>();

    private void push(int item) {
        stack.push(item);
        if (sStack.isEmpty() || sStack.peek() >= item)
            sStack.push(item);
    }

    private int pop() {
        if (stack.isEmpty())
            return -1;
        int ans = stack.peek();
        if (sStack.peek() == ans)
            sStack.pop();
        return ans;
    }

    private int getMin() {
        if (sStack.isEmpty())
            return -1;
        return sStack.peek();
    }
}
