package _11backtracking;

//  https://www.youtube.com/watch?v=bh3dXVsRHsc&list=PLNxqWc8Uj2LTaaxs-8vzK0Ft47rMggFnN&index=11

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _8CombinationSumWithoutDuplicates {
    private static void cbWithDuplicates(int i,
                                         int n,
                                         int[] arr,
                                         int sum,
                                         int target,
                                         List<Integer> currCombination,  //  using set to avoid duplicates
                                         Set<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(currCombination));
            return;
        }
        if (i == n || sum > target) {
            return;
        }

        //  include ith element, iterating left side
        sum += arr[i];
        currCombination.add(arr[i]);
        cbWithDuplicates(i + 1, n, arr, sum, target, currCombination, result);

        //  exclude ith element, move to next iteration - right side
        sum -= arr[i];
        currCombination.remove(currCombination.size() - 1);
        cbWithDuplicates(i + 1, n, arr, sum, target, currCombination, result);
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3};  //  always sort the order, if need - to get end result sorted
        int target = 4;
        Set<List<Integer>> result = new HashSet<>();
        cbWithDuplicates(0, arr.length, arr, 0, target, new ArrayList<>(), result);
        System.out.println("yup: the combinations without duplicates are");
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
        /*
        * o/p
        * yup: the combinations are
            yup: the combinations without duplicates are
                [1, 1, 2] -> note, both 1's are different, we've 1 twice in question
                [1, 3]
        */
    }
}
