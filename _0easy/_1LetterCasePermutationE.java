package _0easy;

import java.util.ArrayList;
import java.util.List;

//  https://www.lintcode.com/problem/1032/?fromId=29&_from=collection
public class _1LetterCasePermutationE {

  //  TC: O(2^n); SC: O(2^n * n)
  public static List<String> letterCasePermutation(String s) {
    List<String> ansList = new ArrayList<>();
    solve(ansList, s, 0);
    return ansList;
  }

  private static void solve(List<String> ansList, String s, int startIndex) {
    ansList.add(s);
    for (int i = startIndex; i < s.length(); i++) {
      if (Character.isDigit(s.charAt(i))) {
        continue;
      }
      //  if it is lower case, convert to upper case
      if (s.charAt(i) - 'a' >= 0) {
        solve(ansList,
            s.substring(0, i) + ((char) (s.charAt(i) - 'a' + 'A') + s.substring(i + 1)),
            i + 1);
      } else {
        solve(ansList,
            s.substring(0, i) + ((char) (s.charAt(i) - 'A' + 'a') + s.substring(i + 1)),
            i + 1);
      }
    }
  }

  public static void main(String[] args) {
    //  yup: letter case permutation: [a1b2, A1b2, A1B2, a1B2]
    System.out.println("yup: letter case permutation: " + letterCasePermutation(
        "a1b2"));
    //  yup: letter case permutation: [3z4, 3Z4]
    System.out.println("yup: letter case permutation: " + letterCasePermutation(
        "3z4"));
    //  yup: letter case permutation: [1234]
    System.out.println("yup: letter case permutation: " + letterCasePermutation(
        "1234"));
    //  yup: letter case permutation: [u8ii90p, U8ii90p, U8Ii90p, U8II90p, U8II90P, U8Ii90P, U8iI90p, U8iI90P, U8ii90P, u8Ii90p, u8II90p, u8II90P, u8Ii90P, u8iI90p, u8iI90P, u8ii90P]
    System.out.println("yup: letter case permutation: " + letterCasePermutation(
        "u8ii90p"));
  }
}
