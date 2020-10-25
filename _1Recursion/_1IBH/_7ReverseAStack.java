package ds_algo._1Recursion._1IBH;

import java.util.Stack;

//  https://youtu.be/8YXQ68oHjAs?list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY
public class _7ReverseAStack {

    private static void reverseStack(Stack<Integer> stack) {
        //  bc
        if (stack.size() == 1)
            return;

        //  hypothesis
        int temp = stack.pop();
        reverseStack(stack);

        //  induction
        insert(stack, temp);
    }

    private static void insert(Stack<Integer> stack, int item) {
        //  bc
        if (stack.isEmpty()) {
            stack.push(item);
            return;
        }

        int temp = stack.pop();

        //  hypothesis
        insert(stack, item);

        //  induction
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        if (stack.isEmpty()) {
            System.out.println("yup: stack is Empty!");
            return;
        }

        System.out.println("yup stack before reversing: " + stack.toString());

        reverseStack(stack);

        System.out.println("yup stack after deleting: " + stack.toString());
    }
}
