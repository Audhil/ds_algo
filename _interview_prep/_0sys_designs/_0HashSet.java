package _interview_prep._0sys_designs;

import java.util.ArrayList;
import java.util.List;

//  https://leetcode.com/problems/design-hashset/
//  https://www.youtube.com/watch?v=IjxkD8L2cOM&ab_channel=Fraz
public class _0HashSet {

  //  1. simple solution, we can store upto - 1e7(10^7)
  private static class MyHashSet {

    private final int[] setArr;

    public MyHashSet() {
      int size = (int) (Math.pow(10, 6) + 1);
      setArr = new int[size];
    }

    public void add(int key) {
      setArr[key] = 1;
    }

    public void remove(int key) {
      setArr[key] = 0;
    }

    public boolean contains(int key) {
      return setArr[key] == 1;
    }
  }

  //  2. optimized solution
  private static class MyHashSetOptimized {

    private final List<Integer>[] setArr;
    private final int size = 100;

    public MyHashSetOptimized() {
      setArr = (List<Integer>[]) new ArrayList[size];
    }

    private int hash(int key) {
      return key % size;
    }

    private int search(int key) {
      int hash = hash(key);
      List<Integer> tempList = setArr[hash];
      if (tempList == null) {
        return -1;
      }
      for (int i = 0; i < tempList.size(); i++) {
        if (tempList.get(i) == key) {
          return i;
        }
      }
      return -1;
    }

    public void add(int key) {
      if (contains(key)) {
        return;
      }
      int hash = hash(key);
      if (setArr[hash] == null) {
        setArr[hash] = new ArrayList<>();
      }
      setArr[hash].add(key);
    }

    public void remove(int key) {
      int pos = search(key);
      if (pos < 0) {
        return;
      }
      int hash = hash(key);
      setArr[hash].remove(pos);
    }

    public boolean contains(int key) {
      return search(key) >= 0;
    }
  }
}
