package _ZSubX;

//  https://www.youtube.com/watch?v=HEzpaUOAcds&ab_channel=CodingandSystemDesignInterviews
public class _2printAllSubsequences_recursion {

  //   if arr is n, it'll have 2^n subsequences
  //  TC: O (2^n)
  private static void subSequence(int[] nums) {
    int n = nums.length;
    int ci = 0;
    int[] subSeqArray = new int[n];
    int cssi = 0;
    generateSubsequence(ci, nums, cssi, subSeqArray);
  }

  private static void generateSubsequence(int ci, int[] nums, int cssi, int[] subSeqArray) {
    if (ci >= nums.length) {
      print(cssi, subSeqArray);
      return;
    }
    //  exclude the item
    generateSubsequence(ci + 1, nums, cssi, subSeqArray);
    subSeqArray[cssi] = nums[ci];
    //  include the item
    generateSubsequence(ci + 1, nums, cssi + 1, subSeqArray);
  }

  private static void print(int currIndex, int[] nums) {
    System.out.print("{");
    for (int i = 0; i < currIndex; i++) {
      System.out.print(nums[i] + " ");
    }
    System.out.println("}");
  }

  /*
  *
    * yup: subSequences of Array:
      {}
      {3 }
      {2 }
      {2 3 }
      {1 }
      {1 3 }
      {1 2 }
      {1 2 3 }
  * */
  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    System.out.println("yup: subSequences of Array: ");
    subSequence(nums);
  }
}
