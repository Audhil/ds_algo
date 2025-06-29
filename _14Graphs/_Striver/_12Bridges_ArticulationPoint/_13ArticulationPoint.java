package _14Graphs._Striver._12Bridges_ArticulationPoint;

import java.util.ArrayList;
import java.util.List;

//  always remember the map from this video: easier to understand
//  https://www.youtube.com/watch?v=fqkqx6OBRDE&ab_channel=CodeHelp-byBabbar
public class _13ArticulationPoint {

  private static void printArticulationPoint(List<List<Integer>> adjList, int N) {
    boolean[] visited = new boolean[N];
    int[] discoveryArr = new int[N];
    int[] lowTimeOfDiscoveryArr = new int[N];
    int[] timer = {0};

    for (int i = 0; i < N; i++) {
      dfs(i, -1, adjList, discoveryArr, lowTimeOfDiscoveryArr, visited, timer);
    }
  }

  private static void dfs(int node,
      int parent,
      List<List<Integer>> adjList,
      int[] discoveryArr,
      int[] lowTimeOfDiscoveryArr,
      boolean[] visited,
      int[] timer) {
    visited[node] = true;
    discoveryArr[node] = lowTimeOfDiscoveryArr[node] = ++timer[0];
    int child = 0;
    for (int nbr : adjList.get(node)) {
      if (nbr == parent) {
        continue;
      }
      if (!visited[nbr]) {
        dfs(nbr, node, adjList, discoveryArr, lowTimeOfDiscoveryArr, visited, timer);
        lowTimeOfDiscoveryArr[node] =
            Math.min(lowTimeOfDiscoveryArr[node], lowTimeOfDiscoveryArr[nbr]);
        //  is it a articulation point?
        if (lowTimeOfDiscoveryArr[nbr] >= discoveryArr[node] && parent != -1) {
          System.out.println("yup: the articulation point: " + node);
        }
        child++;
      }
      //  back edge
      else {
        lowTimeOfDiscoveryArr[node] = Math.min(lowTimeOfDiscoveryArr[node], discoveryArr[nbr]);
      }
    }
    //  special case to handle root node of the graph
    if (parent == -1 && child > 1) {
      System.out.println("yup: the articulation point: " + node);
    }
  }

  public static void main(String[] args) {
    int N = 5;
    List<List<Integer>> adjList = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      adjList.add(new ArrayList<>());
    }
    //  edges
    adjList.get(0).add(1);
    adjList.get(1).add(0);

    adjList.get(1).add(2);
    adjList.get(2).add(1);

    adjList.get(0).add(2);
    adjList.get(2).add(0);

    adjList.get(0).add(3);
    adjList.get(3).add(0);

    adjList.get(3).add(4);
    adjList.get(4).add(3);
    /*
      yup: the articulation point: 3
      yup: the articulation point: 0
    * */
    printArticulationPoint(adjList, N);
  }
}
