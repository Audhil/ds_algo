package ds_algo._1Recursion._1IBH;

import java.util.ArrayList;
import java.util.List;

//  https://youtu.be/AZ4jEY_JAVc?list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY
public class _4SortArray_Recursion {

    private List<Integer> list = new ArrayList<>();

    private void sort(List<Integer> list) {
        //  base condition
        if (list.size() == 1)
            return;

        //  hypothesis
        int lastItem = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        sort(list);

        //  induction
        insert(list, lastItem);
    }

    private void insert(List<Integer> list, int temp) {
        //  base condition
        if (list.size() == 0 || list.get(list.size() - 1) <= temp) {
            list.add(temp);
            return;
        }

        int lastItem = list.get(list.size() - 1);
        list.remove(list.size() - 1);

        //  hypothesis
        insert(list, temp);

        //  induction
        list.add(lastItem);
    }

    public static void main(String[] args) {
        _4SortArray_Recursion pro = new _4SortArray_Recursion();

        pro.list.add(5);
        pro.list.add(2);
        pro.list.add(0);
        pro.list.add(1);

        System.out.println("yup: before sorting: " + pro.list.toString());
        pro.sort(pro.list);
        System.out.println("yup: after sorting: " + pro.list.toString());
    }
}
