package _0String._1rollingHash;

//  https://leetcode.com/problems/longest-chunked-palindrome-decomposition/
//  https://leetcode.com/problems/distinct-echo-substrings/
//  https://leetcode.com/problems/longest-duplicate-substring/
//  https://youtu.be/BQ9E-2umSWc
//  chcek https://github.com/naval41/CS_Tricks/blob/master/RollingHash.java
//  check https://gist.github.com/SuryaPratapK/a76f8d62a915e649023eb900a944c8fe
//  https://youtu.be/qgtAaQHKLx8?t=1581
public class _1RollingHash_SearchForPatternInString_RabinKarp_Algo {

  public static void main(String[] args) {
    //  Pattern found at index: 4
    //  Pattern found at index: 9
    String text = "BBCBABCNNABC";
    String pattern = "ABC";

    //  https://www.chilimath.com/lessons/introductory-algebra/list-of-prime-numbers-up-to-10000/
    int q = 5051; //  bigger prime number to make better hash code;
    searchPattern(text, pattern, q);
    System.out.println("yup: another: example");
    //  Pattern found at index: 0
    //  Pattern found at index: 10
    //  Pattern found at index: 15
    String txt = "GEEKS FOR GEEKSGEEK";
    String pat = "GEEK";
    searchPattern(txt, pat, q);
  }

  private static void searchPattern(String text, String pattern, int q) {
    int base = 26;  //  since we've 26 chars in alphabets
    int patHash = 0;
    int txtHash = 0;

    int M = pattern.length();
    int N = text.length();

    for (int i = 0; i < M; i++) {
      patHash *= base;
      patHash += (pattern.charAt(i) - 'A' + 1) % q;
      txtHash *= base;
      txtHash += (text.charAt(i) - 'A' + 1) % q;
    }

    //  sliding window
    int i, j;
    for (i = 0; i <= N - M; i++) {
      if (patHash == txtHash) {
        //  if hash matches, double check with chars - optional step, since we've good hash function, each str will have unique hash
        for (j = 0; j < M; j++) {
          if (text.charAt(j + i) != pattern.charAt(j)) {
            break;
          }
        }
        if (j == M) {
          System.out.println("Pattern found at index: " + i);
        }
      }
      if (i < N - M) {
        //  remove MSB hash contribution
        txtHash -= ((text.charAt(i) - 'A' + 1) * (int) (Math.pow(base, M - 1)));
        //  making a^1 -> a^2
        txtHash *= base;
        //  even txtHash += (text.charAt(i + M) - 'A' + 1); works fine
        txtHash += (text.charAt(i + M) - 'A' + 1) % q;
      }
    }
  }
}
