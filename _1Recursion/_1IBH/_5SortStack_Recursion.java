package ds_algo._1Recursion._1IBH;

import java.util.Stack;

//  https://youtu.be/MOGBRkkOhkY?list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY
//  and https://youtu.be/AZ4jEY_JAVc?list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY
public class _5SortStack_Recursion {

    private void sortStack(Stack<Integer> stack) {
        //  bc
        if (stack.size() == 1)
            return;

        //  hypothesis
        int lastItem = stack.pop();
        sortStack(stack);

        //  induction
        insert(stack, lastItem);
    }

    private void insert(Stack<Integer> stack, int temp) {
        //  bc
        if (stack.isEmpty() || stack.peek() <= temp) {
            stack.push(temp);
            return;
        }

        //  hypothesis
        int lastItem = stack.pop();
        insert(stack, temp);

        //  induction
        stack.push(lastItem);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(1);
        stack.push(0);
        stack.push(2);
        System.out.println("yup stack before sorting: " + stack.toString());
        _5SortStack_Recursion prob = new _5SortStack_Recursion();
        prob.sortStack(stack);
        System.out.println("yup stack after sorting: " + stack.toString());
    }
}
