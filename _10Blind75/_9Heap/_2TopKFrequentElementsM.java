package _10Blind75._9Heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//  tip create a min heap and add objects
public class _2TopKFrequentElementsM {

  private static class Num implements Comparator<Num> {

    int num, freq;

    public Num() {
    }

    public Num(int num, int freq) {
      this.num = num;
      this.freq = freq;
    }

    @Override
    public int compare(Num o1, Num o2) {
      if (o1.freq == o2.freq) {
        return 0;
      } else if (o1.freq > o2.freq) {
        return 1;
      }
      return -1;
    }
  }


  public static int[] topKFrequent(int[] nums, int k) {
    PriorityQueue<Num> pQueue = new PriorityQueue<>(new Num());
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }
    for (int key : map.keySet()) {
      pQueue.add(new Num(key, map.get(key)));
      if (pQueue.size() > k) {
        pQueue.remove();
      }
    }
    int[] res = new int[pQueue.size()];
    int i = 0;
    while (pQueue.size() > 0) {
      res[i++] = pQueue.poll().num;
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: topKFrequent: " + Arrays.toString(
            topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2))); //  yup: topKFrequent: [2, 1]
  }
}
