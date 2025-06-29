package _3Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//  https://youtu.be/NXOOYYwpbg4?list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd
public class _1NearestGreaterToRightAkANextLargestElementAka_NGR {
    //  if stack is empty, put -1.
    //  if stack.top() > arr[i], add stack.top()
    //  if stack.top() < arr[i], pop() and traverse until a. stack becomes empty, b. stack.top() is greater

    //  complexity O(n)


    private int[] arr = {1, 3, 2, 4};
    private List<Integer> res = new ArrayList<>();
    private Stack<Integer> stack = new Stack<>();

    private List<Integer> solve() {
        for (int i = arr.length - 1; i >= 0; i--) {
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
        //  since results are stored in reversed order
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        _1NearestGreaterToRightAkANextLargestElementAka_NGR prob = new _1NearestGreaterToRightAkANextLargestElementAka_NGR();
        System.out.println("yup: the NGR or NLE: " + prob.solve());
    }
}
