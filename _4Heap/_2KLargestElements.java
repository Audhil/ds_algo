package _4Heap;

import java.util.PriorityQueue;

//  https://youtu.be/3DdP6Ef8YZM?list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9
public class _2KLargestElements {

    private int[] arr = {7, 10, 4, 3, 20, 15};  //  3,4,7,10,15,20
    private int k = 3;

    //  not works
    private void printKLargestElements() {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
            if (minHeap.size() > k)
                minHeap.remove();
        }
        while (!minHeap.isEmpty()) {
            System.out.println("yup: max element: " + minHeap.poll());
        }
    }

    public static void main(String[] args) {
        _2KLargestElements prob = new _2KLargestElements();
        prob.printKLargestElements();
    }
}
