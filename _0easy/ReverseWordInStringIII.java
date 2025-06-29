package _0easy;

import java.util.ArrayList;
import java.util.Arrays;

//  Reverse Words in a String III
//  https://leetcode.com/problems/reverse-words-in-a-string-iii/
/*
* Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.



Example 1:

Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Example 2:

Input: s = "God Ding"
Output: "doG gniD"


Constraints:

1 <= s.length <= 5 * 104
s contains printable ASCII characters.
s does not contain any leading or trailing spaces.
There is at least one word in s.
All the words in s are separated by a single space.
* */
public class ReverseWordInStringIII {

  /*  Approach #1 simple approach
   * Time complexity : O(n). where n is the length of the string.
   * Space complexity : O(n). res of size n is used.
   * */
  public static String reverseWords(String s) {
    if (s == null) {
      return null;
    }

    String[] words = s.split(" ");
    StringBuilder stringBuilder = new StringBuilder();
    for (String word : words) {
      stringBuilder.append(new StringBuilder(word).reverse().toString().trim()).append(" ");
    }
    return stringBuilder.toString().trim();
  }

  /*
   * Approach #2 Without using pre-defined split and reverse function.
   * We can create our own split and reverse function.
   * Split function splits the string based on the delimiter " "(space) and returns the array of words.
   * Reverse function returns the string after reversing the characters.
   */

  public static String reverseWordss(String s) {
    String[] words = split(s);
    System.out.println("yup: words: " + Arrays.toString(words));
    StringBuilder res = new StringBuilder();
    for (String word : words) {
      res.append(reverse(word)).append(" ");
    }
    return res.toString().trim();
  }

  public static String[] split(String s) {
    ArrayList<String> words = new ArrayList<>();
    StringBuilder word = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ' ') {
        words.add(word.toString());
        word = new StringBuilder();
      } else {
        word.append(s.charAt(i));
      }
    }
    words.add(word.toString());
    return words.toArray(new String[words.size()]);
  }

  public static String reverse(String s) {
    System.out.println("yup: reverse this word: " + s);
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      res.insert(0, s.charAt(i)); //  enters the char at 0th index
      System.out.println("yup: hi hi: res: " + res);
    }
    return res.toString();
  }

  /*
      Approach #3 Using StringBuilder and reverse method
   */
  public static String reverseWordsss(String input) {
    final StringBuilder result = new StringBuilder();
    final StringBuilder word = new StringBuilder();
    for (int i = 0; i < input.length(); i++) {
      if (input.charAt(i) != ' ') {
        word.append(input.charAt(i));
      } else {
        result.append(word.reverse());
        result.append(" ");
        word.setLength(0);
      }
    }
    result.append(word.reverse());
    return result.toString();
  }

  //  Newer
  //  TC: O (n); SC: O (1)
  public static String reverseWordsOptimized(String s) {
    int n = s.length();
    int lastSpaceIndex = -1;
    char[] chArr = s.toCharArray();
    for (int currIndex = 0; currIndex <= n; currIndex++) {
      if (currIndex == n || chArr[currIndex] == ' ') {
        int wStartIndex = lastSpaceIndex + 1;
        int wEndIndex = currIndex - 1;
        while (wStartIndex < wEndIndex) {
          char temp = chArr[wStartIndex];
          chArr[wStartIndex] = chArr[wEndIndex];
          chArr[wEndIndex] = temp;
          wStartIndex++;
          wEndIndex--;
        }
        lastSpaceIndex = currIndex;
      }
    }
    return new String(chArr);
  }

  public static void main(String[] args) {
//        System.out.println("yup: " + reverseWords("Let's take LeetCode contest"));
//        System.out.println("yup: " + reverseWords("God Ding"));

//        System.out.println("yup: " + reverseWordss("Let's take LeetCode contest"));
//        System.out.println("yup: " + reverseWordss("God Ding"));

    System.out.println("yup: " + reverseWordsss("Let's take LeetCode contest"));
    System.out.println("yup: " + reverseWordsss("God Ding"));

    System.out.println("yup: " + reverseWordsOptimized(
        "Let's take LeetCode contest")); //  yup: s'teL ekat edoCteeL tsetnoc
    System.out.println("yup: " + reverseWordsOptimized("God Ding"));  //  yup: doG gniD
  }
}
