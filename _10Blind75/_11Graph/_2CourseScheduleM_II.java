package _10Blind75._11Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//  https://www.youtube.com/watch?v=Akt3glAwyfY&ab_channel=NeetCode
//  https://leetcode.com/problems/course-schedule-ii/
public class _2CourseScheduleM_II {

  //  tip: it is based on Topological sort - refer: _5TopologicalSort_CourseSchedule_II_isCyclePresent.java

  //  TC: O (V + E)
  public static int[] findOrder(int numCourses, int[][] prerequisites) {
    if (prerequisites.length == 0 || prerequisites[0].length == 0) {
      return new int[0];
    }
    Map<Integer, List<Integer>> preReqMap = new HashMap<>();
    for (int crs = 0; crs < numCourses; crs++) {
      preReqMap.put(crs, new ArrayList<>());
    }
    for (int[] p : prerequisites) {
      List<Integer> list = preReqMap.get(p[0]);
      list.add(p[1]);
      preReqMap.put(p[0], list);
    }
    Set<Integer> cycle = new HashSet<>();
    Set<Integer> visited = new HashSet<>();
    List<Integer> output = new ArrayList<>();
    for (int crs = 0; crs < numCourses; crs++) {
      if (!dfs(crs, cycle, visited, preReqMap, output)) {
        return new int[0];
      }
    }
    int[] outputArr = new int[output.size()];
    for (int i = 0; i < output.size(); i++) {
      outputArr[i] = output.get(i);
    }
    return outputArr;
  }

  private static boolean dfs(int crs,
      Set<Integer> cycle,
      Set<Integer> visited,
      Map<Integer, List<Integer>> preReqMap,
      List<Integer> output) {
    if (cycle.contains(crs)) {
      return false;
    }
    if (visited.contains(crs)) {
      return true;
    }
    cycle.add(crs);
    for (int pCrs : preReqMap.get(crs)) {
      if (!dfs(pCrs, cycle, visited, preReqMap, output)) {
        return false;
      }
    }
    cycle.remove(crs);
    visited.add(crs);
    output.add(crs);
    return true;
  }

  public static void main(String[] args) {
    int numCourses = 2;
    int[][] preReqs = {{1, 0}};
    System.out.println("yup: order of courses to be taken: " + Arrays.toString(
        findOrder(numCourses, preReqs))); //  yup: order of courses to be taken: [0, 1]

    numCourses = 4;
    int[][] preReqs2 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
    System.out.println("yup: order of courses to be taken: " + Arrays.toString(
        findOrder(numCourses, preReqs2)));  //  yup: order of courses to be taken: [0, 1, 2, 3]

    numCourses = 1;
    int[][] preReqs3 = {{}};
    System.out.println("yup: order of courses to be taken: " + Arrays.toString(
        findOrder(numCourses, preReqs3)));  //  yup: order of courses to be taken: []
  }
}
