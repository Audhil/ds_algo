package _14Graphs;

import java.util.ArrayList;
import java.util.List;

//  https://www.youtube.com/watch?v=xsM8i0jVF1w&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=19&ab_channel=takeUforward
/*
 * Graph with N nodes
 * we can make a "min spanning tree" with N nodes, and N-1 edges, with minimum sum of edges weights
 *
 * we can find with
 *   * Prim's - https://www.youtube.com/watch?v=HnD676J56ak&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=19&ab_channel=takeUforward,
 *   * Kruskal's algorithm
 * * */
public class _6MinimumSpanningTree_Prims_Algo_M {

  private static class Node {

    int vertex;
    int weight;

    public Node(int vertex, int weight) {
      this.vertex = vertex;
      this.weight = weight;
    }
  }

  private static void revision(List<List<Node>> adjList, int N) {
    int[] keyArr = new int[N];
    boolean[] mstArr = new boolean[N];
    int[] parentArr = new int[N];

    for (int i = 0; i < N; i++) {
      parentArr[i] = -1;
      keyArr[i] = Integer.MAX_VALUE;
    }

    keyArr[0] = 0;

    for (int i = 0; i < N - 1; i++) {
      int min = Integer.MAX_VALUE, u = 0;
      for (int j = 0; j < N; j++) {
        if (!mstArr[j] && keyArr[j] < min) {
          min = keyArr[j];
          u = j;
        }
      }
      mstArr[u] = true;
      for (Node nei : adjList.get(u)) {
        if (!mstArr[nei.vertex] && nei.weight < keyArr[nei.vertex]) {
          keyArr[nei.vertex] = nei.weight;
          parentArr[nei.vertex] = u;
        }
      }
    }
    //  print mst
    System.out.println("yup: print MST with Prim's algo: ");
    for (int i = 1; i < N; i++) {
      System.out.println(parentArr[i] + " -> " + i);
    }
  }

  //  TC: O (N^2)
  //  brute-force approach
  //  https://www.youtube.com/watch?v=8KPEROaLK-0&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=22&ab_channel=takeUforward
  private static void primsAlgo_MinSpanningTree(List<List<Node>> adjList, int N) {
    int[] keyArr = new int[N];  //  will store the min weight of the nodes
    boolean[] mstArr = new boolean[N];
    int[] parentArr = new int[N];

    //  TC: O (N)
    for (int i = 0; i < N; i++) {
      keyArr[i] = Integer.MAX_VALUE;  //  add infinity
      parentArr[i] = -1;
    }

    keyArr[0] = 0;

    //  TC: O (N^2)
    //  iterate, 1,2, ..... (N - 1) - since we'll have N-1 edges in the MST
    for (int i = 0; i < N - 1; i++) {
      int min = Integer.MAX_VALUE, u = 0;
      //  1. iterate key arr
      for (int j = 0; j < N; j++) {
        if (!mstArr[j] && keyArr[j] < min) {
          min = keyArr[j];
          u = j;
        }
      }
      //  2. mark the mstArr
      mstArr[u] = true;
      //  TC: O (N)
      //  3. update parentArr - always iterate from 1
      for (Node node : adjList.get(u)) {
        if (!mstArr[node.vertex] && node.weight < keyArr[node.vertex]) {
          parentArr[node.vertex] = u;
          keyArr[node.vertex] = node.weight;
        }
      }
    }

    //  print mst
    System.out.println("yup: print MST with Prim's algo: ");
    for (int i = 1; i < N; i++) {
      System.out.println(parentArr[i] + " -> " + i);
    }
  }

  public static void main(String[] args) {
    int n = 5;
    List<List<Node>> adjList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      adjList.add(new ArrayList<>());
    }

    adjList.get(0).add(new Node(1, 2));
    adjList.get(1).add(new Node(0, 2));

    adjList.get(1).add(new Node(2, 3));
    adjList.get(2).add(new Node(1, 3));

    adjList.get(0).add(new Node(3, 6));
    adjList.get(3).add(new Node(0, 6));

    adjList.get(1).add(new Node(3, 8));
    adjList.get(3).add(new Node(1, 8));

    adjList.get(1).add(new Node(4, 5));
    adjList.get(4).add(new Node(1, 5));

    adjList.get(2).add(new Node(4, 7));
    adjList.get(4).add(new Node(2, 7));

    /*
    * 0 -> 1
      1 -> 2
      0 -> 3
      1 -> 4
    * */
    primsAlgo_MinSpanningTree(adjList, n);
  }
}
