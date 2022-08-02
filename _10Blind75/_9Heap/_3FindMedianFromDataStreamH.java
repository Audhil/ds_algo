package _10Blind75._9Heap;

import java.util.PriorityQueue;

//  https://leetcode.com/problems/find-median-from-data-stream/
//  https://www.youtube.com/watch?v=itmhHWaHupI&ab_channel=NeetCode
public class _3FindMedianFromDataStreamH {

  //  median : 1,2,3 -> 2 (if the given odd number of elements)
  //  median : 1,2,3,4 -> (2 + 3)/2 = 2.5 (if the given even number of elements)
  /*  tip: 1. use maxHeap to store small elements
      tip: 2. use minHeap to store larger elements
      tip: 3. a. always (no of elements in small elements heap) - (no of elements in large elements heap) <= 1
              b. always elements in smaller element heap is smaller than larger element heap
      tip: 4. let us add items in smaller element heap always and check for the tip:3
      tip: 5. always find median with (larger element from small heap) and (smaller element from large heap).
   */
  private static class MedianFinder {

    private final PriorityQueue<Integer> smallerItemsHeap; //  maxHeap
    private final PriorityQueue<Integer> largerItemsHeap;  //  minHeap

    public MedianFinder() {
      smallerItemsHeap = new PriorityQueue<>((a, b) -> b - a);
      largerItemsHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
      //Pushing
      if (smallerItemsHeap.isEmpty() || (smallerItemsHeap.peek() > num)) {
        smallerItemsHeap.add(num);
      } else {
        largerItemsHeap.add(num);
      }

      //Balancing
      if (smallerItemsHeap.size() > largerItemsHeap.size() + 1) {
        largerItemsHeap.add(smallerItemsHeap.peek());
        smallerItemsHeap.poll();
      } else if (largerItemsHeap.size() > smallerItemsHeap.size() + 1) {
        smallerItemsHeap.add(largerItemsHeap.peek());
        largerItemsHeap.poll();
      }

    }

    public double findMedian() {
      // Even Number
      if (!smallerItemsHeap.isEmpty()
          && !largerItemsHeap.isEmpty()
          && smallerItemsHeap.size() == largerItemsHeap.size()) {
        return (smallerItemsHeap.peek() + largerItemsHeap.peek()) / 2.0;
      }
      // Odd Number
      else {
        if (smallerItemsHeap.isEmpty() || largerItemsHeap.isEmpty()) {
          return 0.0;
        }
        if (smallerItemsHeap.size() > largerItemsHeap.size()) {
          return smallerItemsHeap.peek() + 0.0;
        } else { // minHeap.size() > maxHeap.size()
          return largerItemsHeap.peek() + 0.0;
        }
      }
    }
  }

  public static void main(String[] args) {
    MedianFinder medianFinder = new MedianFinder();
    System.out.println("yup: median: " + medianFinder.findMedian());  //  yup: median: 0.0
    medianFinder.addNum(1);
    medianFinder.addNum(2);
    System.out.println("yup: median: " + medianFinder.findMedian());  //  yup: median: 1.5
    medianFinder.addNum(3);
    System.out.println("yup: median: " + medianFinder.findMedian());  //  yup: median: 2.0
  }
}
