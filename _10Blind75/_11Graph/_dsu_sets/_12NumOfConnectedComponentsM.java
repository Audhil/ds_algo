package _10Blind75._11Graph._dsu_sets;

//  https://www.youtube.com/watch?v=8f1XPm4WOUc&ab_channel=NeetCode
public class _12NumOfConnectedComponentsM {

  //  https://youtu.be/ayW5B2W9hfo?t=300 - TC: O (log n) - height of binary tree(why it is O (log n)), traversing at most 2 times in DSU; SC: O (n)
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

    //  kim: returns parent of the set!
    public int find(int x) {
      if (parent[x] == x) {
        return x;
      }
      return parent[x] = find(parent[x]);
    }

    public int union(int x, int y) {
      int setOfx = find(x);
      int setOfy = find(y);
      //  both belong to same set, has the same parent
      if (setOfx == setOfy) {
        return 0;
      }
      //  setOfx != setOfy
      if (rank[setOfx] == rank[setOfy]) {
        parent[setOfx] = setOfy;
        rank[setOfy] += rank[setOfx];
      } else if (rank[setOfx] > rank[setOfy]) {
        parent[setOfy] = setOfx;
        rank[setOfx] += rank[setOfy];
      } else {
        parent[setOfx] = setOfy;
        rank[setOfy] += rank[setOfx];
      }
      return 1;
    }
  }

  private static int numOfConnectedComponents(int n, int[][] edges) {
    int res = n;
    DSU dsu = new DSU(n);
    for (int[] edge : edges) {
      res -= dsu.union(edge[0], edge[1]);
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println("yup: num of connected components: " + numOfConnectedComponents(5,
        new int[][]{{0, 1}, {1, 2}, {3, 4}}));  //  2
  }
}
