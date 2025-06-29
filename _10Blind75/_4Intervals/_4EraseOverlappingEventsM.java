package _10Blind75._4Intervals;

import java.util.Arrays;
import java.util.Comparator;

//  https://leetcode.com/problems/non-overlapping-intervals/
//  https://www.youtube.com/watch?v=nONCGxWoUfM&feature=youtu.be&ab_channel=NeetCode
public class _4EraseOverlappingEventsM {

  //  TC: O (n log n)
  public static int eraseOverlapIntervals(int[][] intervals) {
    //  1. sort based on end value
    Arrays.sort(intervals, Comparator.comparingInt(k -> k[1]));
    int result = 0;
    //  2. end time
    int lastEndTime = intervals[0][1];
    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i][0] < lastEndTime) {
        result++;
      } else {
        lastEndTime = intervals[i][1];
      }
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println("yup: erase overlapping events: " + eraseOverlapIntervals(
        new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));  //  1
    System.out.println("yup: 2nd erase overlapping events: " + eraseOverlapIntervals(
        new int[][]{{1, 2}, {1, 2}, {1, 2}}));  //  2
    System.out.println(
        "yup: 3rd erase overlapping events: " + eraseOverlapIntervals(
            new int[][]{{1, 2}, {2, 3}}));  //  0
  }
}
