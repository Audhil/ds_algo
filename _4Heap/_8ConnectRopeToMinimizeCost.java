package _4Heap;

import java.util.PriorityQueue;

//  https://youtu.be/_k_c9nqzKN0?list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9
public class _8ConnectRopeToMinimizeCost {

    //  ref img @ https://photos.google.com/photo/AF1QipOUQ29_x3ZHCCpYZ_wdD_to4_h--sqrB4dgW199

    //  tip point: at any time, choose min cost rope to tie with other

    private int[] arr = {1, 2, 3, 4, 5};    //  length of ropes

    private int minCostOnJoiningRope() {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++)
            minHeap.add(arr[i]);
        int cost = 0;
        while (minHeap.size() >= 2) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            cost += first + second;
            minHeap.add(first + second);
        }
        return cost;
    }

    public static void main(String[] args) {
        _8ConnectRopeToMinimizeCost prob = new _8ConnectRopeToMinimizeCost();
        System.out.println("yup: min :" + prob.minCostOnJoiningRope());
    }
}
