package _10Blind25._4Intervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//  https://www.lintcode.com/problem/920/
/*
 Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 determine if a person could attend all meetings.
 */
public class _0MeetingRoomsE {

  public static class Interval {

    int start, end;

    Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  public static boolean canAttendMeetings(List<Interval> intervals) {
    if (intervals == null) {
      return false;
    }
    intervals.sort(Comparator.comparingInt(k -> k.start));
    for (int i = 1; i < intervals.size(); i++) {
      if (intervals.get(i).start < intervals.get(i - 1).end) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    List<Interval> list = new ArrayList<>();
//    false
//    list.add(new Interval(0, 30));
//    list.add(new Interval(5, 10));
//    list.add(new Interval(15, 20));

    //  true
    list.add(new Interval(5, 8));
    list.add(new Interval(9, 15));
    System.out.println("yup: canAttendMeetings: " + canAttendMeetings(list));
  }
}
