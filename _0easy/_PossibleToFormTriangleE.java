package _0easy;

import java.util.Arrays;

//  https://www.geeksforgeeks.org/possible-form-triangle-array-values/
public class _PossibleToFormTriangleE {

  private static boolean isItPossibleToFormTriangle(int[] arr) {
    Arrays.sort(arr);
    int n = arr.length;
    for (int i = n - 1; i >= 2; i--) {
      int l = 0, r = i - 1;
      while (l < r) {
        //  https://youtu.be/PqEiJDdt3S4
        if (arr[l] + arr[r] > arr[i]) {
          return true;
        } else {
          l++;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    System.out.println("yup: isItPossibleToFormTriangle : " + isItPossibleToFormTriangle(
        new int[]{6, 4, 9, 2, 8})); //  yup: isItPossibleToFormTriangle : true
    System.out.println("yup: isItPossibleToFormTriangle : " + isItPossibleToFormTriangle(
        new int[]{4, 1, 2})); //  yup: isItPossibleToFormTriangle : false
    System.out.println("yup: isItPossibleToFormTriangle : " + isItPossibleToFormTriangle(
        new int[]{5, 4, 3, 1, 2})); //  yup: isItPossibleToFormTriangle : true
  }
}
