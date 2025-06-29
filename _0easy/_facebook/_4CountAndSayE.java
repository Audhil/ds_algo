package _0easy._facebook;

//  https://www.lintcode.com/problem/420/solution?fromId=29&_from=collection
public class _4CountAndSayE {

  /*
  * The count-and-say sequence is the sequence of integers beginning as follows:

1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.

11 is read off as "two 1s" or 21.

21 is read off as "one 2, then one 1" or 1211.

Given an integer n, generate the nth sequence.

Wechat reply 【Google】 get the latest requent Interview questions. (wechat id : jiuzhang0607)


The sequence of integers will be represented as a string.

Example
Example 1:

Input: 1
Output: "1"
Example 2:

Input: 5
Output: "111221"

* */

  //  similar to _0CompressString.java prob

  //time complexity:O(N \times M)O ( N×M),inNNis a given positive integer,MMis the maximum length in the generated string.
  //
  //Space complexity:O(M)O(M). inMMis the maximum length in the generated string.
  public static String countAndSay(int n) {
    if (n == 0) {
      return "";
    }
    String res = "1";
    //  we are looping from 2, because we handled one 1 case in above line
    for (int i = 2; i <= n; i++) {
      StringBuilder builder = new StringBuilder();
      int pos = 0, start = 0;
      while (pos < res.length()) {
        while (pos < res.length() && res.charAt(pos) == res.charAt(start)) {
          pos++;
        }
        //  append count + char
        builder.append(pos - start).append(res.charAt(start));
        start = pos;
      }
      res = builder.toString();
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println("yup: countAndSay : " + countAndSay(5)); //  yup: countAndSay : 111221
    System.out.println(
        "yup: countAndSay : " + countAndSay(10)); //  yup: countAndSay : 13211311123113112211
  }
}
