package _2BinarySearch;

//  https://youtu.be/FzvK5uuaki8?list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2
public class _12PosOfElementInInfiniteSortedArray {

    private int[] infiniteIntArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 30, Integer.MAX_VALUE};    //  consider this as infinite array

    private int findElementInInfiniteArray(int element) {
        int res;
        int startIndex = 0;
        int endIndex = 1;
        while (element > infiniteIntArray[endIndex]) {
            startIndex = endIndex;
            if (2 * endIndex > infiniteIntArray.length - 1)
                endIndex = infiniteIntArray.length - 1;
            else
                endIndex *= 2;
        }
        res = binSearch(element, startIndex, endIndex);
        return res;
    }

    private int binSearch(int element, int startIndex, int endIndex) {
        while (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            if (infiniteIntArray[mid] == element) {
                return mid;
            } else if (infiniteIntArray[mid] > element)
                endIndex = mid - 1;
            else if (infiniteIntArray[mid] < element)
                startIndex = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        _12PosOfElementInInfiniteSortedArray prob = new _12PosOfElementInInfiniteSortedArray();
        System.out.println("yup: element in infinite sorted array: " + prob.findElementInInfiniteArray(7));
    }
}
