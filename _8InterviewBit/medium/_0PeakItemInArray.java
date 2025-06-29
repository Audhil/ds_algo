package _8InterviewBit.medium;

//  https://www.interviewbit.com/old/problems/find-a-peak-element/
/*
*
* Given an array of integers A, find and return the peak element in it.
An array element is peak if it is NOT smaller than its neighbors.
For corner elements, we need to consider only one neighbor.
For example, for input array {5, 10, 20, 15}, 20 is the only peak element.

Following corner cases give better idea about the problem.
*
* 1) If input array is sorted in strictly increasing order, the last element is always a peak element.
For example, 5 is peak element in {1, 2, 3, 4, 5}.
2) If input array is sorted in strictly decreasing order, the first element is always a peak element.
10 is the peak element in {10, 9, 8, 7, 6}.
* */
//  soln based on: https://www.geeksforgeeks.org/find-a-peak-in-a-given-array/
public class _0PeakItemInArray {

    //  O(n)
    private static int solve(int[] A) {
        int len = A.length;
        if (len == 1)
            return A[0];
        if (A[0] > A[1])
            return A[0];
        if (A[len - 1] > A[len - 2])
            return A[len - 1];
        for (int i = 1; i < len - 1; i++) {
            if (A[i] >= A[i - 1] && A[i] >= A[i + 1])
                return A[i];
        }
        return -1;
    }

    //  O(log n)
    private static int solveEfficiently(int[] A, int left, int right) {
        int mid = left + (right - left) / 2;

        //  check mid
        if ((mid == 0 || A[mid] >= A[mid - 1])
                && (mid == A.length - 1 || A[mid] >= A[mid + 1]))
            return A[mid];
            //  if left neighbour is higher
        else if (mid > 0 && A[mid] < A[mid - 1])
            return A[solveEfficiently(A, 0, mid - 1)];
            //  if right neighbour is higher
        else
            return A[solveEfficiently(A, mid + 1, A.length - 1)];
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 3, 20, 4, 1, 0};
        System.out.println("yup: peak item in array: " + solve(A));

        System.out.println("yup: with efficient flow, peak item in array: " + solveEfficiently(A, 0, A.length - 1));
    }
}
