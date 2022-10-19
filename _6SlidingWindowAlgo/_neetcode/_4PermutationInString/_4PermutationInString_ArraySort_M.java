package _6SlidingWindowAlgo._neetcode._4PermutationInString;

import java.util.Arrays;

public class _4PermutationInString_ArraySort_M {

  //  TC: O (n1 log n1 + (n2-n1) n1 log n1)
  //  SC: O (1)
  public static boolean checkInclusion(String s1, String s2) {
    s1 = sort(s1);
    for (int i = 0; i <= (s2.length() - s1.length()); i++) {
      if (s1.equals(sort(s2.substring(i, i + s1.length())))) {
        return true;
      }
    }
    return false;
  }

  private static String sort(String str) {
    char[] chArr = str.toCharArray();
    Arrays.sort(chArr);
    return new String(chArr);
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: permutation in string: " + checkInclusion("hello", "ooolleoooleh")); //  false
    System.out.println(
        "yup: permutation in string: " + checkInclusion("abc", "ccccbbbbaaaa")); //  false
    System.out.println("yup: permutation in string: " + checkInclusion("adc", "dcda"));  //  true
    System.out.println("yup: permutation in string: " + checkInclusion("abc", "bbbca")); //  true
    System.out.println(
        "yup: permutation in string: " + checkInclusion("abc", "cccccbabbbaaaa")); //  true
  }
}
