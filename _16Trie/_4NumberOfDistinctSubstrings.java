package _16Trie;

//  https://www.youtube.com/watch?v=RV0QeTyHZxo&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=4&ab_channel=takeUforward
public class _4NumberOfDistinctSubstrings {

  //  calculate total distinct substrings + empty substring

  //  Time complexity of brute force approach: https://youtu.be/RV0QeTyHZxo?list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&t=380
  //  TC: O (N^2 * log n), SC: O (N^3)

  //  TC: O(N^2), SC - don't consider, we cannot measure it, worst case will 26 -> 26 -> 26 ....
  private static class TNode {

    TNode[] links = new TNode[26];

    private boolean containsKey(char ch) {
      return links[ch - 'a'] != null;
    }

    private void put(char ch, TNode node) {
      links[ch - 'a'] = node;
    }

    private TNode get(char ch) {
      return links[ch - 'a'];
    }
  }

  private static class Trie {

    private final TNode root;

    public Trie() {
      root = new TNode();
    }

    public int distinctSubstrings(String word) {
      int distinctCount = 0;
      int n = word.length();
      for (int i = 0; i < n; i++) {
        TNode temp = root;  //  iterate from root always, for every ch considering for substring
        for (int j = i; j < n; j++) {
          char ch = word.charAt(j);
          if (!temp.containsKey(ch)) {
            temp.put(ch, new TNode());
            distinctCount++;
          }
          temp = temp.get(ch);
        }
      }
      return distinctCount;
    }
  }

  public static void main(String[] args) {
    Trie trie = new Trie();
    String word = "abab";
    int emptySubstringCount = 1;
    //  total substrings - a, ab, aba, abab, b, ba, bab, a, ab,b - 10 nos
    //  distinct substrings - a, ab, aba, abab, b, ba, bab - 7 nos
    System.out.println(
        "yup: no of distinct substrings including emptySubstring: " + (trie.distinctSubstrings(word)
            + emptySubstringCount));  //  yup: no of distinct substrings including emptySubstring: 8
  }
}
