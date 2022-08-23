package _10Blind75._11Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//  https://www.youtube.com/watch?v=kXy0ABd1vwo&ab_channel=TECHDOSE
public class _1CourseScheduleM_isCyclePresent {

  //  TC: O (V + E)
  public static boolean canFinish(int numCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> preReqMap = new HashMap<>();  //  we can also make List<List<Integer>>
    for (int i = 0; i < numCourses; i++) {
      preReqMap.put(i, new ArrayList<>());
    }
    //  populate preReqMap
    for (int[] p : prerequisites) {
      List<Integer> neighbors = preReqMap.get(p[0]);
      neighbors.add(p[1]);
      preReqMap.put(p[0], neighbors);
    }

    int[] visited = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      if (isCycle(i, preReqMap, visited)) {
        return false;
      }
    }
    return true;
  }

  //  THIS IS HOW TO DETECT CYCLE IN DIRECTED GRAPH
  //  visited node states - 0 -> un processed, 1 -> processed, 2 -> processing
  private static boolean isCycle(int crs,
      Map<Integer, List<Integer>> preReqMap,
      int[] visited) {
    //  if we encounter processing node/crs we are having cycle
    if (visited[crs] == 2) {
      return true;
    }
    visited[crs] = 2;
    for (int nei : preReqMap.get(crs)) {
      if (visited[crs] != 1) {
        if (isCycle(nei, preReqMap, visited)) {
          return true;
        }
      }
    }
    visited[crs] = 1;
    return false;
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: can we complete the course: " + canFinish(2, new int[][]{{1, 0}}));  //  true
    System.out.println(
        "yup: can we complete the course: " + canFinish(2, new int[][]{{1, 0}, {0, 1}})); //  false
  }
}
