package _00Arrays._FloydAlgo_TortoiseAndHare;

//  https://youtu.be/PvrxZaH_eZ4?t=474
public class _0DetectDuplicateInArray_N_plus_1_Values {

  //  TC: O (n); SC: O (1)
  private static int detectDuplicate(int[] arr) {
    int slow = 0;
    int fast = 0;
    //  we are sure, this loop will break out, due to pigeonhole principle
    while (true) {
      slow = arr[slow];
      fast = arr[arr[fast]];
      if (slow == fast) {
        break;
      }
    }
    slow = 0;
    while (slow != fast) {
      slow = arr[slow];
      fast = arr[fast];
    }
    return slow;
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: duplicate is : " + detectDuplicate(
            new int[]{4, 3, 7, 8, 6, 9, 2, 1, 5, 8})); //  yup: duplicate is : 8
  }
}
