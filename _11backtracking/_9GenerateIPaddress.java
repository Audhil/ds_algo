package _11backtracking;

import java.util.ArrayList;
import java.util.List;

//  https://www.youtube.com/watch?v=g1SOXwvSqe4&list=PLNxqWc8Uj2LTaaxs-8vzK0Ft47rMggFnN&index=12
//  8 bit| 8 bit| 8 bit| 8 bit => 0-255|0-255|0-255|0-255 - is the valid IP address
//  TC : O(n ^ 3)
public class _9GenerateIPaddress {

  //  TC : O(n ^ 3)
  private static List<String> generateIPaddressesRevision(
      String givenString,
      List<String> ipAddressList) {
    for (int i = 0; i < givenString.length() - 3; i++) {
      for (int j = i + 1; j < givenString.length() - 2; j++) {
        for (int k = j + 1; k < givenString.length() - 1; k++) {
          String num1 = givenString.substring(0, i);
          String num2 = givenString.substring(i + 1, j);
          String num3 = givenString.substring(j + 1, k);
          String num4 = givenString.substring(k + 1);
          if (isValidIPAddress(num1, num2, num3, num4)) {
            ipAddressList.add(num1 + "." + num2 + "." + num3 + "." + num4);
          }
        }
      }
    }
    return ipAddressList;
  }

  //  given string = 1902426
  private static List<String> generateIPaddresses(String givenString, List<String> ipAddressList) {
    //    i,j,k -> 3 places to place '.'
    for (int i = 0; i < givenString.length() - 3; i++) {    //  1902. 4.2.6
      for (int j = i + 1; j < givenString.length() - 2; j++) {    //  1902.4. 2.6
        for (int k = j + 1; k < givenString.length() - 1; k++) {    //  1902.4.2. 6
          String num1 = givenString.substring(0, i);
          String num2 = givenString.substring(i + 1, j);
          String num3 = givenString.substring(j + 1, k);
          String num4 = givenString.substring(k + 1);
          if (isValidIPAddress(num1, num2, num3, num4)) {
            ipAddressList.add(num1 + "." + num2 + "." + num3 + "." + num4);
          }
        }
      }
    }
    return ipAddressList;
  }

  /*
   * restrictions
   * 1. len > 0 && len <= 3
   * 2. "02" is invalid
   * 3. if it is in range of [0 - 255]
   * */
  private static boolean isValidIPAddress(String num1, String num2, String num3, String num4) {
    return isValidLength(num1) && isValidLength(num2) && isValidLength(num3) && isValidLength(num4)
        &&
        isValidNum(num1) && isValidNum(num2) && isValidNum(num3) && isValidNum(num4) &&
        isInValidRange(num1) && isInValidRange(num2) && isInValidRange(num3) && isInValidRange(
        num4);
  }

  private static boolean isValidLength(String num) {
    return num.length() > 0 && num.length() <= 3;
  }

  //  "02","0123" are invalid
  private static boolean isValidNum(String num) {
    if (num.charAt(0) == '0') {
      if (num.length() > 1) {
        return false;
      }
    }
    return true;
  }

  private static boolean isInValidRange(String num) {
    int number = Integer.parseInt(num);
    return number >= 0 && number <= 255;
  }

  public static void main(String[] args) {
    //  25011255255, 1902426
    System.out.println("yup: ipAddressList : " + generateIPaddressesRevision("25011255255",
        new ArrayList<>()));    //  yup: ipAddressList : [2.0.125.255, 25.1.25.255, 25.1.255.55, 25.11.5.255, 25.11.55.55, 25.112.5.55, 25.112.52.5, 250.1.5.255, 250.1.55.55, 250.12.5.55, 250.12.52.5, 250.125.2.5]

    System.out.println("yup: ipAddressList : " + generateIPaddressesRevision("1902426",
        new ArrayList<>()));    //  yup: ipAddressList : [1.0.4.6]
  }
}
