package _0REVISION.easy.arrays;

import java.util.Arrays;

public class _9ShuffleTheArray {

    public static int[] shuffle(int[] nums, int n) {
        if (nums == null || n < 0)
            return nums;

        int[] res = new int[n * 2];
        int k = 0;
        for (int i = 0, j = nums.length / 2; i < n; i++, j++) {
            res[k] = nums[i];
            res[k + 1] = nums[j];
            k += 2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("yup: " + Arrays.toString(shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));    //  yup: [1,3,4]
    }
}
