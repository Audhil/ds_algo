package _10Blind75._4Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  https://www.lintcode.com/problem/919/
//  https://www.youtube.com/watch?v=FdzJmTCVyJU&ab_channel=NeetCode
/*
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.)
 * */
public class _1MeetingRooms2M {

  public static class Interval {

    int start, end;

    Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  //  TC: O (n log n)
  public static int minMeetingRooms(List<Interval> intervals) {
    if (intervals == null || intervals.size() == 0) {
      return 0;
    }
    int[] startTimeArray = new int[intervals.size()];
    int[] endTimeArray = new int[intervals.size()];
    for (int i = 0; i < intervals.size(); i++) {
      startTimeArray[i] = intervals.get(i).start;
      endTimeArray[i] = intervals.get(i).end;
    }
    Arrays.sort(startTimeArray);
    Arrays.sort(endTimeArray);
    //  iterate
    int totMeetings = intervals.size();
    int startPtr = 0;
    int endPtr = 0;
    int roomCount = 0;
    int result = 0;

    while (startPtr < totMeetings) {
      if (startTimeArray[startPtr] < endTimeArray[endPtr]) {
        roomCount++;
        startPtr++;
      } else if (startTimeArray[startPtr] > endTimeArray[endPtr]) {
        roomCount--;
        endPtr++;
      }
      //  give preference to end time, if there is tie - > [0, 10], [10, 15]
      else {
        roomCount--;
        endPtr++;
      }
      result = Math.max(result, roomCount);
    }
    return result;
  }

  public static void main(String[] args) {
    List<Interval> list = new ArrayList<>();
//    2
//    list.add(new Interval(0, 30));
//    list.add(new Interval(5, 10));
//    list.add(new Interval(15, 20));

    //  1
    list.add(new Interval(5, 8));
    list.add(new Interval(9, 15));

    //  1
    list.add(new Interval(9, 19));
    System.out.println("yup: noOfMeeting rooms required: " + minMeetingRooms(list));
  }
}
