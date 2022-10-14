package _0easy._facebook;

import java.util.Arrays;
import java.util.List;

//  https://www.lintcode.com/problem/156/solution/18503?fromId=29&_from=collection
public class _6MergeIntervals_NoExtraMemoryE {

  private static class Interval {

    int startTime, endTime;

    public Interval(int startTime, int endTime) {
      this.startTime = startTime;
      this.endTime = endTime;
    }

    @Override
    public String toString() {
      return "Interval{" +
          "startTime=" + startTime +
          ", endTime=" + endTime +
          '}';
    }
  }

  //  TC: O (n log n); SC: O (1)
  public static List<Interval> merge(List<Interval> intervals) {
    //  1. sort intervals
    intervals.sort((o1, o2) -> {
      if (o1.startTime == o2.startTime) {
        return o1.endTime - o2.endTime;
      }
      return o1.startTime - o2.startTime;
    });
    //  2. merge intervals if needed
    int lastEnd = -1, index = 0;
    for (Interval item : intervals) {
      if (lastEnd == -1 || lastEnd < item.startTime) {
        intervals.get(index).startTime = item.startTime;
        intervals.get(index).endTime = item.endTime;
        lastEnd = item.endTime;
        index++;
      }
      //  merge
      else {
        lastEnd = Math.max(lastEnd, item.endTime);
        intervals.get(index - 1).endTime = lastEnd;
      }
    }
    return intervals.subList(0, index);
  }

  public static void main(String[] args) {
    System.out.println("yup: merge intervals: " + merge(
        Arrays.asList(
            new Interval(1, 3),
            new Interval(8, 10),
            new Interval(15, 18),
            new Interval(2, 6))));  //  yup: merge intervals: [Interval{startTime=1, endTime=6}, Interval{startTime=8, endTime=10}, Interval{startTime=15, endTime=18}]
    System.out.println("yup: merge intervals: " + merge(
        Arrays.asList(
            new Interval(1, 3))));  //  yup: merge intervals: [Interval{startTime=1, endTime=3}]
  }
}
