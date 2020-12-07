package _4Heap;

import java.util.Collections;
import java.util.PriorityQueue;

//  https://youtu.be/4BfL2Hjvh8g?list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9
public class _1KthSmallestElement {
    //  find kth smallest element in the array

    private int[] arr = {7, 10, 4, 3, 20, 15};  //  3,4,7,10,15,20
    private int k = 3;

    //  not works
    private int kthSmallestElement() {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(arr[i]);
            System.out.println("yup: maxHeap: " + maxHeap);
            if (maxHeap.size() > k)
                maxHeap.remove();
            System.out.println("yup: after maxHeap: " + maxHeap);
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        _1KthSmallestElement prob = new _1KthSmallestElement();
        System.out.println("yup: kth smallest element: " + prob.kthSmallestElement());
    }
}
