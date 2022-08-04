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

  public static void main(String[] args) {
    String encodedStr = encode(Arrays.asList("Jack", "and", "jill", ":", "test"));
    System.out.println("yup: encodedStr: " + encodedStr); //  yup: encodedStr: Jack:;and:;jill:;:::;test
    System.out.println("yup: decoded list: " + decode(encodedStr)); //  yup: decoded list: [Jack, and, jill, :, test]
  }
}
