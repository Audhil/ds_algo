package _10Blind75;

public class _0TwoPointerTargetSumE {

  private static class Pair {

    int a, b;

    public Pair(int a, int b) {
      this.a = a;
      this.b = b;
    }

    @Override
    public String toString() {
      return "Pair{" +
          "a=" + a +
          ", b=" + b +
          '}';
    }
  }

  //  in TC O(n), SC O(1) - considering sorted input array
  public static Pair targetSumPairFromArray(int[] arr, int targetSum) {
    if (arr == null || arr.length < 2) {
      return null;
    }

    int left = 0, right = arr.length - 1;
    int currSum;
    while (left < right) {
      currSum = arr[left] + arr[right];
      if (currSum < targetSum) {
        left++;
      } else if (currSum > targetSum) {
        right--;
      } else {
        break;
      }
    }
    return new Pair(left, right);
  }

  public static void main(String[] args) {
    //  o/p
    /*
      yup: targetSumPair: Pair{a=1, b=3}
    * */
    System.out.println(
        "yup: targetSumPair: " + targetSumPairFromArray(new int[]{1, 2, 3, 4, 6}, 6));
  }
}
