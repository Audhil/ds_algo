package _0easy;

import java.util.*;

//  https://www.youtube.com/watch?v=PaJxqZVPhbg
/*

 * Given an array of meeting time intervals consisting of start & end times [s1, e1] ... [si, ei]
 *   (s < e)
 * determine if a person could attend all meetings
 *
 * eg: intervals [(0, 30), (5, 10), (15, 20)]
 * op : false

 */
public class MeetingRooms {

    public static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null)
            return false;
        //  sorting based on meeting startTime
        intervals.sort(Comparator.comparingInt(o -> o.start));  //  equivalent to - Collections.sort(intervals, (o1, o2) -> o1.start - o2.start);

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start < intervals.get(i - 1).end)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("yup: whether he'll attend all meetings: " + canAttendMeetings(Arrays.asList(new Interval(1, 10), new Interval(0, 5), new Interval(33, 59), new Interval(21, 34))));
        System.out.println("yup: whether he'll attend all meetings: " + canAttendMeetings(Arrays.asList(new Interval(5, 10), new Interval(10, 15))));
        System.out.println("yup: whether he'll attend all meetings: " + canAttendMeetings(Arrays.asList(new Interval(5, 8), new Interval(9, 15))));
    }
}
