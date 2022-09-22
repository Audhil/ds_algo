package _0easy;

import java.util.Arrays;

//  https://youtu.be/PqEiJDdt3S4
public class _CountNumOfTrianglesE {

  //  A + B > C
  //  B + C > A
  //  C + A > B

  //  TC: O (n log n)
  private static int countNumOfTriangles(int[] arr) {
    Arrays.sort(arr);
    int n = arr.length;
    int count = 0;
    for (int i = n - 1; i >= 2; i--) {
      int l = 0, r = i - 1;
      while (l < r) {
        //  https://youtu.be/PqEiJDdt3S4
        if (arr[l] + arr[r] > arr[i]) {
          count += (r - l);
          r--;
        } else {
          l++;
        }
      }
    }
    return count;
  }

  public static void main(String[] args) {
    System.out.println("yup: num Of triangles : " + countNumOfTriangles(
        new int[]{6, 4, 9, 2, 8})); //  yup: num Of triangles : 5
  }
}
