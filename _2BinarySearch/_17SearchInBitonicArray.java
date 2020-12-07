package _2BinarySearch;

//  https://youtu.be/IjaP8qt1IYI?list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2
public class _17SearchInBitonicArray {

    private int[] arr = {1, 3, 8, 12, 4, 2};

    private int findPeakElementIndex() {
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

    private int findIndexOfItemUsingBS(int elementToFind, int startIndexx, int endIndexx, boolean isAscending, boolean isDescending) {
        int startIndex = startIndexx, endIndex = endIndexx;
        if (isAscending)
            while (startIndex <= endIndex) {
                int mid = startIndex + (endIndex - startIndex) / 2;
                if (arr[mid] == elementToFind) {
                    return mid;
                } else if (arr[mid] < elementToFind) {
                    startIndex = mid + 1;
                } else if (arr[mid] > elementToFind) {
                    endIndex = mid - 1;
                }
            }
        if (isDescending)
            while (startIndex <= endIndex) {
                int mid = startIndex + (endIndex - startIndex) / 2;
                if (arr[mid] == elementToFind) {
                    return mid;
                } else if (arr[mid] > elementToFind) {
                    startIndex = mid + 1;
                } else if (arr[mid] < elementToFind) {
                    endIndex = mid - 1;
                }
            }
        return -1;
    }

    private int searchItemInBitonicArray(int element) {
        int resIndex = -1;
        int peakIndex = findPeakElementIndex();
        if (peakIndex != -1) {
            int item1 = findIndexOfItemUsingBS(element, 0, peakIndex - 1, true, false);   //  item from arr1
            int item2 = findIndexOfItemUsingBS(element, peakIndex, arr.length - 1, false, true);
            if (item1 != -1)
                resIndex = item1;
            if (item2 != -1)
                resIndex = item2;
        }
        return resIndex;
    }

    public static void main(String[] args) {
        _17SearchInBitonicArray prob = new _17SearchInBitonicArray();
        System.out.println("yup: searched item available @ index: " + prob.searchItemInBitonicArray(2));
    }
}
