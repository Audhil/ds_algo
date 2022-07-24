package _16Trie;

import java.util.ArrayList;
import java.util.List;

//  https://leetcode.com/problems/search-suggestions-system/
public class _5SearchSuggestionSystemM {

  private static class TNode {

    private final TNode[] links = new TNode[26];
    private boolean flag = false;


    public boolean containsKey(char ch) {
      return links[ch - 'a'] != null;
    }

    public void put(char ch, TNode tNode) {
      links[ch - 'a'] = tNode;
    }

    public TNode get(char ch) {
      return links[ch - 'a'];
    }

    public void setEnd() {
      flag = true;
    }

    public boolean isEnd() {
      return flag;
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

    private String startsWith(String word) {
      TNode temp = root;

      return null;
    }
  }

  public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
    Trie trie = new Trie();
    List<List<String>> resList = new ArrayList<>();
    for (String product : products) {
      trie.insert(product);
    }

    return resList;
  }

  public static void main(String[] args) {

  }
}
