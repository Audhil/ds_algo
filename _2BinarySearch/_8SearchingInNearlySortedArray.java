package _2BinarySearch;

//  https://youtu.be/W3-KgsCVH1U?list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2
public class _8SearchingInNearlySortedArray {

  //  tip : nearly sorted array mean an element at ith index, can be found at i, i-1, i+1 indices
  private static int[] arr = {5, 10, 30, 20, 50, 40};

  private static int doBSinNearlySortedArray(int element) {
    int startIndex = 0, endIndex = arr.length - 1;
    while (startIndex <= endIndex) {
      int mid = startIndex + (endIndex - startIndex) / 2;
        if (arr[mid] == element) {
            return mid;
        } else if (mid - 1 >= startIndex && arr[mid - 1] == element) {
            return mid - 1;
        } else if (mid + 1 <= endIndex && arr[mid + 1] == element) {
            return mid + 1;
        }

        //  search other portions of array
        else if (arr[mid] > element) {
            endIndex = mid - 2;
        } else if (arr[mid] < element) {
            startIndex = mid + 2;
        }
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println("yup: item found at index: " + doBSinNearlySortedArray(50));
  }
}
