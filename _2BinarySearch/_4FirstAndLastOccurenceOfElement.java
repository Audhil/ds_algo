package _2BinarySearch;

//  https://youtu.be/zr_AoTxzn0Y?list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2
public class _4FirstAndLastOccurenceOfElement {

    private static int[] arr = {1, 2, 3, 4, 4, 5, 6, 7, 8, 9};

    private static int binSearchFirstOccurence(int element) {
        int startIndex = 0;
        int endIndex = arr.length - 1;
        int res = -1;
        while (startIndex <= endIndex) {
            int mid = startIndex + ((endIndex - startIndex) / 2);
            if (arr[mid] == element) {
                res = mid;
                endIndex = mid - 1;
            } else if (arr[mid] < element)
                startIndex = mid + 1;
            else if (arr[mid] > element)
                endIndex = mid - 1;
        }
        return res;
    }

    private static int binSearchLastOccurence(int element) {
        int startIndex = 0;
        int endIndex = arr.length - 1;
        int res = -1;
        while (startIndex <= endIndex) {
            int mid = startIndex + ((endIndex - startIndex) / 2);
            if (arr[mid] == element) {
                res = mid;
                startIndex = mid + 1;
            } else if (arr[mid] < element)
                startIndex = mid + 1;
            else if (arr[mid] > element)
                endIndex = mid - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("yup: firstOccurence: " + binSearchFirstOccurence(4));
        System.out.println("yup: lastOccurence: " + binSearchLastOccurence(4));

    }
}
