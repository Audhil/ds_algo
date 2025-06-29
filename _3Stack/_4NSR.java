package _3Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//  https://youtu.be/nc1AYFyvOR4?list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd
//  Nearest Smaller to Right
public class _4NSR {

    private int[] arr = {4, 5, 2, 10, 8};
    private List<Integer> res = new ArrayList<>();
    private Stack<Integer> stack = new Stack<>();

    private List<Integer> solve() {
        for (int i = arr.length - 1; i >= 0; i--) {
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
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        _4NSR prob = new _4NSR();
        System.out.println("yup: NSR: " + prob.solve());
    }
}
