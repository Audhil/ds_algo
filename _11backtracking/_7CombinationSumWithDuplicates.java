package _11backtracking;

import java.util.ArrayList;
import java.util.List;

//  https://www.youtube.com/watch?v=KvxUS8QlLfY&list=PLNxqWc8Uj2LTaaxs-8vzK0Ft47rMggFnN&index=10
//  TC: O(2 ^ (min(target/minElement ,  n)))
//  notes @ https://photos.google.com/album/AF1QipMLL_acuhN6YogZ1XMenF02iNt7vVctR7ZvlyE_/photo/AF1QipPlD2FNS7-wQEfJ0Hn37hbBVs-eWwMRlxaM2a_w
public class _7CombinationSumWithDuplicates {

    private static void cbWithDuplicates(int i,
                                         int n,
                                         int[] arr,
                                         int sum,
                                         int target,
                                         List<Integer> currCombination,
                                         List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(currCombination));
            return;
        }
        if (i == n || sum > target) {
            return;
        }

        //  include ith element - iterating left side
        sum += arr[i];
        currCombination.add(arr[i]);
        cbWithDuplicates(i, n, arr, sum, target, currCombination, result);

        //  exclude ith element, move to next iteration - right side
        sum -= arr[i];
        currCombination.remove(currCombination.size() - 1);
        cbWithDuplicates(i + 1, n, arr, sum, target, currCombination, result);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};  //  always sort the order, if need - to get end result sorted
        int target = 4;
        List<List<Integer>> result = new ArrayList<>();
        cbWithDuplicates(0, arr.length, arr, 0, target, new ArrayList<>(), result);
        System.out.println("yup: the combinations are");
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
        /*
        * o/p
        * yup: the combinations are
            [1, 1, 1, 1]
            [1, 1, 2]
            [1, 3]
            [2, 2]
        */
    }
}
