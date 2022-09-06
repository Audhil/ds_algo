package _14Graphs._Striver._13StronglyConnnectedComponent_SCC;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//  https://www.youtube.com/watch?v=V8qIqJxCioo&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=29&ab_channel=takeUforward
public class _1KosarajuAlgoForSCC_DirectedGraph {

  //  find the SCCs
  //  SCC - Strongly Connected Components - able to visit every other node from the node

  //  1. sort the all nodes based on finishing time - Topological sort -> TC: O (N + E); SC: O (N)
  //  2. transpose the graph -> inverting the directions of the graph -> TC: O (N + E); SC: O (N + E)
  //  3. DFS on the transposed graph -> O (N + E); auxiliary space: O (N)

  private static void printSCCwithKosarajuAlgo(List<List<Integer>> adjList, int N) {
    //  1. sort the nodes based on finishing time, loading stack with nodes
    Stack<Integer> stack = new Stack<>();
    boolean[] visited = new boolean[N];
    topologicalSort(stack, adjList, visited, N);

    //  2. transpose the graph - inverting the directions for the graph
    List<List<Integer>> transposeAdjList = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      transposeAdjList.add(new ArrayList<>());
    }
    for (int i = 0; i < N; i++) {
      visited[i] = false;
      for (int nbr : adjList.get(i)) {
        transposeAdjList.get(nbr).add(i);
      }
    }

    System.out.println("yup the SCC components are: ");
    //  3. do the dfs to print SCC on transposed graph from stack items
    while (!stack.isEmpty()) {
      int item = stack.pop();
      if (!visited[item]) {
        printSCCHelper(item, transposeAdjList, visited);
        System.out.println();
      }
    }
  }

  //  DFS
  private static void printSCCHelper(
      int item,
      List<List<Integer>> transposeAdjList,
      boolean[] visited) {
    visited[item] = true;
    System.out.print(item + " -> ");
    for (int nbr : transposeAdjList.get(item)) {
      if (!visited[nbr]) {
        printSCCHelper(nbr, transposeAdjList, visited);
      }
    }
  }

  private static void topologicalSort(
      Stack<Integer> stack,
      List<List<Integer>> adjList,
      boolean[] visited,
      int N) {
    for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        topoHelper(i, stack, adjList, visited);
      }
    }
  }

  //  DFS
  private static void topoHelper(
      int node,
      Stack<Integer> stack,
      List<List<Integer>> adjList,
      boolean[] visited) {
    visited[node] = true;
    for (int nbr : adjList.get(node)) {
      if (!visited[nbr]) {
        topoHelper(nbr, stack, adjList, visited);
      }
    }
    stack.push(node);
  }

  public static void main(String[] args) {
    int N = 6;
    List<List<Integer>> adjList = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      adjList.add(new ArrayList<>());
    }

    //  edges
    adjList.get(1).add(2);
    adjList.get(2).add(3);
    adjList.get(3).add(1);

    adjList.get(2).add(4);
    adjList.get(4).add(5);
    /*
    * yup the SCC components are:
      1 -> 3 -> 2 ->
      4 ->
      5 ->
      0 ->
    */
    printSCCwithKosarajuAlgo(adjList, N);

    N = 7;
    adjList = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      adjList.add(new ArrayList<>());
    }
    adjList.get(1).add(2);
    adjList.get(2).add(3);
    adjList.get(3).add(1);

    adjList.get(3).add(5);

    adjList.get(5).add(4);
    adjList.get(4).add(6);
    adjList.get(6).add(5);

    /*
    * 1 -> 3 -> 2 ->
      5 -> 6 -> 4 ->
      0 ->
    */
    printSCCwithKosarajuAlgo(adjList, N);
  }
}
