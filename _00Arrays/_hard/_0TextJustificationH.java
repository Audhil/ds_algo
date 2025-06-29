package _00Arrays._hard;

import java.util.ArrayList;
import java.util.List;

//  https://leetcode.com/problems/text-justification/
//  https://www.youtube.com/watch?v=rxwoWYJqaNc&ab_channel=Pepcoding
public class _0TextJustificationH {

  public static List<String> fullJustify(String[] words, int maxWidth) {
    List<String> resList = new ArrayList<>();
    int i = 0;  //  pointer i
    int n = words.length;
    while (i < n) {
      int wc = words[i].length(); //  num of chars at words[i]
      int j = i + 1;  //  pointer j

      //  int candidates = j - i - 1; //  candidates for spaces -> (num of words - 1)
      int candidates = 0;
      while (j < n && wc + candidates + words[j].length() + 1 <= maxWidth) {  //  https://youtu.be/rxwoWYJqaNc?t=2264 - https://youtu.be/rxwoWYJqaNc?t=2351
        wc += words[j].length();
        candidates++;
        j++;
      }
      int vacancies = maxWidth - wc;  //  remaining vacant spots

      int atLeast = candidates == 0 ? 0 : vacancies / candidates;
      int extra = candidates == 0 ? 0 : vacancies % candidates;

      //  no extra space distributions in last line, only 1 space is allowed between 2 words
      if (j == n) {
        atLeast = 1;
        extra = 0;
      }

      StringBuilder stringBuilder = new StringBuilder();
      for (int k = i; k < j; k++) {
        stringBuilder.append(words[k]);
        //  preventing adding extra spaces to last word in the line
        if (k == j - 1) {
          break;
        }
        for (int l = 0; l < atLeast; l++) {
          stringBuilder.append(" ");
        }

        if (extra > 0) {
          stringBuilder.append(" ");
          extra--;
        }
      }
      while (stringBuilder.length() < maxWidth) {
        stringBuilder.append(" ");
      }
      resList.add(stringBuilder.toString());
      i = j;
    }
    return resList;
  }

  public static void main(String[] args) {
    System.out.println("yup: this is justification: " + fullJustify(
        new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));

    System.out.println("yup: this is justification: " + fullJustify(
        new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16));

    System.out.println("yup: this is justification: " + fullJustify(
        new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
            "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20));
  }
}
