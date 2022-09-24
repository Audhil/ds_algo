package _0dynamic_programming._neetcode.__1dDP;

//  https://youtu.be/_i4Yxeh5ceQ?t=4028
public class _5PalindromicSubstring_FINAL_WAY_M {

  //  TC: O (n^2) - https://youtu.be/_i4Yxeh5ceQ?t=4704

  public static int countSubstrings(String s) {
    int count = 0;
    int l, r;
    for (int i = 0; i < s.length(); i++) {
      //  odd length palindromes
      l = i;
      r = i;
      count += countPali(l, r, s);
      //  even length palindromes
      l = i;
      r = i + 1;
      count += countPali(l, r, s);
    }
    return count;
  }

  private static int countPali(int l, int r, String s) {
    int res = 0;
    while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
      res++;
      l--;
      r++;
    }
    return res;
  }

  public static void main(String[] args) {
    System.out.println("yup: countSubstrings palindromic : " + countSubstrings(
        "aaab"));  //  yup: countSubstrings palindromic : 7 -> a, a, a, b, aaa, aa, aa
    System.out.println("yup: countSubstrings palindromic : " + countSubstrings(
        "abc"));  //  yup: countSubstrings palindromic : 3 -> a b c
    System.out.println("yup: countSubstrings palindromic : " + countSubstrings(
        "aaa"));  //  yup: countSubstrings palindromic : 6 -> a, a, a, aaa, aa, aa
  }
}
