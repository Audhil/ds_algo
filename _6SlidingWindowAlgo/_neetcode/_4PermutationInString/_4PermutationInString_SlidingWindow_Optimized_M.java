package _6SlidingWindowAlgo._neetcode._4PermutationInString;

public class _4PermutationInString_SlidingWindow_Optimized_M {

  //  TC: O (n1 + (n2-n1)); SC: O (1)
  public static boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) {
      return false;
    }
    int[] s1Arr = new int[26];
    int[] s2Arr = new int[26];
    for (int i = 0; i < s1.length(); i++) {
      s1Arr[s1.charAt(i) - 'a']++;
      s2Arr[s2.charAt(i) - 'a']++;
    }
    int matches = 0;
    for (int i = 0; i < 26; i++) {
      if (s1Arr[i] == s2Arr[i]) {
        matches++;
      }
    }
    for (int i = 0; i < (s2.length() - s1.length()); i++) {
      if (matches == 26) {
        return true;
      }
      int l = s2.charAt(i) - 'a';
      int r = s2.charAt(i + s1.length()) - 'a';
      s2Arr[r]++;
      if (s2Arr[r] == s1Arr[r]) {
        matches++;
      } else if (s2Arr[r] == s1Arr[r] + 1) {
        matches--;
      }
      s2Arr[l]--;
      if (s2Arr[l] == s1Arr[l]) {
        matches++;
      } else if (s2Arr[l] == s1Arr[l] - 1) {
        matches--;
      }
    }
    return matches == 26;
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
