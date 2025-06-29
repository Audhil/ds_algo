package _10Blind75._00Others;

//  https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/
//  https://www.youtube.com/watch?v=4ZJuUQ2iMk4&ab_channel=SandipJana
public class _4DetermineMatrixFromRotationE {

  public static boolean findRotation(int[][] mat, int[][] target) {
    //  4 * 90 deg -> 360 deg = it'll be back to original matrix position
    for (int i = 0; i < 4; i++) { //  so 4 rotation is enough
      if (isSame(mat, target)) {
        return true;
      }
      mat = rotateMatrix(mat);
    }
    return false;
  }

  private static boolean isSame(int[][] mat, int[][] target) {
    if (mat.length == target.length && mat[0].length == target[0].length) {
      for (int row = 0; row < mat.length; row++) {
        for (int col = 0; col < mat[0].length; col++) {
          if (mat[row][col] != target[row][col]) {
            return false;
          }
        }
      }
    }
    return true;
  }

  private static int[][] rotateMatrix(int[][] mat) {
    int rowCount = mat.length;
    int colCount = mat[0].length;
    int[][] b = new int[colCount][rowCount];
    for (int i = 0; i < rowCount; i++) {
      for (int j = 0; j < colCount; j++) {
        b[j][rowCount - 1 - i] = mat[i][j];
      }
    }
    return b;
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: isSame Matrix: " +
            findRotation(new int[][]{{0, 1}, {1, 0}}, new int[][]{{1, 0}, {0, 1}}));

    System.out.println(
        "yup: isSame Matrix: " +
            findRotation(new int[][]{{0, 1}, {1, 1}}, new int[][]{{1, 0}, {0, 1}}));

    System.out.println(
        "yup: isSame Matrix: " +
            findRotation(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}},
                new int[][]{{1, 1, 1}, {0, 1, 0}, {0, 0, 0}}));
  }
}
