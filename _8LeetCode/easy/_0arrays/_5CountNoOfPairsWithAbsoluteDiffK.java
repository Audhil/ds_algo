package _8LeetCode.easy._0arrays;

//  https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/
public class _5CountNoOfPairsWithAbsoluteDiffK {

    //  O (n^2)
    public static int countKDifference(int[] nums, int k) {
        if (nums == null || k <= 0)
            return 0;

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k)
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("yup: res: " + countKDifference(new int[]{1, 2, 2, 1}, 1));
        System.out.println("yup: res: " + countKDifference(new int[]{1, 3}, 3));
        System.out.println("yup: res: " + countKDifference(new int[]{3, 2, 1, 5, 4}, 2));
    }
}
