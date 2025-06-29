package _0String;

import java.util.HashSet;
import java.util.Set;

//  https://leetcode.com/problems/unique-morse-code-words/
public class _2UniqueMorseCodeWords_E {

  public static int uniqueMorseRepresentations(String[] words) {
    Set<String> set = new HashSet<>();
    String[] codes = {
        ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
        "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
    };
    for (String word : words) {
      StringBuilder builder = new StringBuilder();
      for (char ch : word.toCharArray()) {
        builder.append(codes[ch - 'a']);
      }
      set.add(builder.toString());
    }
    return set.size();
  }

  public static void main(String[] args) {
    System.out.println("yup: uniqueMorse code: " + uniqueMorseRepresentations(
        new String[]{"gin", "zen", "gig", "msg"})); //  yup: uniqueMorse code: 2

    System.out.println("yup: uniqueMorse code: " + uniqueMorseRepresentations(
        new String[]{"a"}));  //  yup: uniqueMorse code: 1
  }
}
