package _00Arrays._2DArray_Matrix;

import java.util.Arrays;
import java.util.List;

public class _1MinMovesForKnightToGetOutOfBoard {
  private static int minMoves(int row, int col) {
    List<Integer> nums = Arrays.asList(2, 3, 4, 5);
    return nums.contains(row) && nums.contains(col) ? 2 : 1;
  }

  public static void main(String[] args) {
    System.out.println("yup: minMoves: " + minMoves(0,7));
  }
}
