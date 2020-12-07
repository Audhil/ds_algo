package _4Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

//  https://youtu.be/J8yLD-x7fBI?list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9
public class _4KClosestNumbers {

    private int[] arr = {5, 6, 7, 8, 9};
    private int k = 3;
    private int x = 7;

    private static class Pair implements Comparator<Pair> {

        int key, value;

        public Pair() {
        }

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compare(Pair o1, Pair o2) {
            if (o1.key == o2.key)
                return 0;   //  don't change the order
            else if (o1.key < o2.key)
                return 1;   //  change the order
            return -1;  //  don't change the order
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private void printClosestNumbers() {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(new Pair());
        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(new Pair(Math.abs(arr[i] - x), arr[i]));
            if (maxHeap.size() > k)
                maxHeap.poll();
        }

        while (!maxHeap.isEmpty()) {
            System.out.println(maxHeap.poll());
        }
    }

    public static void main(String[] args) {
        _4KClosestNumbers prob = new _4KClosestNumbers();
        prob.printClosestNumbers();
    }
}
