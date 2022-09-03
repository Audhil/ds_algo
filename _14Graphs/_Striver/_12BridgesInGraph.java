package _14Graphs._Striver;

import java.util.ArrayList;
import java.util.List;

//  best explanation: https://www.youtube.com/watch?v=CsGP_s_3GWg&ab_channel=Jenny%27slecturesCS%2FITNET%26JRF
//  code explanation: https://www.youtube.com/watch?v=2rjZH0-2lhk&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=26&ab_channel=takeUforward
public class _12BridgesInGraph {

  //  TC: O (N + E)
  //  SC: O (N)
  private static void printBridges(List<List<Integer>> adjList, int N) {
    boolean[] visited = new boolean[N];
    int[] tinArr = new int[N];  //  time of insertion
    int[] lowTinArr = new int[N]; //  low time of insertion / either it'll be got from it parent or any other adjacent neighbour nodes
    int[] timer = {0};  //  passing timer by reference
    for (int i = 0; i < N; i++) {
      if (!visited[i]) {
        dfs(i, -1, adjList, tinArr, lowTinArr, visited, timer);
      }
    }
  }

  private static void dfs(int node,
      int parent,
      List<List<Integer>> adjList,
      int[] tinArr,
      int[] lowTinArr,
      boolean[] visited,
      int[] timer) {
    visited[node] = true;
    tinArr[node] = lowTinArr[node] = ++timer[0];  //  same
    for (int nei : adjList.get(node)) {
      //  don't consider the parent
      if (nei == parent) {
        continue;
      }
      if (!visited[nei]) {
        dfs(nei, node, adjList, tinArr, lowTinArr, visited, timer);
        lowTinArr[node] = Math.min(lowTinArr[node], lowTinArr[nei]);
        //  it is definitely a bridge, when lowest time of insertion is greater than the time of insertion of node
        if (lowTinArr[nei] > tinArr[node]) {
          System.out.println(nei + " <-----> " + node);
        }
      } else {
        lowTinArr[node] = Math.min(lowTinArr[node], tinArr[nei]);
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
