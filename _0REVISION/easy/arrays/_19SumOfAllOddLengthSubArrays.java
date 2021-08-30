package _0REVISION.easy.arrays;

//  https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
//  https://www.youtube.com/watch?v=J5IIH35EBVE
/*
*
Input: arr = [1,4,2,5,3]
Output: 58
Explanation: The odd-length subarrays of arr and their sums are:
[1] = 1
[4] = 4
[2] = 2
[5] = 5
[3] = 3
[1,4,2] = 7
[4,2,5] = 11
[2,5,3] = 10
[1,4,2,5,3] = 15
If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58
* */
public class _19SumOfAllOddLengthSubArrays {
    public static int sumOddLengthSubarrays(int[] arr) {
        if (arr == null)
            return 0;

        int n = arr.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int noOfSubarraysStartsWithItem = n - i;    //  refer video
            int noOfSubarraysEndsWithItem = i + 1;  //  refer video
            int totalNoOfSubarraysItemAppears = noOfSubarraysStartsWithItem * noOfSubarraysEndsWithItem;
            //  since totalNoOfSubarraysItemAppears = oddLengthSubArrays + evenLengthSubArrays
            int oddLengthSubArrays = totalNoOfSubarraysItemAppears / 2;
            //  is it odd?
            if (totalNoOfSubarraysItemAppears % 2 != 0) {
                oddLengthSubArrays += 1;
            }
            res += (oddLengthSubArrays * arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("yup: 1,4,2,5,3: " + sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}));   //  yup: 1,4,2,5,3: 58
        System.out.println("yup: 1,4,2,5,3: " + sumOddLengthSubarrays(new int[]{1,2}));   //  yup: 1,4,2,5,3: 3
    }
}
