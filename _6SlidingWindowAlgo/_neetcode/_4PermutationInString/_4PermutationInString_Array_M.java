package _6SlidingWindowAlgo._neetcode._4PermutationInString;

public class _4PermutationInString_Array_M {

  //  TC: O (n1 + 26 n1 * (n2 - n1)); SC: O (1)
  public static boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) {
      return false;
    }
    int[] s1Arr = new int[26];
    for (char ch : s1.toCharArray()) {
      s1Arr[ch - 'a']++;
    }
    for (int i = 0; i <= s2.length() - s1.length(); i++) {
      int[] s2Arr = new int[26];
      for (int j = 0; j < s1.length(); j++) {
        s2Arr[s2.charAt(i + j) - 'a']++;
      }
      if (matches(s1Arr, s2Arr)) {
        return true;
      }
    }
    return false;
  }

  private static boolean matches(int[] s1Arr, int[] s2Arr) {
    for (int i = 0; i < 26; i++) {
      if (s1Arr[i] != s2Arr[i]) {
        return false;
      }
    }
    return true;
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
