package _10Blind75._1Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//  https://www.lintcode.com/problem/659/
//  https://leetcode.com/problems/encode-and-decode-strings/
public class _0EncodeDecodeStringsM {

  /*
  * Design an algorithm to encode a list of strings to a string.
  * The encoded string is then sent over the network and is decoded back to the original list of strings.
    Please implement encode and decode
  * */
  /*
  * eg1:
  * Input: ["lint","code","love","you"]
    Output: ["lint","code","love","you"]
    Explanation:
    One possible encode method is: "lint:;code:;love:;you"
  * */

  /*
  * eg2:
  * Input: ["we", "say", ":", "yes"]
    Output: ["we", "say", ":", "yes"]
    Explanation:
    One possible encode method is: "we:;say:;:::;yes"
   * */

  /*
   * @param strs: a list of strings
   * @return: encodes a list of strings to a single string.
   */
  public static String encode(List<String> strs) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < strs.size(); i++) {
      char[] chArray = strs.get(i).toCharArray();
      for (char ch : chArray) {
        if (ch == ':') {
          stringBuilder.append("::");
        } else {
          stringBuilder.append(ch);
        }
      }
      if (i != strs.size() - 1) {
        stringBuilder.append(":;");
      }
    }
    return stringBuilder.toString();
  }

  /*
   * @param str: A string
   * @return: dcodes a single string to a list of strings
   */
  public static List<String> decode(String str) {
    String[] words = str.split(":;");
    List<String> finalList = new ArrayList<>();
    for (String word : words) {
      if (word.equals("::")) {
        finalList.add(":");
      } else {
        finalList.add(word);
      }
    }
    return finalList;
  }


  //  revision
  public static String encodeRevision(List<String> strs) {
    if (strs == null || strs.isEmpty()) {
      return "";
    }
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < strs.size(); i++) {
      for (char ch : strs.get(i).toCharArray()) {
        if (ch == ':') {
          stringBuilder.append("::");
        } else {
          stringBuilder.append(ch);
        }
      }
      if (i != strs.size() - 1) {
        stringBuilder.append(":;");
      }
    }
    return stringBuilder.toString();
  }

  public static List<String> decodeRevision(String input) {
    List<String> resList = new ArrayList<>();
    if (input == null || input.isEmpty()) {
      return resList;
    }
    String[] strings = input.split(":;");
    for (String string : strings) {
      if (string.equals("::")) {
        resList.add(":");
      } else {
        resList.add(string);
      }
    }
    return resList;
  }

  //  enhanced version: https://www.youtube.com/watch?v=B1k_sxOSgv8&ab_channel=NeetCode
  //  adding count# before each string
  public static String encodeEnhanced(List<String> strs) {
    if (strs == null || strs.isEmpty()) {
      return "";
    }
    StringBuilder stringBuilder = new StringBuilder();
    for (String str : strs) {
      stringBuilder.append(str.length());
      stringBuilder.append("#");
      for (char ch : str.toCharArray()) {
        stringBuilder.append(ch);
      }
    }
    return stringBuilder.toString();
  }

  public static List<String> decodeEnhanced(String input) {
    if (input == null || input.isEmpty()) {
      return new ArrayList<>();
    }
    List<String> resList = new ArrayList<>();
    int i = 0;
    while (i < input.length()) {
      int j = i;
      while (input.charAt(j) != '#') {
        j++;
      }
      int wordLen;
      if (i != j - 1) {
        wordLen = Integer.parseInt(input.charAt(i) + "" + input.charAt(j - 1));
      } else {
        wordLen = Integer.parseInt(input.charAt(i) + "");
      }
      resList.add(input.substring(j + 1, j + 1 + wordLen));
      i = j + 1 + wordLen;
    }
    return resList;
  }

  public static void main(String[] args) {
//    String encodedStr = encode(Arrays.asList("Jack", "and", "jill", ":", "test"));
//    System.out.println(
//        "yup: encodedStr: " + encodedStr); //  yup: encodedStr: Jack:;and:;jill:;:::;test
//    System.out.println("yup: decoded list: " + decode(
//        encodedStr)); //  yup: decoded list: [Jack, and, jill, :, test]

//    String res = encodeRevision(Arrays.asList("Jack", "and", "jill", ":", "testing"));
//    System.out.println(
//        "yup: res: " + res); //  yup: res: Jack:;and:;jill:;:::;testing
//    System.out.println("yup: decoded list: " + decodeRevision(
//        res)); //  yup: decoded list: [Jack, and, jill, :, testing]

    String res = encodeEnhanced(Arrays.asList("Jack", "and", "jill", ":", "testing"));
    System.out.println(
        "yup: res: " + res); //  yup: res: 4#Jack3#and4#jill1#:7#testing
    System.out.println("yup: decoded list: " + decodeEnhanced(
        res)); //  yup: decoded list: [Jack, and, jill, :, testing]
  }
}
