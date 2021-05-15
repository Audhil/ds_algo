package _4Heap;

import java.util.PriorityQueue;

//  https://youtu.be/3ioQQQrnw4Q?list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9
public class _9SumOfElementsBetweenK1SmallestAndK2Smallest {

    private int[] arr = {1, 3, 12, 5, 15, 11};
    private int k1 = 3;
    private int k2 = 6;

    private int kthSmallestElement(int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(arr[i]);
            if (maxHeap.size() > k)
                maxHeap.poll();
        }
        System.out.println(maxHeap);
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        _9SumOfElementsBetweenK1SmallestAndK2Smallest prob = new _9SumOfElementsBetweenK1SmallestAndK2Smallest();
        int index1 = prob.kthSmallestElement(prob.k1);
        int index2 = prob.kthSmallestElement(prob.k2);

        System.out.println("yup: index1:" + index1);
        System.out.println("yup: index2:" + index2);

        int sum = 0;
        for (int i = 0; i < prob.arr.length; i++) {
            if (prob.arr[i] > index1 && prob.arr[i] < index2)
                sum += prob.arr[i];
        }
        System.out.println("yup: sum is : " + sum);

    }
}
