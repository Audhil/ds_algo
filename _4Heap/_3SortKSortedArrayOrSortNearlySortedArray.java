package _4Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//  https://youtu.be/dYfM6J1y0mU?list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9
public class _3SortKSortedArrayOrSortNearlySortedArray {

    private int[] arr = {6, 5, 3, 2, 8, 10, 9};  //  2,3,5,6,8,9,10
    private int k = 3;

    //  complexity will be O (n log k)

    private List<Integer> sortByMinHeap() {
        List<Integer> sortedList = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
            if (minHeap.size() > k)
                sortedList.add(minHeap.poll());
        }
        //  add remaining items from heap
        while (!minHeap.isEmpty()) {
            sortedList.add(minHeap.poll());
        }
        return sortedList;
    }

    public static void main(String[] args) {
        _3SortKSortedArrayOrSortNearlySortedArray prob = new _3SortKSortedArrayOrSortNearlySortedArray();
        System.out.println("yup: sorted array is : " + prob.sortByMinHeap());
    }
}
