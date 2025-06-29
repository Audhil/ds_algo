package _16Trie;

import java.util.ArrayList;
import java.util.List;

//  https://leetcode.com/problems/search-suggestions-system/
public class _5SearchSuggestionSystemM {

  private static class TNode {

    private final TNode[] links = new TNode[26];
    private boolean isWord = false;


    public boolean containsKey(char ch) {
      return links[ch - 'a'] != null;
    }

    public void put(char ch, TNode tNode) {
      links[ch - 'a'] = tNode;
    }

    public TNode get(char ch) {
      return links[ch - 'a'];
    }

    public void setWord() {
      isWord = true;
    }

    public boolean isWord() {
      return isWord;
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
      temp.setWord();
    }

    private List<String> list;

    private void dfs(TNode temp, String prefix) {
      if (list.size() == 3) {
        return;
      }
      if (temp.isWord()) {
        list.add(prefix);
      }
      //  recursion
      for (char ch = 'a'; ch <= 'z'; ch++) {
        if (temp.containsKey(ch)) {
          dfs(temp.get(ch), prefix + ch);
        }
      }
    }

    public List<String> suggestionList(String prefix) {
      TNode temp = root;
      list = new ArrayList<>();
      for (char pch : prefix.toCharArray()) {
        if (!temp.containsKey(pch)) {
          return list;
        }
        temp = temp.get(pch);
      }
      dfs(temp, prefix);
      return list;
    }
  }

  public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
    Trie trie = new Trie();
    List<List<String>> resList = new ArrayList<>();
    for (String product : products) {
      trie.insert(product);
    }
    //  search
    StringBuilder stringBuilder = new StringBuilder();
    for (char ch : searchWord.toCharArray()) {
      stringBuilder.append(ch);
      if (!trie.suggestionList(stringBuilder.toString()).isEmpty()) {
        resList.add(trie.suggestionList(stringBuilder.toString()));
      }
    }
    return resList;
  }

  public static void main(String[] args) {
    //  [[mobile, moneypot, monitor], [mobile, moneypot, monitor], [mouse, mousepad], [mouse, mousepad], [mouse, mousepad]]
    System.out.println(
        suggestedProducts(new String[]{"mobile", "mouse", "moneypot", "monitor", "mousepad"},
            "mouse"));

    //  [[baggage, bags, banner], [baggage, bags, banner], [baggage, bags], [bags]]
    System.out.println(
        suggestedProducts(new String[]{"bags", "baggage", "banner", "box", "cloths"},
            "bags"));

    //  [[havana], [havana], [havana], [havana], [havana], [havana]]
    System.out.println(
        suggestedProducts(new String[]{"havana"},
            "havana"));

    //  []
    System.out.println(
        suggestedProducts(new String[]{"havana"},
            "tatiana"));
  }
}
