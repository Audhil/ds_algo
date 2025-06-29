package _10Blind75._11Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//  //  https://www.youtube.com/watch?v=qe_pQCh09yU&ab_channel=TECHDOSE
public class _5TopologicalSort_DFS_CourseSchedule_II_isCyclePresent {

  public static int[] findOrder(int numCourses, int[][] prerequisites) {
    if (prerequisites.length == 0 || prerequisites[0].length == 0) {
      return new int[0];
    }
    List<List<Integer>> adjList = new ArrayList<>();
    for (int i = 0; i < numCourses; i++) {
      adjList.add(new ArrayList<>());
    }
    for (int[] p : prerequisites) {
      List<Integer> list = adjList.get(p[1]);
      list.add(p[0]);
      adjList.set(p[1], list);
    }
    //  if it is cycle, we cannot do all courses, hence returning empty array
    int[] visited = new int[numCourses];
    for (int crs = 0; crs < numCourses; crs++) {
      if (isCycle(crs, visited, adjList)) {
        return new int[0];
      }
    }
    //  do topological sort and return the order
    return topologicalSort(numCourses, adjList);
  }

  private static int[] topologicalSort(int numCourses, List<List<Integer>> adjList) {
    boolean[] visited = new boolean[numCourses];
    Stack<Integer> stack = new Stack<>();
    for (int crs = 0; crs < numCourses; crs++) {
      if (!visited[crs]) {
        dfs(crs, visited, adjList, stack);
      }
    }
    int[] output = new int[numCourses];
    int i = 0;
    while (!stack.isEmpty()) {
      int item = stack.pop();
      output[i++] = item;
    }
    return output;
  }

  private static void dfs(int crs,
      boolean[] visited,
      List<List<Integer>> adjList,
      Stack<Integer> stack) {
    visited[crs] = true;
    List<Integer> neighbours = adjList.get(crs);
    for (int nei : neighbours) {
      if (!visited[nei]) {
        dfs(nei, visited, adjList, stack);
      }
    }
    stack.push(crs);
  }

  //  0 - un processed, 1 - processed, 2 - processing
  private static boolean isCycle(int crs, int[] visited, List<List<Integer>> adjList) {
    if (visited[crs] == 2) {
      return true;
    }
    visited[crs] = 2;
    List<Integer> neighbour = adjList.get(crs);
    for (int nei : neighbour) {
      if (visited[nei] != 1) {
        if (isCycle(nei, visited, adjList)) {
          return true;
        }
      }
    }
    visited[crs] = 1;
    return false;
  }

  public static void main(String[] args) {
    int numCourses = 2;
    int[][] preReqs = {{1, 0}};
    System.out.println("yup: order of courses to be taken: " + Arrays.toString(
        findOrder(numCourses, preReqs))); //  yup: order of courses to be taken: [0, 1]

    numCourses = 4;
    int[][] preReqs2 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
    System.out.println("yup: order of courses to be taken: " + Arrays.toString(
        findOrder(numCourses, preReqs2)));  //  yup: order of courses to be taken: [0, 2, 1, 3]

    numCourses = 1;
    int[][] preReqs3 = {{}};
    System.out.println("yup: order of courses to be taken: " + Arrays.toString(
        findOrder(numCourses, preReqs3)));  //  yup: order of courses to be taken: []
  }
}
