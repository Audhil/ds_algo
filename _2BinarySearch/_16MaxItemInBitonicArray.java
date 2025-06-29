package _2BinarySearch;

//  https://youtu.be/BrrZL1RDMwc?list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2
public class _16MaxItemInBitonicArray {

    //  tip: peak element = max item in bitonic array

    private int[] arr = {1, 3, 8, 12, 4, 2};

    private int findPeakElement() {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            //  mid item at middle of the array
            if (mid > 0 && mid < arr.length - 1) {
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                    return mid;
                    //  move search to left side
                else if (arr[mid - 1] > arr[mid])
                    end = mid - 1;
                    //  move search to right side
                else if (arr[mid + 1] > arr[mid])
                    start = mid + 1;
            }
            //  if mid is at left corner of array
            else if (mid == 0) {
                if (arr[0] > arr[1])
                    return 0;
                else
                    return 1;
            }
            //  if mid is at right corner of array
            else if (mid == arr.length - 1) {
                if (arr[arr.length - 1] > arr[arr.length - 2])
                    return arr.length - 1;
                else
                    return arr.length - 2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        _16MaxItemInBitonicArray prob = new _16MaxItemInBitonicArray();
        System.out.println("yup: max item in bitonic array: " + prob.findPeakElement());
    }
}
