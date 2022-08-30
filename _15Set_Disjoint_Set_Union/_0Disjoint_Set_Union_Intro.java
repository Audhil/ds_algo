package _15Set_Disjoint_Set_Union;

//  https://www.youtube.com/watch?v=9Sq1dL1okJg&list=PLNxqWc8Uj2LRONaT3wI7ikm7tedXKu7W2
//  notes @ https://photos.google.com/photo/AF1QipMpATDyEj8W8wIxIdaKhZ4Y8YYtI8S2py6Xhzh3
//  https://photos.google.com/photo/AF1QipNwsePbHuPdBGLyqsnLfD2BzMVSUxx3AVLFi31U

//  https://youtu.be/ayW5B2W9hfo?t=300 - TC: O (log n) - height of binary tree(why it is O (log n)), traversing at most 2 times in DSU; SC: O (n)

//  TC: O (1) - R/W
public class _0Disjoint_Set_Union_Intro {

  private static int[] parent;
  private static int[] rank;

  private static void makeSet(int n) {
    parent = new int[n];
    rank = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;  //  initially each set is parent to itself - 0,1,2,3,4 .... n
      rank[i] = 0;    //  initially rank is 0 for all sets
    }
  }

  //  constructing this way, will make O(n) for searching/querying
  private static int findSet(int u, int[] parent) {
    if (u
        == parent[u]) //  each set is parent to itself - on reaching that set, we return the parent
    {
      return u;
    }
    return findSet(parent[u], parent);
  }

  //  constructing this way, will make O(1) for searching/querying
  private static int findSetOptimized(int u, int[] parent) {
    if (u == parent[u]) {
      return u;
    }
    return parent[u] = findSetOptimized(parent[u], parent); //  path compression
  }

  //  constructing this way(not bothering about ranks) will make try to grow more and make O(n) for searching
  private static void union(int u, int v, int[] parent) {
    int setU = findSetOptimized(u, parent);
    int setV = findSetOptimized(v, parent);
    //  if both belongs to different parents
    if (setU != setV) {
      parent[setU] = setV;    //  making setV's(parent) as parent to setU or either way is okay
    }
  }

  //  always union lower rank item with bigger rank items
  private static void unionOptimized(int u, int v, int[] parent, int[] rank) {
    int setU = findSetOptimized(u, parent);
    int setV = findSetOptimized(v, parent);
    if (setU != setV) {
      if (rank[setU] == rank[setV]) {   //  checking ranks
        parent[setU] = setV;    //  or parent[setV] = setU;
        rank[setV]++;
      } else if (rank[setU] > rank[setV]) {
        parent[setV] = setU;
        rank[setU] += rank[setV];
      } else {
        parent[setU] = setV;
        rank[setV] += rank[setU];
      }
    }
  }
}
