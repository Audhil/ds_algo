package _4Heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//  https://youtu.be/hLR5aMzYGGk?list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9
public class _6FrequencySort {

    private int[] arr = {1, 1, 1, 3, 2, 2, 4};  //  o/p should be based on frequency 1,1,1,2,2,3,4

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
            else if (o1.frequency < o2.frequency)
                return 1;   //  change the order
            return -1;  //  don't change the order
        }
    }

    private void solveFreqSort() {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == null)
                map.put(arr[i], 1);
            else
                map.put(arr[i], map.get(arr[i]) + 1);
        }
//        System.out.println("yup: map is : " + map);
        PriorityQueue<ItemWithFrequency> maxHeap = new PriorityQueue<>(new ItemWithFrequency());
        map.keySet().forEach(key -> {
            maxHeap.add(new ItemWithFrequency(map.get(key), key));
        });
        while (!maxHeap.isEmpty()) {
//            System.out.println("yup: sorted items are: " + maxHeap.poll().item);
            ItemWithFrequency item = maxHeap.poll();
            for (int i = 0; i < item.frequency; i++) {
                System.out.println(item.item);
            }
        }
    }

    public static void main(String[] args) {
        _6FrequencySort prob = new _6FrequencySort();
        prob.solveFreqSort();
    }
}
