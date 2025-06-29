package _16Trie;

//  https://www.youtube.com/watch?v=AWnBa91lThI&list=PLgUwDviBIf0pcIDCZnxhv0LkHf5KzG9zp&index=5&ab_channel=takeUforward
public class _3LongestCompleteString {

  //  CompleteString = Longest Word With All Prefixes in the given array
  //  TC: O (N) * O (len of the string) - array has N items

  private static class TNode {

    private final TNode[] links = new TNode[26];
    private boolean isEnd;

    private boolean containsKey(char ch) {
      return links[ch - 'a'] != null;
    }

    private void put(char ch, TNode node) {
      links[ch - 'a'] = node;
    }

    private TNode get(char ch) {
      return links[ch - 'a'];
    }

    private void setEnd() {
      isEnd = true;
    }

    private boolean getEnd() {
      return isEnd;
    }
  }

  private static class Trie {

    private final TNode root;

    public Trie() {
      root = new TNode();
    }

    private void insert(String word) {
      TNode temp = root;
      for (char ch : word.toCharArray()) {
        if (!temp.containsKey(ch)) {
          temp.put(ch, new TNode());
        }
        temp = temp.get(ch);
      }
      temp.setEnd();
    }

    private boolean checkIfPrefixExists(String word) {
      TNode temp = root;
      boolean flag = true;
      for (char ch : word.toCharArray()) {
        if (!temp.containsKey(ch)) {
          return false;
        }
        temp = temp.get(ch);
        flag = flag & temp.getEnd();
      }
      return flag;
    }
  }

  private static String getLongestCompleteString(String[] words) {
    Trie trie = new Trie();
    for (String word : words) {
      trie.insert(word);
    }
    String longest = "";
    for (String word : words) {
      if (trie.checkIfPrefixExists(word)) {
        if (word.length() > longest.length()) {
          longest = word;
        } else if (word.length() == longest.length()
            //  will compare word in lexicographical order, smallest when compared lexicographically
            && word.compareTo(longest) < 0) {
          longest = word;
        }
      }
    }
    return longest.equals("") ? "None" : longest;
  }

  public static void main(String[] args) {
    System.out.println("yup: 1st getLongestCompleteString: " + getLongestCompleteString(
        new String[]{"n", "ni", "nin", "ninj", "ninja",
            "ninga"})); //  yup: 1st getLongestCompleteString: ninja
    System.out.println("yup: 2nd getLongestCompleteString: " + getLongestCompleteString(
        new String[]{"ab", "bc"})); //  yup: 2nd getLongestCompleteString: None
    System.out.println("yup: 3rd getLongestCompleteString: " + getLongestCompleteString(
        new String[]{"a", "ab", "abc"})); //  yup: 3rd getLongestCompleteString: abc
  }
}
