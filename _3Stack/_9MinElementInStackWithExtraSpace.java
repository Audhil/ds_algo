package _3Stack;

import java.util.Stack;

//  https://youtu.be/asf9P2Rcopo?list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd
//  exact same explanation here: https://youtu.be/qkLl7nAwDPo - NeetCode
public class _9MinElementInStackWithExtraSpace {
    private int[] arr = {18, 19, 29, 15, 16};

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minValueStack = new Stack<>();

    private void push(int item) {
        stack.push(item);
        if (minValueStack.isEmpty() || minValueStack.peek() >= item)
            minValueStack.push(item);
    }

    private int pop() {
        if (stack.isEmpty())
            return -1;
        int ans = stack.pop();
        if (minValueStack.peek() == ans)
            minValueStack.pop();
        return ans;
    }

    private int getMin() {
        if (minValueStack.isEmpty())
            return -1;
        return minValueStack.peek();
    }
}
