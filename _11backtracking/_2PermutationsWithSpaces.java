package _11backtracking;

import java.util.HashSet;
import java.util.Set;

//  https://www.youtube.com/watch?v=Ax6xiIQt5fs&list=PLNxqWc8Uj2LTaaxs-8vzK0Ft47rMggFnN&index=5
//  TC : for n length string - (n-1) spaces can be included, include+not include choice of space = 2 = hence O(2^(n - 1)) => O(2^n)
//  notes @ https://photos.google.com/album/AF1QipMLL_acuhN6YogZ1XMenF02iNt7vVctR7ZvlyE_/photo/AF1QipNNjoBNXkVfJHvIPyR5W9kkGcUQzujrJiMLPTYS
public class _2PermutationsWithSpaces {

    private static void permutationsWithSpaces(int start, int len, String currString, Set<String> permutations) {
        if (start == len - 1) {
            permutations.add(currString);
            return;
        }
        //  recursing in left part
        permutationsWithSpaces(start + 1, len, currString, permutations);
        //  add space
//        String prevString = currString;
        currString = currString.substring(0, start + 1) + "_" + currString.substring(start + 1);    //  using "_" instead of " "
        permutationsWithSpaces(start + 2, len + 1, currString, permutations);
        //  remove space during backtracking
//        currString = prevString;  //  commenting this also works
    }

    public static void main(String[] args) {
        String abc = "abb";
        Set<String> stringSet = new HashSet<>();
        permutationsWithSpaces(0, abc.length(), abc, stringSet);
        System.out.println("yup: permutationsWithSpaces: " + stringSet.size());
        for (String perm : stringSet) {
            System.out.println(perm);
        }
    }
}
