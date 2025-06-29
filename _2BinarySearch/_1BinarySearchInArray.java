package _2BinarySearch;

//  always complexity is O (log N)
//  https://youtu.be/QNGL_t_o_QA?list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2
public class _1BinarySearchInArray {

    private static int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    private static int doBinarySearch(int elementToFind) {
        int startIndex = 0;
        int endIndex = arr.length - 1;

        while (startIndex <= endIndex) {
//            int mid = (startIndex + endIndex) / 2;  //  this will cause integer overflow for big numbers
            int mid = startIndex + ((endIndex - startIndex) / 2);  //  this is the workaround
            if (arr[mid] == elementToFind)
                return mid;
            else if (arr[mid] < elementToFind)
                startIndex = mid + 1;
            else if (arr[mid] > elementToFind)
                endIndex = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("yup: item available @ index: " + doBinarySearch(2));
    }
}
