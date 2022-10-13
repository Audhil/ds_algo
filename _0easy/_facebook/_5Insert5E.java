package _0easy._facebook;

//  https://www.lintcode.com/problem/188/?fromId=29&_from=collection
public class _5Insert5E {

  //  tip: if given number is +ve, then insert '5' before first smallest than 5
  //  if given number is -ve, then insert '5' before first largest than 5
  public static int insertFive(int a) {
    String numStr = String.valueOf(a);
    int i = 0;
    //  given +ve num
    if (a >= 0) {
      while (i < numStr.length() && numStr.charAt(i) >= '5') {
        i++;
      }
    }
    //  given -ve num
    else {
      i = 1;  //  avoid minus sign of the number, which is at 0th index
      while (i < numStr.length() && numStr.charAt(i) <= '5') {
        i++;
      }
    }
    return Integer.parseInt(numStr.substring(0, i) + '5' + numStr.substring(i));
  }

  public static void main(String[] args) {
    System.out.println("yup: insert5 : " + insertFive(71)); //  yup: insert5 : 751
    System.out.println("yup: insert5 : " + insertFive(-71));  //  yup: insert5 : -571
  }
}
