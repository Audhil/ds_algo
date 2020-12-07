package _2BinarySearch;

//  https://youtu.be/5cx0xerA8XY?list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2
public class _9FindFloorOfElementInSortedArray {

    //  tips
    //  if element present in array = it is the floor
    //  if element not present in array, then greatest element that is smaller than given element is floor

    private static int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 99};

    private static int findFloorOfNum(int element) {
        int startIndex = 0;
        int endIndex = arr.length - 1;

        int res = -1;

        while (startIndex <= endIndex) {
            int mid = startIndex + ((endIndex - startIndex) / 2);  //  this is the workaround
            if (arr[mid] == element)
                return arr[mid];
            else if (arr[mid] < element) {
                res = arr[mid];
                startIndex = mid + 1;
            } else if (arr[mid] > element)
                endIndex = mid - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int num = 9;
        System.out.println("yup: floor of: " + num + " is : " + findFloorOfNum(num));
    }
}
