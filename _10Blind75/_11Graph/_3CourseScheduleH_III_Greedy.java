package _10Blind75._11Graph;

import java.util.Arrays;
import java.util.PriorityQueue;

//  https://www.youtube.com/watch?v=ey8FxYsFAMU&ab_channel=AlgorithmsMadeEasy
//  https://leetcode.com/problems/course-schedule-iii/
public class _3CourseScheduleH_III_Greedy {

  //  TC: O (n log n), SC: O (n) -> priority will contain all the courses for the worst case
  //  int[][] courses = [[duration, last day to complete], ..... ]
  public static int scheduleCourse(int[][] courses) {
    Arrays.sort(courses, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
    PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);  //  max heap
    int time = 0;
    for (int[] course : courses) {
      //  consider only courses whose duration is <= last day to complete
      if (course[0] <= course[1]) {
        //  take those courses whose duration + available time <= last day to complete
        if (course[0] + time <= course[1]) {
          time += course[0];
          queue.add(course[0]);
        }
        //  replace any course with greater duration than the current course
        else {
          if (!queue.isEmpty() && queue.peek() > course[0]) {
            time -= queue.poll();
            time += course[0];
            queue.add(course[0]);
          }
        }
      }
    }
    return queue.size();  //  available courses in the queue
  }

  public static void main(String[] args) {
    int[][] courses = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
    System.out.println("Yup: number of courses can be taken: " + scheduleCourse(courses));  //  3
    int[][] courses2 = {{1, 2}};
    System.out.println("Yup: number of courses2 can be taken: " + scheduleCourse(courses2));  //  1
    int[][] courses3 = {{3, 2}, {4, 3}};
    System.out.println("Yup: number of courses3 can be taken: " + scheduleCourse(courses3));  //  0
  }
}
