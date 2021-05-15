package _4Heap;

//  https://youtu.be/hW8PrQrvMNc?list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9
public class _0Intro {
    /*
    * 1. k - is the size of heap
        2. smallest / largest
        (k + smallest/lowest/closest -> create maxHeap)
        (k + largest/greatest/top -> create minHeap)
        3. sorting - (max improvement can be O (n log n) - which is done by Merge sort)
        converts to O (n log k) - sorting in heap
    * */

    //  MaxHeap
//    PriorityQueue<Integer> maxHeap;

//    MinHeap
//    PriorityQueue<Integer, Pair<Integer, Integer>, greater<Integer>> minHeap;

    /*
    * for ref:
    *
        class Solution {
            public int findKthLargest(int[] nums, int k) {
                if(k<=nums.length/2)  return minHeap(nums,k);
                else return maxHeap(nums,nums.length+1-k);
            }
            private int maxHeap(int[] nums,int k){
            //To find kth smallest element
                PriorityQueue<Integer> pq=new PriorityQueue<Integer>((a,b)->b-a);
                //PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
                for(int num : nums){
                    pq.add(num);
                    if(pq.size()>k) pq.remove();
                }
                return pq.peek();
            }
            private int minHeap(int[] nums,int k){
            //To find kth largest
                PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
                for(int num : nums){
                    pq.add(num);
                    if(pq.size()>k) pq.remove();
                }
                return pq.peek();
            }
        }
    * */
}
