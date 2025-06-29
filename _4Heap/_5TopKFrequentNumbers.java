package _4Heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Consumer;

//  https://youtu.be/7VoJn544QrM?list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9
public class _5TopKFrequentNumbers {

    //  find top k frequent nums

    private int[] arr = {1, 1, 1, 3, 2, 2, 4};
    private int k = 2;

    private static class ItemWithFrequency implements Comparator<ItemWithFrequency> {

        int frequency = 0, item = 0;

        public ItemWithFrequency() {
        }

        public ItemWithFrequency(int frequency_key, int item) {
            this.frequency = frequency_key;
            this.item = item;
        }

        @Override
        public String toString() {
            return "ItemWithFrequency{" +
                    "item=" + item +
                    ",frequency=" + frequency +
                    '}';
        }

        @Override
        public int compare(ItemWithFrequency o1, ItemWithFrequency o2) {
            if (o1.frequency == o2.frequency)
                return 0;   //  don't change the order
            else if (o1.frequency > o2.frequency)
                return 1;   //  change the order
            return -1;  //  don't change the order
        }
    }

    private void solveTopKFrequentNums() {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == null)
                map.put(arr[i], 1);
            else
                map.put(arr[i], map.get(arr[i]) + 1);
        }
//        System.out.println("yup: map is : " + map);
        PriorityQueue<ItemWithFrequency> minHeap = new PriorityQueue<>(new ItemWithFrequency());
        map.keySet().forEach(key -> {
            minHeap.add(new ItemWithFrequency(map.get(key), key));
//            System.out.println("yup: minHeap: " + minHeap);
            if (minHeap.size() > k)
                minHeap.poll();
//            System.out.println("yup: after minHeap: " + minHeap);
        });
        while (!minHeap.isEmpty()) {
            System.out.println("yup: top K freq nums: " + minHeap.poll());
        }
    }

    public static void main(String[] args) {
        _5TopKFrequentNumbers prob = new _5TopKFrequentNumbers();
        prob.solveTopKFrequentNums();
    }
}
