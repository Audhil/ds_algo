package _00Arrays;

import java.util.Arrays;

//  https://youtu.be/MXAroNNpwfA?t=402
//  https://codeforces.com/contest/1734/problem/A
public class _9Pick3Sticks_Equilateral_Triangle_E {

  //  TC: O (n log n)
  private static int minPickToMakeEqualLength(int[] sticks) {
    //  1. sort to make all sticks close to each other
    Arrays.sort(sticks);
    //  2. calculate min pick
    int minPick = Integer.MAX_VALUE;
    for (int i = 0; i < sticks.length - 2; i++) {
      int x = sticks[i];
      int y = sticks[i + 1];
      int z = sticks[i + 2];
      minPick = Math.min(minPick, (y - x) + (z - y));
    }
    return minPick;
  }

  public static void main(String[] args) {
    System.out.println("yup: minPicks to make all sticks equal length: " + minPickToMakeEqualLength(
        new int[]{1, 2, 3})); //  yup: minPicks to make all sticks equal length: 2
    System.out.println("yup: minPicks to make all sticks equal length: " + minPickToMakeEqualLength(
        new int[]{7, 3, 7, 3}));  //  yup: minPicks to make all sticks equal length: 4
    System.out.println("yup: minPicks to make all sticks equal length: " + minPickToMakeEqualLength(
        new int[]{3, 4, 2, 1, 1})); //  yup: minPicks to make all sticks equal length: 1
    System.out.println("yup: minPicks to make all sticks equal length: " + minPickToMakeEqualLength(
        new int[]{3, 1, 4, 1, 5, 9, 2, 6}));  //  yup: minPicks to make all sticks equal length: 1
  }
}
