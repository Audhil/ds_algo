package _3Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//  https://youtu.be/p9T-fE1g1pU?list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd
public class _5StockSpanProb {

    //  tip is (index of NGL - current index) = gives stocks span

    private int[] arr = {100, 80, 60, 70, 60, 75, 85};
    private List<Integer> res = new ArrayList<>();
    private Stack<ItemWithIndex> stack = new Stack<>();

    private static class ItemWithIndex {
        private int item, index;

        public ItemWithIndex(int item, int index) {
            this.item = item;
            this.index = index;
        }
    }

    private List<Integer> solve() {
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty())
                res.add(-1);
            else if (stack.peek().item > arr[i])
                res.add(stack.peek().index);
            else if (stack.peek().item < arr[i]) {
                while (!stack.isEmpty() && stack.peek().item <= arr[i])
                    stack.pop();

                if (stack.isEmpty())
                    res.add(-1);
                else
                    res.add(stack.peek().index);
            }
            stack.push(new ItemWithIndex(arr[i], i));  //  storing index instead of actual items
        }
        System.out.println("yup: NGL indices: " + res);
        for (int i = 0; i < res.size(); i++)
            res.set(i, i - res.get(i)); //  watch video for beautiful explanation
        System.out.println("yup: stock span is : " + res);
        return res;
    }

    public static void main(String[] args) {
        _5StockSpanProb prob = new _5StockSpanProb();
        System.out.println("yup: stock span: " + prob.solve());
    }
}
