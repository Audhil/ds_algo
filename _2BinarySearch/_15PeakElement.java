package _2BinarySearch;

//  https://youtu.be/OINnBJTRrMU?list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2
public class _15PeakElement {
    //  bin search on answer concept

    //    private int[] arr = {5, 10, 20, 15};
    private int[] arr = {10, 20, 15, 2, 23, 90, 67};

    private int findPeakElementIndex() {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            //  if mid lies between 0th & last index of array
            if (mid > 0 && mid < arr.length - 1) {
                //  is mid item is a peak element?
                if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1])
                    return mid;
                else if (arr[mid + 1] > arr[mid])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
            //  if mid is at 0th pos
            else if (mid == 0) {
                if (arr[0] > arr[1])
                    return 0;
                else
                    return 1;
            }
            //  if mid is at last pos
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
        _15PeakElement prob = new _15PeakElement();
        System.out.println("yup: peak element is available at : " + prob.findPeakElementIndex());
    }
}
