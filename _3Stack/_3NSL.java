package _3Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//  https://youtu.be/85LWui3FlVk?list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd
//  Nearest Smaller to Left
public class _3NSL {

    private int[] arr = {4, 5, 2, 10, 8};
    private List<Integer> res = new ArrayList<>();
    private Stack<Integer> stack = new Stack<>();

    private List<Integer> solve() {
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty())
                res.add(-1);
            else if (stack.peek() < arr[i])
                res.add(stack.peek());
            else if (stack.peek() > arr[i]) {
                while (!stack.isEmpty() && stack.peek() >= arr[i])
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
        _3NSL prob = new _3NSL();
        System.out.println("yup: NSL: " + prob.solve());
    }
}
