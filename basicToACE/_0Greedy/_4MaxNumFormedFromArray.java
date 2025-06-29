package basicToACE._0Greedy;

import java.util.Arrays;
import java.util.Collections;

//  https://youtu.be/x86DWJu7zoc?list=PLQXZIFwMtjoz-lIU4qaIHb-gKt46QHdNj&t=255
public class _4MaxNumFormedFromArray {

  private static long maxNumFormed(Integer[] nums) {
    Arrays.sort(nums, Collections.reverseOrder());
    System.out.println(Arrays.toString(nums));
    long result = 0;
    for (Integer num : nums) {
      if (result == 0) {
        result += num;
        continue;
      }
      result *= 10;
      result += num;
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println("yup: maxNumFormed: " + maxNumFormed(
        new Integer[]{4, 3, 1, 0, 9})); //  yup: maxNumFormed: 94310

  }
}
