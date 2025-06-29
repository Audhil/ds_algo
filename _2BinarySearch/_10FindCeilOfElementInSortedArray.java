package _2BinarySearch;

//  https://youtu.be/uiz0IxPCUeU?list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2
public class _10FindCeilOfElementInSortedArray {

    //  tips
    //  if element present in array = it is the ceil
    //  if element not present in array, then smallest element that is greater than given element is ceil

    private static int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 10, 11, 99};

    private static int findCeilOfNum(int element) {
        int startIndex = 0;
        int endIndex = arr.length - 1;

        int res = -1;

        while (startIndex <= endIndex) {
            int mid = startIndex + ((endIndex - startIndex) / 2);  //  this is the workaround
            if (arr[mid] == element)
                return arr[mid];
            else if (arr[mid] < element) {
                startIndex = mid + 1;
            } else if (arr[mid] > element) {
                res = arr[mid];
                endIndex = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int num = 9;
        System.out.println("yup: ceil of: " + num + " is : " + findCeilOfNum(num));
    }
}
