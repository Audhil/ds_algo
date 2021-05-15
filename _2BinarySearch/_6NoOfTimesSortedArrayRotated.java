package _2BinarySearch;

//  https://youtu.be/4WmTRFZilj8?list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2
public class _6NoOfTimesSortedArrayRotated {
    /*
     * Key points
     * 1. index of smaller element = no of times array rotated
     * 2. smaller element can be found by comparing prev, next neighbours, if it smaller than both neighbours then it is the smaller
     * 3. moving search of next/prev part of array is done by comparing arr[start] or arr[end] items with arr[mid]
     * */
    private static int[] arr = {11, 12, 15, 18, 2, 5, 6, 8};
//    private static int[] arr = {4, 4, 5, 6, 7, 8, 9, 44, 1, 2, 3, 4, 4};

    private static int noOfTimesSortedArrayRotated() {
        int startIndex = 0, endIndex = arr.length - 1;
        int noOfItemsInArray = arr.length;

//        THIS WORKS ONLY FOR ARRAY WITH UNIQUE ITEMS
//        if (arr[startIndex] <= arr[endIndex]) {
//            return 0;
//        }

        while (startIndex <= endIndex) {
            int mid = startIndex + ((endIndex - startIndex)) / 2;
            int prevToMidIndex = (mid + (noOfItemsInArray - 1)) % noOfItemsInArray;
            int nextToMidIndex = (mid + 1) % noOfItemsInArray;
            //  if it is smaller than next & prev item, return the index, which is equal to noOfRotations
            if (arr[mid] <= arr[prevToMidIndex] && arr[mid] <= arr[nextToMidIndex]) {
                return mid;
            }
            //  shift search to right side
            else if (arr[0] <= arr[mid]) {
                startIndex = mid + 1;
            }
            //  shift search to right side
            else if (arr[mid] <= arr[noOfItemsInArray - 1]) {
                endIndex = mid - 1;
            }
//            this too works
//            //  shift search to left side
//            else if (arr[0] > arr[mid]) {
//                endIndex = mid - 1;
//            }
//            //  shift search to right side
//            else {
//                startIndex = mid + 1;
//            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("yup: noOfTimesRotated: " + noOfTimesSortedArrayRotated());
    }
}
