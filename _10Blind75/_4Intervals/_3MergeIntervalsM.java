package _10Blind75._4Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//  https://www.youtube.com/watch?v=44H3cEC2fFM&feature=youtu.be&ab_channel=NeetCode
//  https://leetcode.com/problems/merge-intervals/
public class _3MergeIntervalsM {

  //  TC: O (n log n) -> due to sorting
  public static int[][] merge(int[][] intervals) {
    //  1. sort activities based on start time
    Arrays.sort(intervals, Comparator.comparingInt(
        a -> a[0]));  //  equivalent to: Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    List<int[]> resList = new ArrayList<>();
    resList.add(intervals[0]);
    //  2. loop through activities
    for (int i = 1; i < intervals.length; i++) {
      int lastIndex = resList.size() - 1;
      int[] lastEntry = resList.get(lastIndex);
      //  compare start time with last entry's end time
      if (intervals[i][0] <= lastEntry[1]) {
        lastEntry[1] = Math.max(lastEntry[1], intervals[i][1]); //  merging - update the end time
        resList.set(lastIndex, lastEntry);
      } else {
        resList.add(intervals[i]);
      }
    }
    return resList.toArray(new int[resList.size()][]);
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: after merging intervals: " + Arrays.deepToString(merge(new int[][]{{1, 3}, {2, 6}, {
            8, 10}, {15, 18}}))); //  yup: after merging intervals: [[1, 6], [8, 10], [15, 18]]
    System.out.println(
        "yup: 2nd after merging intervals: " + Arrays.deepToString(
            merge(new int[][]{{1, 4}, {4, 5}}))); //  yup: 2nd after merging intervals: [[1, 5]]

    System.out.println(
        "yup: 3rd after merging intervals: " + Arrays.deepToString(
            merge(new int[][]{{1, 4}, {0, 4}}))); //  yup: 2nd after merging intervals: [[0,4]]
  }
}
