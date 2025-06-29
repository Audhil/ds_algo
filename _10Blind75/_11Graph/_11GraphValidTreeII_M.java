package _10Blind75._11Graph;

import java.util.HashMap;
import java.util.Map;

//  https://www.lintcode.com/problem/444/
public class _11GraphValidTreeII_M {


  private int edgeNum = 0;
  private final UnionFind uf = new UnionFind();

  /**
   * @param a: the node a
   * @param b: the node b
   * @return: nothing
   */
  public void addEdge(int a, int b) {
    edgeNum++;
    if (!uf.containsPoint(a)) {
      uf.init(a);
    }
    if (!uf.containsPoint(b)) {
      uf.init(b);
    }
    uf.connect(a, b);
  }

  /**
   * @return: check whether these edges make up a valid tree
   */
  public boolean isValidTree() {
    return uf.size == 1 && edgeNum + 1 == uf.pointNum();
  }

  class UnionFind {

    Map<Integer, Integer> faMap = new HashMap<>();
    int size = 0;

    public boolean containsPoint(int a) {
      return faMap.containsKey(a);
    }

    public void init(int a) {
      faMap.put(a, a);
      size++;
    }

    private int find(int a) {
      if (faMap.get(a) == a) {
        return a;
      }
      int root = a;
      while (faMap.get(root) != root) {
        root = faMap.get(root);
      }

      while (a != root) {
        int tmp = faMap.get(a);
        faMap.put(a, root);
        a = tmp;
      }
      return root;
    }

    public void connect(int a, int b) {
      int rootA = find(a);
      int rootB = find(b);
      if (rootA != rootB) {
        faMap.put(rootA, rootB);
        size--;
      }
    }

    public int pointNum() {
      return faMap.size();
    }
  }
}
