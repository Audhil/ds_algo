package _0REVISION.easy.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _16CreateTargetArray {

    public static int[] createTargetArray(int[] nums, int[] index) {
        if (nums == null || index == null)
            return null;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < index.length; i++) {
            list.add(index[i], nums[i]);
            list.indexOf(nums[i]);
        }
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println("yup: _16CreateTargetArray: " + Arrays.toString(createTargetArray(new int[]{0, 1, 2, 3, 4}, new int[]{0, 1, 2, 2, 1})));
    }
}
