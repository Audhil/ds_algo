package _11backtracking;

import java.util.ArrayList;
import java.util.List;

//  https://www.youtube.com/watch?v=U_Pe95r41Rs&list=PLNxqWc8Uj2LTaaxs-8vzK0Ft47rMggFnN&index=3
public class FindAllSubsetsOfSet {

    private static void subsets(int index, int[] arr, int n, List<Integer> currList, List<List<Integer>> resultList) {
        if (index == n) {
            resultList.add(new ArrayList<>(currList));
            return;
        }

        //  recursing in left part
        subsets(index + 1, arr, n, currList, resultList);
        //  add element
        currList.add(arr[index]);
        //  recursing - right part
        subsets(index + 1, arr, n, currList, resultList);
        //  remove item for backtracking
        currList.remove(currList.size() - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<Integer> currList = new ArrayList<>();
        List<List<Integer>> resultList = new ArrayList<>();
        subsets(0, arr, arr.length, currList, resultList);
        System.out.println("yup: subsets count: " + resultList.size());
        for (List<Integer> subset : resultList) {
            for (Integer integer : subset)
                System.out.print(integer);
            System.out.println();
        }
        System.out.println("All done!");
    }
}
