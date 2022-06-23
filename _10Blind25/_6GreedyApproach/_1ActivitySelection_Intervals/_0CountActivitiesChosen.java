package _10Blind25._6GreedyApproach._1ActivitySelection_Intervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//  https://youtu.be/FEEfTkvsVDM?t=1959
public class _0CountActivitiesChosen {

  private static class Activity {

    public int start, end;

    public Activity(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public String toString() {
      return "Activity{" +
          "start=" + start +
          ", end=" + end +
          '}';
    }
  }

  //  count number of activities chosen to maximum utilize time
  private static int noOfNonOverlappingActivitiesChosen(List<Activity> activityList) {
    if (activityList == null) {
      return 0;
    }
    //  sort activities based on end time
    activityList.sort(Comparator.comparingInt(k -> k.end));
    int numOfActivities = 0, freeAt = 0;
    for (Activity activity : activityList) {
      if (activity.start >= freeAt) {
        numOfActivities++;
        freeAt = activity.end;
      }
    }
    return numOfActivities;
  }

  public static void main(String[] args) {
    List<Activity> activityList = new ArrayList<>();
    activityList.add(new Activity(1, 3));
    activityList.add(new Activity(2, 6));
    activityList.add(new Activity(4, 5));
    System.out.println(
        "yup: noOfNonOverlappingActivitiesChosen: " + noOfNonOverlappingActivitiesChosen(
            activityList)); //  yup: noOfNonOverlappingActivitiesChosen: 2
  }
}
