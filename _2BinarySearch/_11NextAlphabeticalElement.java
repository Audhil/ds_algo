package _2BinarySearch;

//  https://youtu.be/X45c37QMdX0?list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2
public class _11NextAlphabeticalElement {

    private static char[] arr = {'a', 'c', 'f', 'g', 'h'};

    private static char findNextAlphabet(char key) {
        int startIndex = 0;
        int endIndex = arr.length - 1;

        char res = '#';

        while (startIndex <= endIndex) {
            int mid = startIndex + ((endIndex - startIndex) / 2);  //  this is the workaround
            if (arr[mid] == key)
                startIndex = mid + 1;
            else if (arr[mid] < key) {
                startIndex = mid + 1;
            } else if (arr[mid] > key) {
                res = arr[mid];
                endIndex = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        char num = 'k';
        System.out.println("yup: ceil of: " + num + " is : " + findNextAlphabet(num));
    }
}
