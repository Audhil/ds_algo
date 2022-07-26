package _10Blind75._6GreedyApproach._1ActivitySelection_Intervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

//  https://leetcode.com/problems/maximum-profit-in-job-scheduling/
//  https://www.youtube.com/watch?v=3kU7VYcmffU&ab_channel=AlgorithmsMadeEasy
public class _1ActivitiesWithProfitsH {

  private static class Activity {

    public int start, end, profit;

    public Activity(int start, int end, int profit) {
      this.start = start;
      this.end = end;
      this.profit = profit;
    }

    @Override
    public String toString() {
      return "Activity{" +
          "start=" + start +
          ", end=" + end +
          ", profit=" + profit +
          '}';
    }
  }

  //  based on https://youtu.be/ZOP43iB_E_8?t=885
  private static int maxProfitWithActivities(List<Activity> activityList) {
    if (activityList == null) {
      return 0;
    }
    //  sort activities based on end time
    activityList.sort(Comparator.comparingInt(k -> k.end));
    //  key - endTime, value - maxProfitTillStartTime
    TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    int ans = 0;
    for (Activity activity : activityList) {
      Integer endTimeKeyTillStartTime = treeMap.floorKey(
          activity.start); //  chooses key which is nearer to the startTime - eg: 6 is returned for key 7;
      int maxProfitTillNow =
          endTimeKeyTillStartTime == null ? 0 : treeMap.get(endTimeKeyTillStartTime);
      ans = Math.max(ans, maxProfitTillNow + activity.profit);
      treeMap.put(activity.end, ans);
    }
    return ans;
  }

  public static void main(String[] args) {
    List<Activity> activityList = new ArrayList<>();
//    activityList.add(new Activity(1, 3, 5));
//    activityList.add(new Activity(2, 6, 16));
//    System.out.println("yup: maxProfitWithActivities: " + maxProfitWithActivities(activityList)); //  yup: maxProfitWithActivities: 16

    activityList.add(new Activity(1, 3, 10));
    activityList.add(new Activity(2, 5, 5));
    activityList.add(new Activity(4, 6, 12));
    activityList.add(new Activity(4, 11, 15));
    activityList.add(new Activity(7, 14, 2));
    System.out.println("yup: maxProfitWithActivities: " + maxProfitWithActivities(
        activityList)); //  yup: maxProfitWithActivities: 25
  }
}
