package _2BinarySearch;

//  https://youtu.be/8x6dmO6XW8k?list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2
public class _13FindIndexOfFirst1InBinarySortedInfiniteArray {

    //  bin sorted infinite array - 0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,.......infinite

    private int[] infiniteBinarySortedArray = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};    //  consider this as infinite array

    private int findFirstOccurenceOf1InInfiniteBinarySortedArray(int element) {
        int res;
        int startIndex = 0;
        int endIndex = 1;
        while (element > infiniteBinarySortedArray[endIndex]) {
            startIndex = endIndex;
            if (2 * endIndex > infiniteBinarySortedArray.length - 1)
                endIndex = infiniteBinarySortedArray.length - 1;
            else
                endIndex *= 2;
        }
        res = findFirstOccurence(element, startIndex, endIndex);
        return res;
    }

    private int findFirstOccurence(int element, int startIndex, int endIndex) {
        int res = -1;
        while (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            if (infiniteBinarySortedArray[mid] == element) {
                res = mid;
                endIndex = mid - 1;
            } else if (infiniteBinarySortedArray[mid] < element)
                startIndex = mid + 1;
            else if (infiniteBinarySortedArray[mid] > element)
                endIndex = mid - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        _13FindIndexOfFirst1InBinarySortedInfiniteArray prob = new _13FindIndexOfFirst1InBinarySortedInfiniteArray();
        int element = 1;
        System.out.println("yup: first occurence of " + element + " is " + prob.findFirstOccurenceOf1InInfiniteBinarySortedArray(element));
    }
}
