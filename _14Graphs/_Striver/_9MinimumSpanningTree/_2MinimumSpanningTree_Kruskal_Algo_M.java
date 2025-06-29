package _14Graphs._Striver._9MinimumSpanningTree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//  using DSU
//  https://www.youtube.com/watch?v=1KRmCzBl_mQ&list=PLgUwDviBIf0rGEWe64KWas0Nryn7SCRWw&index=25&ab_channel=takeUforward
public class _2MinimumSpanningTree_Kruskal_Algo_M {

  //  TC: O (n log n) -> due to sorting
  //  SC: O (N)

  private static class Node {

    int u, v, weight;

    public Node(int u, int v, int weight) {
      this.u = u;
      this.v = v;
      this.weight = weight;
    }

    @Override
    public String toString() {
      return "Node{" +
          "u=" + u +
          ", v=" + v +
          ", weight=" + weight +
          '}';
    }
  }

  private static void kruskalAlgo_MinSpanningTree(List<Node> adjList, int n) {
    int[] parent = new int[n];
    int[] rank = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }
    //  TC: O (n log n)
    adjList.sort(Comparator.comparingInt(o -> o.weight));
    List<Node> mstList = new ArrayList<>();
    int mstCost = 0;
    for (Node node : adjList) {
      if (find(node.u, parent) != find(node.v, parent)) {
        mstList.add(node);
        mstCost += node.weight;
        union(node.u, node.v, parent, rank);
      }
    }
    System.out.println("yup: mstCost: " + mstCost);
    System.out.println("yup: mstList: " + mstList);
  }

  private static void union(int u, int v, int[] parent, int[] rank) {
    int setOfU = find(u, parent);
    int setOfV = find(v, parent);
    if (setOfV != setOfU) {
      if (rank[setOfU] > rank[setOfV]) {
        parent[setOfV] = setOfU;
        rank[setOfU] += rank[setOfV];
      } else {
        parent[setOfU] = setOfV;
        rank[setOfV] += rank[setOfU];
      }
    }
  }

  private static int findWithIteration(int vertex, int[] parent) {
    while (parent[vertex] != vertex) {
      vertex = parent[vertex];
    }
    return vertex;
  }

  private static int find(int vertex, int[] parent) {
    if (parent[vertex] == vertex) {
      return vertex;
    }
    return parent[vertex] = find(parent[vertex], parent);
  }

  public static void main(String[] args) {
    int n = 5;
    List<Node> adjList = new ArrayList<>();

    adjList.add(new Node(0, 1, 2));
    adjList.add(new Node(0, 3, 6));
    adjList.add(new Node(1, 3, 8));
    adjList.add(new Node(1, 2, 3));
    adjList.add(new Node(1, 4, 5));
    adjList.add(new Node(2, 4, 7));

    /*
    * yup: mstCost: 16
      yup: mstList: [Node{u=0, v=1, weight=2}, Node{u=1, v=2, weight=3}, Node{u=1, v=4, weight=5}, Node{u=0, v=3, weight=6}]
    * * */
    kruskalAlgo_MinSpanningTree(adjList, n);
  }
}