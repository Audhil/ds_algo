package _14Graphs._Striver._12Bridges_ArticulationPoint;

import java.util.ArrayList;
import java.util.List;

//  always remember the map from this video: easier to understand
//  clarified explanation: https://www.youtube.com/watch?v=CiDPT1xMKI0&ab_channel=CodeHelp-byBabbar
//  best explanation: https://www.youtube.com/watch?v=CsGP_s_3GWg&ab_channel=Jenny%27slecturesCS%2FITNET%26JRF
//  code explanation: https://www.youtube.com/watch?v=2rjZH0-2lhk&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=26&ab_channel=takeUforward
public class _12BridgesInGraph {

  //  code walk through: https://youtu.be/CiDPT1xMKI0?t=1378
  //  TC: O (N + E)
  //  SC: O (N)
  private static void printBridges(List<List<Integer>> adjList, int N) {
    boolean[] visited = new boolean[N];
    int[] discoveryArr = new int[N];  //  time of insertion
    int[] lowTimeOfDiscoveryArr = new int[N]; //  low time of insertion / either it'll be got from it parent or any other adjacent neighbour nodes
    int[] timer = {0};  //  passing timer by reference
    for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        dfs(i, -1, adjList, discoveryArr, lowTimeOfDiscoveryArr, visited, timer);
      }
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
    discoveryArr[node] = lowTimeOfDiscoveryArr[node] = ++timer[0];  //  same
    for (int nbr : adjList.get(node)) {
      //  don't consider the parent
      if (nbr == parent) {
        continue;
      }
      if (!visited[nbr]) {
        dfs(nbr, node, adjList, discoveryArr, lowTimeOfDiscoveryArr, visited, timer);
        //  https://youtu.be/CiDPT1xMKI0?t=600
        lowTimeOfDiscoveryArr[node] = Math.min(lowTimeOfDiscoveryArr[node],
            lowTimeOfDiscoveryArr[nbr]);
        //  it is definitely a bridge, when lowest time of insertion(from the node where it came back) is greater than the time of insertion of node
        if (lowTimeOfDiscoveryArr[nbr] > discoveryArr[node]) {
          System.out.println(nbr + " <-----> " + node);
        }
      }
      //  it's a back edge - that connects visited nbr, and it is not a parent
      //  https://youtu.be/CiDPT1xMKI0?t=435
      else {
        //  https://youtu.be/2rjZH0-2lhk?list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&t=249
        //  https://youtu.be/2rjZH0-2lhk?list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&t=1097
        //  https://youtu.be/3t3JHswP7mw?list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&t=210
        lowTimeOfDiscoveryArr[node] = Math.min(lowTimeOfDiscoveryArr[node], discoveryArr[nbr]);
      }
    }
  }

  public static void main(String[] args) {
    int N = 12;
    List<List<Integer>> adjList = new ArrayList<>();
    //  graph vertices from 1 ... 12
    for (int i = 0; i < N + 1; i++) {
      adjList.add(new ArrayList<>());
    }
    //  graph diagram @ https://youtu.be/2rjZH0-2lhk?list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&t=814
    adjList.get(1).add(2);
    adjList.get(2).add(1);

    adjList.get(1).add(4);
    adjList.get(4).add(1);

    adjList.get(2).add(3);
    adjList.get(3).add(2);

    adjList.get(3).add(4);
    adjList.get(4).add(3);

    adjList.get(4).add(5);
    adjList.get(5).add(4);

    adjList.get(5).add(6);
    adjList.get(6).add(5);

    adjList.get(6).add(7);
    adjList.get(7).add(6);

    adjList.get(6).add(9);
    adjList.get(9).add(6);

    adjList.get(7).add(8);
    adjList.get(8).add(7);

    adjList.get(9).add(8);
    adjList.get(8).add(9);

    adjList.get(8).add(10);
    adjList.get(10).add(8);

    adjList.get(10).add(11);
    adjList.get(11).add(10);

    adjList.get(10).add(12);
    adjList.get(12).add(10);

    adjList.get(11).add(12);
    adjList.get(12).add(11);

    /*
    * yup: bridges are:
      10 <-----> 8
      6 <-----> 5
      5 <-----> 4
    * * */
    System.out.println("yup: bridges are: ");
    printBridges(adjList, N + 1);
  }
}
