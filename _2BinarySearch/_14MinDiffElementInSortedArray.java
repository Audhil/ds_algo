package _2BinarySearch;

//  https://youtu.be/3RhGdmoF_ac?list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2
public class _14MinDiffElementInSortedArray {

    //    private static int[] arr = {4, 6, 10};
    private int[] arr = {1, 3, 8, 10, 15};
    private int key = 12;

    private int minDiffElement(int element) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == element)    //  let's arr[mid] = 12, key = 12 -> 12 - 12 = 0 - this is the min diff
                return arr[mid];
            else if (arr[mid] > element)
                end = mid - 1;
            else if (arr[mid] < element)
                start = mid + 1;
        }
        //  this prevents IndexOutOfBoundError
        if (start >= arr.length)
            start = arr.length - 1;
        if (end < 0)
            end = 0;

        //  min difference will be given by the neighbours of key - if it's not available
        int minDiffWithStartIndex = Math.abs(arr[start] - element);
        int minDiffWithEndIndex = Math.abs(arr[end] - element);
        if (minDiffWithStartIndex < minDiffWithEndIndex)
            return arr[start];
        else
            return arr[end];
    }

    public static void main(String[] args) {
        _14MinDiffElementInSortedArray prob = new _14MinDiffElementInSortedArray();
        System.out.println("yup: minDiffElement: with key: " + prob.key + " is " + prob.minDiffElement(prob.key));
    }
}
