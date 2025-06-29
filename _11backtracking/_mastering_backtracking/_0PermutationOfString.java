package _11backtracking._mastering_backtracking;

//  https://youtu.be/PC0lSbDN2gY?t=3156
public class _0PermutationOfString {

  private static void findPermutationOfString(String str) {
    System.out.println("Permutations of : " + str);
    compute(str, 0, str.length() - 1);
  }

  private static void compute(String str, int left, int right) {
    if (left == right) {
      System.out.println(str);
      return;
    }
    for (int i = left; i <= right; i++) {
      //  do
      str = swap(str, i, left);
      //  recur
      compute(str, left + 1, right);
      //  undo
      str = swap(str, i, left);
    }
  }

  private static String swap(String str, int i, int left) {
    char[] chars = str.toCharArray();
    char temp = chars[i];
    chars[i] = chars[left];
    chars[left] = temp;
    return String.valueOf(chars);
  }

  public static void main(String[] args) {
    /*
    * Permutations of : abc
      abc
      acb
      bac
      bca
      cba
      cab
    * */
    findPermutationOfString("abc");
  }
}
