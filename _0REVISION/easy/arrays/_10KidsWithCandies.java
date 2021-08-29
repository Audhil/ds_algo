package _0REVISION.easy.arrays;

import java.util.ArrayList;
import java.util.List;

//  https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
public class _10KidsWithCandies {

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        if (candies == null || candies.length == 0 || extraCandies < 0)
            return null;

        int maxCandiesWithKid = Integer.MIN_VALUE;
        for (int candy : candies) {
            maxCandiesWithKid = Math.max(maxCandiesWithKid, candy);
        }

        List<Boolean> booleanList = new ArrayList<>();
        for (int candy : candies) {
            booleanList.add(candy + extraCandies >= maxCandiesWithKid);
        }
        return booleanList;
    }

    public static void main(String[] args) {
        System.out.println("yup: " + kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3)); //  yup: [true, true, true, false, true]
        System.out.println("yup: " + kidsWithCandies(new int[]{4, 2, 1, 1, 2}, 1)); //  yup: [true, false, false, false, false]
    }
}
