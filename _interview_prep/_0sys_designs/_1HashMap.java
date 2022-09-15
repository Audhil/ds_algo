package _interview_prep._0sys_designs;

import java.util.Arrays;

//  https://www.youtube.com/watch?v=xVEGczCJCHs&t=23s&ab_channel=Fraz
public class _1HashMap {

  private static class MyHashMap {

    private final int[] mapArr;
    private final int size = (int) (Math.pow(10, 6) + 1);

    public MyHashMap() {
      mapArr = new int[size];
      Arrays.fill(mapArr, -1);
    }

    public void put(int key, int value) {
      mapArr[key] = value;
    }

    public int get(int key) {
      return mapArr[key];
    }

    public void remove(int key) {
      mapArr[key] = -1;
    }
  }

  //  based on: https://levelup.gitconnected.com/leetcode-706-design-hashmap-march-leetcoding-challenge-2021-fdae1a4adbc
  private static class MyHashMapOptimized {

    private static class ListNode {

      int key, value;
      ListNode next;

      public ListNode(int key, int value) {
        this.key = key;
        this.value = value;
      }
    }

    private int hash(int key) {
      return Integer.hashCode(key) % mapArr.length;  //  another example (key % size)
    }

    private ListNode findItem(int key) {
      int hash = hash(key);
      if (mapArr[hash] == null) {
        return mapArr[hash] = new ListNode(-1,
            -1);  //  it'll be a dummy pointer at the beginning of LL
      }
      ListNode prev = mapArr[hash];
      while (prev.next != null && prev.next.key != key) {
        prev = prev.next;
      }
      return prev;
    }

    private final ListNode[] mapArr;
    private final int size = 1000;

    public MyHashMapOptimized() {
      mapArr = new ListNode[size];
    }

    public void put(int key, int value) {
      ListNode prev = findItem(key);
      if (prev.next == null) {
        prev.next = new ListNode(key, value);
      } else {
        prev.next.value = value;
      }
    }

    public int get(int key) {
      ListNode prev = findItem(key);
      if (prev.next == null) {
        return -1;
      }
      return prev.next.value;
    }

    public void remove(int key) {
      ListNode prev = findItem(key);
      if (prev.next == null) {
        return;
      }
      prev.next = prev.next.next;
    }
  }
}
