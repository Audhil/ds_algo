package _10Blind75._11Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//  refer: _1CourseScheduleM_isCyclePresent.java for easy understanding
//  https://leetcode.com/problems/course-schedule/
//  https://www.youtube.com/watch?v=EgI5nU9etnU&ab_channel=NeetCode
//  tip: DETECT cycle in directed graph - if there's cycle, then the course cannot be completed
public class _1CourseScheduleM {

  //  TC: O (N + P) -> num of courses + num of prerequisites
  private static boolean dfs(int crs,
      Map<Integer, List<Integer>> preReqMap,
      Set<Integer> visitedSet) {
    //  we detect the cycle - hence course completion not possible
    if (visitedSet.contains(crs)) {
      return false;
    }
    //  if there's no pre req courses needed, we can complete the course without any hurdle
    if (preReqMap.get(crs).size() == 0) {
      return true;
    }
    visitedSet.add(crs);
    for (int preCrs : preReqMap.get(crs)) {
      if (!dfs(preCrs, preReqMap, visitedSet)) {
        return false;
      }
    }
    //  since this course can be completed and removing with visitedSet for next branch iteration
    visitedSet.remove(crs);
    //  since this course can be completed and removing preReqs
    preReqMap.put(crs, new ArrayList<>());
    return true;
  }

  public static boolean canFinish(int numCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> preReqMap = new HashMap<>();
    for (int i = 0; i < numCourses; i++) {
      preReqMap.put(i, new ArrayList<>());
    }
    //  populate preReqMap
    for (int[] p : prerequisites) {
      List<Integer> neighbors = preReqMap.get(p[0]);
      neighbors.add(p[1]);
      preReqMap.put(p[0], neighbors);
    }
    //  visited set - to find loop
    Set<Integer> visitedSet = new HashSet<>();
    for (int crs = 0; crs < numCourses; crs++) {
      if (!dfs(crs, preReqMap, visitedSet)) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: can we complete the course: " + canFinish(2, new int[][]{{1, 0}}));  //  true
    System.out.println(
        "yup: can we complete the course: " + canFinish(2, new int[][]{{1, 0}, {0, 1}})); //  false
  }
}
