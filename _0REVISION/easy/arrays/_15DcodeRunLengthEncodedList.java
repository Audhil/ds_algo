package _0REVISION.easy.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15DcodeRunLengthEncodedList {

    public static int[] decompressRLElist(int[] nums) {
        if (nums == null)
            return null;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i += 2) {
            int freq = nums[i];
            int item = nums[i + 1];
            for (int j = 0; j < freq; j++) {
                list.add(item);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }

    public static void main(String[] args) {
        System.out.println("yup: " + Arrays.toString(decompressRLElist(new int[]{1, 2, 3, 4})));
    }
}
