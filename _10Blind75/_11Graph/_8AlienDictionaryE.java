package _10Blind75._11Graph;

//  https://www.lintcode.com/problem/1876/
//  https://www.youtube.com/watch?v=jK5a8T9q4pc&ab_channel=AlgorithmsMadeEasy
public class _8AlienDictionaryE {

  //  TC: O (M) - no of chars in all the words; SC: O (1)
  public static boolean isAlienSorted(String[] words, String order) {
    int[] mapping = new int[26];
    int seq = 0;
    for (char ch : order.toCharArray()) {
      mapping[ch - 'a'] = seq++;
    }
    for (int i = 0; i < words.length - 1; i++) {
      String curr = words[i];
      String next = words[i + 1];
      int len = Math.min(curr.length(), next.length());
      if (len != curr.length()
          && curr.startsWith(
          next)) {  //  if(len != curr.length() && len == next.length() && curr.startsWith(next)){
        return false;
      }
      for (int j = 0; j < len; j++) {
        if (mapping[curr.charAt(j) - 'a'] > mapping[next.charAt(j) - 'a']) {
          return false;
        }
        if (mapping[curr.charAt(j) - 'a'] < mapping[next.charAt(j) - 'a']) {
          break;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    System.out.println("yup: isSorted: " + isAlienSorted(new String[]{"hello", "leetcode"},
        "hlabcdefgijkmnopqrstuvwxyz")); //  yup: isSorted: true
    System.out.println("yup: isSorted: " + isAlienSorted(new String[]{"word", "world", "row"},
        "worldabcefghijkmnpqstuvxyz")); //  yup: isSorted: false
    System.out.println("yup: isSorted: " + isAlienSorted(new String[]{"apple", "app"},
        "abcdefghijklmnopqrstuvwxyz")); //  yup: isSorted: false
  }
}
