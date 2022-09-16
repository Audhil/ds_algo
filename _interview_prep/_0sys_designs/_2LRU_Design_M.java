package _interview_prep._0sys_designs;

import java.util.HashMap;
import java.util.Map;

//  https://leetcode.com/problems/lru-cache/
//  https://www.youtube.com/watch?v=7ABFKPK2hD4&ab_channel=NeetCode
public class _2LRU_Design_M {

  private static class Node {

    int key, value;
    Node prev, next;

    public Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private static class LRUCache {

    private final int capacity;
    private final Map<Integer, Node> cMap;

    //  dummy nodes for ease operations
    private final Node left, right;

    //  helper funcs
    private void addNodeFunc(Node node) {
      Node prv = right.prev;
      Node nxt = right;
      //  link 1
      prv.next = node;
      node.prev = prv;
      //  link 2
      node.next = nxt;
      nxt.prev = node;
    }

    private void removeNodeFunc(Node node) {
      Node prv = node.prev;
      Node nxt = node.next;
      prv.next = nxt;
      nxt.prev = prv;
    }

    public LRUCache(int capacity) {
      this.capacity = capacity;
      cMap = new HashMap<>();
      left = new Node(0, 0);
      right = new Node(0, 0);
      left.next = right;
      right.prev = left;
    }

    public int get(int key) {
      if (cMap.containsKey(key)) {
        //  remove and add node, in order to update LRU order
        removeNodeFunc(cMap.get(key));
        addNodeFunc(cMap.get(key));
        return cMap.get(key).value;
      }
      return -1;
    }

    public void put(int key, int value) {
      if (cMap.containsKey(key)) {
        removeNodeFunc(cMap.get(key));
      }
      Node node = new Node(key, value);
      cMap.put(key, node);
      addNodeFunc(cMap.get(key));

      //  check for size
      if (cMap.size() > capacity) {
        Node lru = left.next;
        removeNodeFunc(lru);
        cMap.remove(lru.key);
      }
    }
  }

  public static void main(String[] args) {
    LRUCache lruCache = new LRUCache(2);
    lruCache.put(1, 1);
    lruCache.put(2, 2);
    System.out.println("yup: get the value: " + lruCache.get(1)); //  1
    lruCache.put(3, 3);
    System.out.println("yup: get the value: " + lruCache.get(2)); //  -1
    lruCache.put(4, 4);
    System.out.println("yup: get the value: " + lruCache.get(1)); //  -1
    System.out.println("yup: get the value: " + lruCache.get(3)); //  3
    System.out.println("yup: get the value: " + lruCache.get(4)); //  4
  }
}
