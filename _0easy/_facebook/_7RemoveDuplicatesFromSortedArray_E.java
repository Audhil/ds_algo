package _0easy._facebook;

//  same: RemoveDuplicatedSortedArray.java
//  similar probs: _1RemoveDuplicatesFromLListE.java, _24RemoveDuplicatesFromSortedArrayE.java
public class _7RemoveDuplicatesFromSortedArray_E {

  public static int removeDuplicates(int[] nums) {
    if (nums.length <= 1) {
      return nums.length;
    }
    int l = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[l]) {
        l++;
        nums[l] = nums[i];
      }
    }
    //  return l holds the index of unique element, +1 to make num of unique elements
    //  for input [1,1,2,3,3,4] -> [1,2,3,4,3,4] -> l will hold index value 3; hence distinct elements are 4;
    return l + 1;
  }

  public static void main(String[] args) {
    System.out.println("yup: remove duplicates: " + removeDuplicates(new int[]{})); //  0
    System.out.println("yup: remove duplicates: " + removeDuplicates(new int[]{1, 1, 2}));  //  2
    System.out.println("yup: remove duplicates: " + removeDuplicates(new int[]{1, 1, 2, 3, 3, 4})); //  4
  }
}
