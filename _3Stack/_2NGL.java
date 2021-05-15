package _3Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//  https://youtu.be/T5s96ynzArg?list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd
public class _2NGL {
    //  reverse of _1NearestGreaterToRightAkANextLargestElement, iterate in left side

    //  if stack is empty, put -1.
    //  if stack.top() > arr[i], add stack.top()
    //  if stack.top() < arr[i], pop() and traverse until a. stack becomes empty, b. stack.top() is greater

    private int[] arr = {1, 3, 2, 4};
    private List<Integer> res = new ArrayList<>();
    private Stack<Integer> stack = new Stack<>();

    private List<Integer> solve() {
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty())
                res.add(-1);
            else if (stack.peek() > arr[i])
                res.add(stack.peek());
            else if (stack.peek() < arr[i]) {
                while (!stack.isEmpty() && stack.peek() <= arr[i])
                    stack.pop();

                if (stack.isEmpty())
                    res.add(-1);
                else
                    res.add(stack.peek());
            }
            stack.push(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        _2NGL prob = new _2NGL();
        System.out.println("yup: NGL: " + prob.solve());
    }
}
