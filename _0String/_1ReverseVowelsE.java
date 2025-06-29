package _0String;

import java.util.Arrays;
import java.util.List;

//  https://leetcode.com/problems/reverse-vowels-of-a-string/
public class _1ReverseVowelsE {

  public static String reverseVowels(String s) {
    List<Character> vowelList = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
    char[] chArr = s.toCharArray();
    int l = 0, r = chArr.length - 1;
    int n = chArr.length;
    while (l < r) {
      while (l < n && !vowelList.contains(chArr[l])) {
        l++;
      }
      while (r >= 0 && !vowelList.contains(chArr[r])) {
        r--;
      }
      if (l < r) {
        char temp = chArr[l];
        chArr[l] = chArr[r];
        chArr[r] = temp;
        l++;
        r--;
      }
    }
    return String.valueOf(chArr);
  }

  public static void main(String[] args) {
    System.out.println(
        "yup: reverseVowels: " + reverseVowels("HellO"));  //  yup: reverseVowels: HOlle
    System.out.println("yup: reverseVowels: " + reverseVowels(
        "Jack and Jill went upto hill")); //  yup: reverseVowels: Jick ond Jull went ipta hall
  }
}
