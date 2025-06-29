package _10Blind75._8Trie;

//  https://leetcode.com/problems/design-add-and-search-words-data-structure/
public class _0WordDictionaryM {

  private static class TNode {

    private final TNode[] links = new TNode[26];
    private boolean isEnd;

    private boolean containsKey(char ch) {
      return links[ch - 'a'] != null;
    }

    private void put(char ch, TNode tNode) {
      links[ch - 'a'] = tNode;
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

    //    this won't work for '.' char
//      TNode temp = root;
//    private boolean search(String word) {
//      for (char ch : word.toCharArray()) {
//        if (!temp.containsKey(ch)) {
//          return false;
//        }
//        temp = temp.get(ch);
//      }
//      return temp.getEnd();
//    }
    private boolean search(String word) {
      TNode temp = root;
      return find(word.toCharArray(), temp, 0);
    }

    private boolean find(char[] chars, TNode temp, int index) {
      if (temp == null) {
        return false;
      }
      if (index == chars.length) {
        return temp.getEnd();
      }
      char ch = chars[index];
      if (ch == '.') {
        for (char i = 'a'; i <= 'z'; i++) {
          if (temp.containsKey(i) && find(chars, temp.get(i), index + 1)) {
            return true;
          }
        }
      } else {
        return temp.containsKey(ch) && find(chars, temp.get(ch), index + 1);
      }
      return false;
    }
  }

  private static class WordDictionary {

    private final Trie trie;

    public WordDictionary() {
      trie = new Trie();
    }

    public void addWord(String word) {
      trie.insert(word);
    }

    public boolean search(String word) {
      return trie.search(word);
    }
  }

  public static void main(String[] args) {
    WordDictionary dictionary = new WordDictionary();
    dictionary.addWord("bad");
    dictionary.addWord("dad");
    dictionary.addWord("mad");
    System.out.println("yup: wordSearch: " + dictionary.search("pad")); //  false
    System.out.println("yup: wordSearch: " + dictionary.search("bad")); //  true
    System.out.println("yup: wordSearch: " + dictionary.search(".ad")); //  true
    System.out.println("yup: wordSearch: " + dictionary.search("b..")); //  true
    System.out.println("yup: wordSearch: " + dictionary.search("b..."));  //  false
    System.out.println("yup: wordSearch: " + dictionary.search("..."));  //  true
    System.out.println("yup: wordSearch: " + dictionary.search(".u."));  //  false
  }
}
