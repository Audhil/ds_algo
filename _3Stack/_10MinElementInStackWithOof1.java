package _3Stack;

import java.util.Stack;

//  https://youtu.be/ZvaRHYYI0-4?list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd
public class _10MinElementInStackWithOof1 {

    private final Stack<Integer> stack = new Stack<>();
    private int minElement = -1;

    private int getMin() {
        if (stack.isEmpty())
            return -1;
        return minElement;
    }

    //  https://youtu.be/ZvaRHYYI0-4?list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&t=673
    private void push(int element) {
        if (stack.isEmpty()) {
            stack.push(element);
            minElement = element;
        } else {
            if (element >= minElement) {
                stack.push(element);
            } else {
                stack.push(2 * element - minElement);   //  2 * x - minElement - keep in mind
                minElement = element;
            }
        }
    }

    private int pop() {
        if (stack.isEmpty())
            return -1;

        else {
            if (stack.peek() >= minElement)
                stack.pop();

            else if (stack.peek() < minElement) {
                minElement = 2 * minElement - stack.peek(); //  2 * minElement - y(which is top of stack) - keep in mind
                stack.pop();
            }
        }
        return top();
    }

    private int top() {
        if (stack.isEmpty())
            return -1;
        else {
            if (stack.peek() > minElement)
                return stack.peek();
            else if (stack.peek() < minElement)
                return minElement;
        }
        return -1;
    }
}
