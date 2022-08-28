package _15Set_Disjoint_Set_Union;

//  https://youtu.be/eTaWFhPXPz4?t=859
public class _1DetectCycleInUnDirectedGraph {

  //  KIM: TIP: we cannot find cycle in directed graph with DSU - https://youtu.be/eTaWFhPXPz4?t=1241

  //  https://youtu.be/eTaWFhPXPz4?t=1247
  //  TC: O (E * V) - process all edges * find/union worst case in skewed tree

  //  https://youtu.be/eTaWFhPXPz4?t=1191
  private static boolean isCyclePresent(int[][] edges) {
    DSU dsu = new DSU(4); //  0, 1, 2, 3
    for (int[] edge : edges) {
      int fromP = dsu.find(edge[0]);
      int toP = dsu.find(edge[1]);

      //  if both nodes, belong to same set, then it has the cycle
      if (fromP == toP) {
        return true;
      }
      dsu.union(fromP, toP);
    }
    return false;
  }

  private static class DSU {

    private final int[] parent;
    private final int[] rank;

    public DSU(int noOfVertices) {
      parent = new int[noOfVertices];
      rank = new int[noOfVertices];
      for (int i = 0; i < noOfVertices; i++) {
        parent[i] = i;  //  parent each node is itself
        rank[i] = 0;  //  initially rank is 0
      }
    }

    //  refer: _0Disjoint_Set_Union_Intro.java
    //  kim: returns parent of the set!
    public int find(int x) {
      if (parent[x] == x) {
        return x;
      }
      return parent[x] = find(parent[x]);
    }

    //  refer: _0Disjoint_Set_Union_Intro.java
    public void union(int x, int y) {
      int setOfx = find(x);
      int setOfy = find(y);
      if (setOfx != setOfy) {
        if (rank[setOfx] == rank[setOfy]) {
          parent[setOfx] = setOfy;
          rank[setOfy] += rank[setOfx];
        } else if (rank[setOfx] > rank[setOfy]) {
          parent[setOfy] = setOfx;
        } else {
          parent[setOfx] = setOfy;
        }
      }
    }
  }

  public static void main(String[] args) {
    System.out.println("yup: is cycle present in the graph: " + isCyclePresent(
        new int[][]{{0, 1}, {0, 3}, {2, 3}, {1, 2}}));  //  yup: is cycle present in the graph: true
  }
}
