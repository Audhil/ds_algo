package _0easy;

//  https://www.lintcode.com/problem/1350/description?fromId=29&_from=collection
public class _0NumToExcelColTitleE {

  public static String convertToTitle(int n) {
    if (n == 0) {
      return "";
    }

    StringBuilder stringBuilder = new StringBuilder();
    while (n > 0) {
      n--;
      stringBuilder.append((char) (n % 26 + 'A'));
      n /= 26;
    }
    return stringBuilder.reverse().toString();
  }

  public static void main(String[] args) {
    System.out.println("yup: col title of : " + convertToTitle(676)); //  yup: col title of : YZ
  }
}
