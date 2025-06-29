package _10Blind75._11Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//  https://leetcode.com/problems/clone-graph/
public class _0CloneGraphM {

  private static class Node {

    public int val;
    public List<Node> neighbors;

    public Node() {
      val = 0;
      neighbors = new ArrayList<>();
    }

    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }

  //  using BFS
  /*
  * sample code:
  * class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        if not node: return node

        q, clones = deque([node]), {node.val: Node(node.val, [])}
        while q:
            cur = q.popleft()
            cur_clone = clones[cur.val]

            for ngbr in cur.neighbors:
                if ngbr.val not in clones:
                    clones[ngbr.val] = Node(ngbr.val, [])
                    q.append(ngbr)

                cur_clone.neighbors.append(clones[ngbr.val])

        return clones[node.val]
        * * * */


  private static Node cloneGraph_BFS_revision(Node node) {
    if (node == null) {
      return null;
    }
    Map<Integer, Node> cMap = new HashMap<>();
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);
    cMap.put(node.val, new Node(node.val));
    while (!queue.isEmpty()) {
      Node temp = queue.poll();
      Node currClone = cMap.get(temp.val);
      for (Node nei : temp.neighbors) {
        if (!cMap.containsKey(nei.val)) {
          cMap.put(nei.val, new Node(nei.val));
          queue.add(nei);
        }
        currClone.neighbors.add(cMap.get(nei.val));
      }
    }
    return cMap.get(node.val);
  }


  private static Node cloneGraph_BFS(Node node) {
    if (node == null) {
      return null;
    }
    Map<Integer, Node> map = new HashMap<>();
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);
    map.put(node.val, new Node(node.val));
    while (!queue.isEmpty()) {
      Node temp = queue.poll();
      Node currClone = map.get(temp.val);
      for (Node nei : temp.neighbors) {
        if (!map.containsKey(nei.val)) {
          map.put(nei.val, new Node(nei.val));
          queue.add(nei);
        }
        currClone.neighbors.add(map.get(nei.val));
      }
    }
    return map.get(node.val);
  }

  //  using DFS
  public static Node cloneGraph(Node node) {
    Map<Node, Node> oldToNewMap = new HashMap<>();
    return dfs(node, oldToNewMap);
  }

  private static Node dfs(Node node, Map<Node, Node> oldToNewMap) {
    if (node == null) {
      return null;
    }
    if (oldToNewMap.containsKey(node)) {
      return oldToNewMap.get(node);
    }
    Node copy = new Node(node.val);
    oldToNewMap.put(node, copy);
    for (Node nei : node.neighbors) {
      copy.neighbors.add(dfs(nei, oldToNewMap));
    }
    return copy;
  }

  private static void printWithDFS(Node node, boolean[] visited) {
    visited[node.val] = true;
    System.out.print(node.val + " ");
    for (Node nei : node.neighbors) {
      if (!visited[nei.val]) {
        printWithDFS(nei, visited);
      }
    }
  }

  public static void main(String[] args) {
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);
    n1.neighbors.add(n2);
    n1.neighbors.add(n4);

    n2.neighbors.add(n1);
    n2.neighbors.add(n3);

    n3.neighbors.add(n2);
    n3.neighbors.add(n4);

    n4.neighbors.add(n1);
    n4.neighbors.add(n3);

    System.out.println("yup: original graph: ");
    printWithDFS(n1, new boolean[5]); //  1 2 3 4
    System.out.println("\nyup: cloned graph: ");
//    Node clone = cloneGraph(n1);
    Node clone = cloneGraph_BFS(n1);
    printWithDFS(clone, new boolean[5]);  //  1 2 3 4
  }
}
