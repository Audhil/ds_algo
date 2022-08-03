package _10Blind75._4Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  https://www.youtube.com/watch?v=A8NUOmlwOlM&ab_channel=NeetCode
//  https://leetcode.com/problems/insert-interval/
public class _2InsertIntervalM {

  //  TC: O (n)
  public static int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> list = new ArrayList<>();
    for (int i = 0; i < intervals.length; i++) {
      //  if newInterval falls before the given intervals
      if (newInterval[1] < intervals[i][0]) {
        list.add(newInterval);
        for (int j = i; j < intervals.length; j++) {
          list.add(intervals[j]);
        }
        return getResult(list);
      }
      //  if newInterval falls after the given interval
      else if (newInterval[0] > intervals[i][1]) {
        list.add(intervals[i]);
      }
      //  overlaps
      else {
        newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
        newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
      }
    }
    list.add(newInterval);
    return getResult(list);
  }

  private static int[][] getResult(List<int[]> intervalList) {
    int[][] resArr = new int[intervalList.size()][2];
    int index = 0;
    for (int[] interval : intervalList) {
      resArr[index++] = interval;
    }
    return resArr;
  }

  public static void main(String[] args) {
    System.out.println("yup: 1st final intervals: " + Arrays.deepToString(
        insert(new int[][]{{1, 3}, {6, 9}},
            new int[]{2, 5}))); //  yup: 1st final intervals: [[1, 5], [6, 9]]
    System.out.println("yup: 2nd final intervals: " + Arrays.deepToString(
        insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}},
            new int[]{4, 8})));  //  yup: 2nd final intervals: [[1, 2], [3, 10], [12, 16]]
  }
}
