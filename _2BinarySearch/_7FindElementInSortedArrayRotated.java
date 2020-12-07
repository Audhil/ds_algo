package _2BinarySearch;

//  https://youtu.be/Id-DdcWb5AU?list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2
public class _7FindElementInSortedArrayRotated {

    private static int[] arr = {11, 12, 15, 18, 2, 5, 6, 8};

    //  array before min index is sorted & array after min index is also sorted that's the key point
    private static int findMinItemIndex() {
        int startIndex = 0, endIndex = arr.length - 1;
        while (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            int nextIndex = (mid + 1) % arr.length;
            int prevIndex = (mid + (arr.length - 1)) % arr.length;
            if (arr[mid] <= arr[prevIndex] && arr[mid] <= arr[nextIndex]) {
                return mid;
            }
            //  if left side is correctly sorted
            else if (arr[0] > arr[mid]) {
                endIndex = mid - 1;
            }
            //  if right side is correctly sorted
            else {
                startIndex = mid + 1;
            }
        }
        return -1;
    }

    private static int findIndexOfItemUsingBS(int elementToFind, int startIndexx, int endIndexx) {
        int startIndex = startIndexx, endIndex = endIndexx;
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
        return -1;
    }

    private static int findElementInSortedArrayRotated(int elementToFind) {
        int resIndex = -1;
        int minItemIndex = findMinItemIndex();
        if (minItemIndex != -1) {
            int index1 = findIndexOfItemUsingBS(elementToFind, 0, minItemIndex - 1);
            int index2 = findIndexOfItemUsingBS(elementToFind, minItemIndex, arr.length - 1);
            if (index1 != -1)
                resIndex = index1;
            if (index2 != -1)
                resIndex = index2;
        }
        return resIndex;
    }

    public static void main(String[] args) {
        System.out.println("yup: element in sorted array rotated: " + findElementInSortedArrayRotated(8));
    }
}
