package basicToACE._0Greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

//  https://leetcode.com/problems/maximum-earnings-from-taxi/
//  this problem is similar to _1ActivitiesWithProfitsH.java
public class _6MaximumEarningFromTaxiM {

  private static class Passenger {

    public long start, end, tip;

    public Passenger(long start, long end, long tip) {
      this.start = start;
      this.end = end;
      this.tip = tip;
    }

    @Override
    public String toString() {
      return "Passenger{" +
          "start=" + start +
          ", end=" + end +
          ", tip=" + tip +
          '}';
    }
  }

  public static long maxTaxiEarnings(int n, int[][] rides) {
    if (rides == null) {
      return 0L;
    }

    List<Passenger> pList = new ArrayList<>();
    for (int[] ride : rides) {
      Passenger passenger = new Passenger(ride[0], ride[1], ride[2]);
      pList.add(passenger);
    }

    //  sort passenger based on end time
    pList.sort(Comparator.comparingLong(k -> k.end));

    //  TreeMap
    long ans = 0;
    TreeMap<Long, Long> map = new TreeMap<>();
    for (Passenger passenger : pList) {
      Long endTimeKeyTillStartTime = map.floorKey(passenger.start);
      long maxTipTillNow = (endTimeKeyTillStartTime == null ? 0 : map.get(endTimeKeyTillStartTime));
      ans = Math.max(ans, maxTipTillNow + (passenger.end - passenger.start + passenger.tip));
      map.put(passenger.end, ans);
    }
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(
        "1st maxTaxiEarnings: " + maxTaxiEarnings(5,
            new int[][]{{2, 5, 4}, {1, 5, 1}})); //  1st maxTaxiEarnings: 7
    System.out.println("2nd maxTaxiEarnings: " + maxTaxiEarnings(20,
        new int[][]{{1, 6, 1}, {3, 10, 2}, {10, 12, 3}, {11, 12, 2}, {12, 15, 2},
            {13, 18, 1}})); //  2nd maxTaxiEarnings: 20
  }
}
